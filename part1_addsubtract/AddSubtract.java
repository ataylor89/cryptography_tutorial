import argparse.ArgumentParser;
import argparse.Option;
import argparse.Options;
import argparse.ParseException;
import argparse.ParseResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class AddSubtract {

    public AddSubtract() {}

    public String encrypt(String message, Integer key, boolean base64) {
        // Encrypt the message
        char[] input = message.toCharArray();
        char[] output = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            int source = (int) input[i];
            int target = source + key.intValue();
            output[i] = (char) target;
        }
        // If base64 encoding is required, encode the result
        if (base64) {
            String encrypted = new String(output);
            byte[] encoded = Base64.getEncoder().encode(encrypted.getBytes());
            return new String(encoded);
        }
        // Else, return the unencoded result
        return new String(output);
    }

    public String decrypt(String message, Integer key, boolean base64) {
        // If base64 decoding is required, decode the message
        if (base64) {
            byte[] buffer = Base64.getDecoder().decode(message.getBytes());
            message = new String(buffer);
        }
        // Decrypt the message
        char[] input = message.toCharArray();
        char[] output = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            int source = (int) input[i];
            int target = source - key.intValue();
            output[i] = (char) target;
        }
        return new String(output);
    }

    public static void main(String[] args) {
        String message = null;
        Integer key = null;
        String inputfile = null;
        String outputfile = null;
        Boolean encrypt = null;
        Boolean decrypt = null;
        try {
            ArgumentParser parser = new ArgumentParser();
            Options options = new Options();
            options.addOption("k", "key", true, Integer.class, "Single-integer key");
            options.addOption("i", "inputfile", true, "Path to input file");
            options.addOption("o", "outputfile", true, "Path to output file");
            options.addOption("e", "encrypt", false, Boolean.class, "Encrypt");
            options.addOption("d", "decrypt", false, Boolean.class, "Decrypt");
            ParseResult result = parser.parse(options, args);
            message = result.getPositionalArg(0);
            key = result.getParsedOptionValue("key");
            inputfile = result.getParsedOptionValue("inputfile");
            outputfile = result.getParsedOptionValue("outputfile");
            encrypt = result.getParsedOptionValue("encrypt", false);
            decrypt = result.getParsedOptionValue("decrypt", false);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        if (message == null && inputfile == null) {
            System.out.println("A message or an input file is required.");
            System.exit(1);
        }
        if (key == null) {
            System.out.println("A key is required.");
            System.exit(1);
        }
        if (!(encrypt ^ decrypt)) {
            System.out.println("The encrypt flag or the decrypt flag must be set, but not both");
            System.exit(1);
        }
        if (message == null && inputfile != null) {
            Path path = Path.of(inputfile);
            try {
                message = Files.readString(path);
            } catch (IOException e) {
                System.out.println(e);
                System.exit(1);
            }
        }
        AddSubtract as = new AddSubtract();
        String output = null;
        if (encrypt) {
            output = as.encrypt(message, key, true);
        }
        else {
            output = as.decrypt(message, key, true);
        }
        if (outputfile == null) {
            System.out.println(output);
        }
        else {
            Path path = Path.of(outputfile);
            try {
                Files.writeString(path, output);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
