package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> attr;

    Tag(String name, Map<String, String> attr) {
        this.name = name;

        this.attr = new LinkedHashMap<>(attr) {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                forEach((key, value) -> sb.append(key)
                        .append("=\"")
                        .append(value)
                        .append("\" "));
                return sb.toString().trim();
            }
        };
    }
}
// END
