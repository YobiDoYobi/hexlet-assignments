package exercise;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;

// BEGIN
class App {
    public static <T> LinkedHashMap<String, String> genDiff(Map<String, T> map1, Map<String, T> map2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        keys.forEach(key -> {
            if (!map1.containsKey(key) & map2.containsKey(key)) {
                result.put(key, "added");
            } else if (map1.containsKey(key) & !map2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (map1.containsKey(key) & map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            }
        });
        return result;
    }
}
//END
