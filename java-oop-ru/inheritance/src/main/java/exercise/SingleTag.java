package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }

    @Override
    public String toString() {
        if (attr.isEmpty()) {
            return String.format(
                    "<%s>", name
            );
        }
        return String.format(
                "<%s %s>",
                name, attr
        );
    }
}
// END
