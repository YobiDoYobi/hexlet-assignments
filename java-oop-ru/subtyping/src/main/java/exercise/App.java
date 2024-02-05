package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Map<String, String> map = new HashMap<>();
        keyValueStorage.toMap().forEach((k, v) -> {
            map.put(v, k);
            keyValueStorage.unset(k);
        });
        map.forEach(keyValueStorage::set);
    }
}
// END
