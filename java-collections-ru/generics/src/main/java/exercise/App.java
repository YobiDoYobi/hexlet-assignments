package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        books.forEach(book -> {
            boolean equal = true;
            for (Entry<String, String> filter_attr : where.entrySet()) {
                if (!book.get(filter_attr.getKey()).equals(filter_attr.getValue())) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                result.add(book);
            }
        });
        return result;
    }
}
//END
