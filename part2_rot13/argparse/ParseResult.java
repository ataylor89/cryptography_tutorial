package argparse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseResult {
    
    private List<String> positionalArgs;
    private Map<String, Object> options;

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

    public void setOptions(Map<String, Object> options) {
        this.options = options;        
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public String getPositionalArg(int index) {
        if (index < positionalArgs.size()) {
            return positionalArgs.get(index);
        }
        return null;
    }

    public Object getOption(String longName) {
        return options.get(longName);
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
        for (Map.Entry<String, Object> entry : options.entrySet()) {
            String name = entry.getKey();
            Object value = entry.getValue();
            builder.append(name).append(": ").append(value);
            if (counter + 1 < size) {
                builder.append("\n");
            }
            counter++;
        };
        return builder.toString();
    }
}
