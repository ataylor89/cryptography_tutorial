import argparse.ArgumentParser;
import argparse.Options;
import argparse.Option;
import argparse.ParseResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Rot13 {

    public static final Map<Character, Character> table;

    static {
        table = new HashMap<>();
        int ord_a = (int) 'a';
        int ord_A = (int) 'A';
        for (int i = 0; i < 26; i++) {
            char source = (char) (ord_a + i);
            char target = (char) (ord_a + (i + 13) % 26);
            char Source = (char) (ord_A + i);
            char Target = (char) (ord_A + (i + 13) % 26);
            table.put(source, target);
            table.put(Source, Target);
        }
    }

    public static String rotate(String message) {
        StringBuilder builder = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (table.containsKey(ch)) {
                builder.append(table.get(ch));
            }
            else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ArgumentParser parser = new ArgumentParser();
        Options options = new Options();
        options.addOption("i", "inputfile", true, "Path to input file");
        options.addOption("o", "outputfile", true, "Path to output file");
        ParseResult result = parser.parse(options, args);
        String message = null;
        String inputfile = null;
        String outputfile = null;
        if (result.hasOption("i", "inputfile")) {
            Option option = result.getOption("i", "inputfile");
            inputfile = (String) option.getValue();    
        }
        if (result.hasOption("o", "outputfile")) {
            Option option = result.getOption("o", "outputfile");
            outputfile = (String) option.getValue();
        }
        if (result.getPositionalArgs().size() > 0) {
            message = result.getPositionalArgs().get(0);
        }
        if (message == null && inputfile == null) {
            System.out.println("A message or an input file is required.");
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
        String output = Rot13.rotate(message);
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
