package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    Map<String, String> map = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        this.map.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        this.map.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
