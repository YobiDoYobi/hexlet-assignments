package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.trim().toLowerCase().split(" ");
        Map<String, Integer> result = new HashMap<>();
        if (!sentence.isEmpty()) {
            result = Arrays.stream(words)
                    .collect(Collectors.groupingBy(word -> word,
                            Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        }
        //System.out.println(result);
        return result;
    }

    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder("{\n");
        words.forEach((word, count) -> result.append("  " + word + ": " + count + '\n'));
        result.append("}");
        return result.toString();
    }
}
//END
