package argparse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseResult {
    
    private List<String> positionalArgs;
    private Map<String, String> options;

    public ParseResult() {
        this.positionalArgs = new ArrayList<>();
        this.options = new HashMap<>();
    }

    public void setPositionalArgs(List<String> positionalArgs) {
        this.positionalArgs = positionalArgs;
    }

    public List<String> getPositionalArgs() {
        return positionalArgs;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;        
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public String getPositionalArg(int index) {
        if (index < positionalArgs.size()) {
            return positionalArgs.get(index);
        }
        return null;
    }

    public <T> T getPositionalArg(int index, Class<T> type) {
        String arg = getPositionalArg(index);
        if (arg == null) {
            return type.cast(arg);
        }
        else if (type.equals(String.class)) {
            return type.cast(arg);
        }
        else if (type.equals(Integer.class)) {
            return type.cast(Integer.valueOf(arg));
        }
        else if (type.equals(Boolean.class)) {
            return type.cast(Boolean.valueOf(arg));
        }
        else {
            throw new IllegalArgumentException(type.getName() + " not supported");
        }
    }

    public String getOption(String longName) {
        return options.get(longName);
    }

    public <T> T getOption(String longName, Class<T> type) {
        String option = options.get(longName);
        if (option == null) {
            return type.cast(option);
        }
        else if (type.equals(String.class)) {
            return type.cast(option);
        }
        else if (type.equals(Integer.class)) {
            return type.cast(Integer.valueOf(option));
        }
        else if (type.equals(Boolean.class)) {
            return type.cast(Boolean.valueOf(option));
        }
        else {
            throw new IllegalArgumentException(type.getName() + " not supported");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Positional args\n");
        for (int i = 0; i < positionalArgs.size(); i++) {
            String arg = positionalArgs.get(i);
            builder.append("Arg ").append(i).append(": ").append(arg);
            if (i + 1 < positionalArgs.size()) {
                builder.append("\n");
            }
        }
        builder.append("\n\n").append("Options\n");
        int counter = 0;
        int size = options.size();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            builder.append(name).append(": ").append(value);
            if (counter + 1 < size) {
                builder.append("\n");
            }
            counter++;
        };
        return builder.toString();
    }
}
