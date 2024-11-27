package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage database) {
        Map<String, String> copy = new HashMap<>(database.toMap());

        for (Entry<String, String> pair : copy.entrySet()) {
            database.unset(pair.getKey());
            database.set(pair.getValue(), pair.getKey());
        }
    }
}
// END
