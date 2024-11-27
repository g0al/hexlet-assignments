package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> database;

    InMemoryKV(Map<String, String> database) {
        this.database = new HashMap<String, String>(database);
    }

    public void set(String key, String value) {
        database.put(key, value);
    }

    public void unset(String key) {
        database.remove(key);
    }

    public String get(String key, String defaultValue) {
        return database.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(database);
    }
}
// END
