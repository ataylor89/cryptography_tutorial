import argparse.ArgumentParser;
import argparse.Option;
import argparse.Options;
import argparse.ParseException;
import argparse.ParseResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Xor {

    public Xor() {}

    public String encrypt(String plaintext, String key, boolean base64) {
        if (base64) {
            String encrypted = xor(plaintext, key);
            byte[] encoded = Base64.getEncoder().encode(encrypted.getBytes());
            return new String(encoded);
        }
        return xor(plaintext, key);
    }

    public String decrypt(String ciphertext, String key, boolean base64) {
        if (base64) {
            byte[] buffer = Base64.getDecoder().decode(ciphertext.getBytes());
            String decoded = new String(buffer);
            return xor(decoded, key);
        }
        return xor(ciphertext, key);
    }

    public String xor(String message, String key) {
        char[] m = message.toCharArray();
        char[] k = key.toCharArray();
        int msglen = m.length;
        int keylen = k.length;
        char[] result = new char[msglen];
        for (int i = 0; i < msglen; i++) {
            result[i] = (char) (m[i] ^ k[i % keylen]);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String message = null;
        String key = null;
        String inputfile = null;
        String keyfile = null;
        String outputfile = null;
        Boolean encrypt = null;
        Boolean decrypt = null;
        try {
            ArgumentParser parser = new ArgumentParser();
            Options options = new Options();
            options.addOption("k", "key", true, "Key");
            options.addOption("if", "inputfile", true, "Path to input file");
            options.addOption("kf", "keyfile", true, "Path to keyfile");
            options.addOption("of", "outputfile", true, "Path to output file");
            options.addOption("e", "encrypt", false, Boolean.class, "Encrypt");
            options.addOption("d", "decrypt", false, Boolean.class, "Decrypt");
            ParseResult result = parser.parse(options, args);
            message = result.getPositionalArg(0);
            key = result.getParsedOptionValue("key");
            inputfile = result.getParsedOptionValue("inputfile");
            keyfile = result.getParsedOptionValue("keyfile");
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
        if (key == null && keyfile == null) {
            System.out.println("A key or a keyfile is required.");
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
        if (key == null && keyfile != null) {
            Path path = Path.of(inputfile);
            try {
                key = Files.readString(path);
            } catch (IOException e) {
                System.out.println(e);
                System.exit(1);
            }
        }
        Xor xor = new Xor();
        String output = null;
        if (encrypt) {
            output = xor.encrypt(message, key, true);
        }
        else {
            output = xor.decrypt(message, key, true);
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
