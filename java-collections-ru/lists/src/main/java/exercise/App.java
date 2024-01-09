package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    /*public static boolean scrabble(String symbols, String word) {
        if (symbols.length() < word.length()) {
            return false;
        }
        //char[] wordCopy = word.toCharArray();
        char[] symbolsCopy = symbols.toLowerCase().toCharArray();
        int countSymbols = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            for (int i = 0; i < symbolsCopy.length; i++) {
                if (ch == symbolsCopy[i]) {
                    symbolsCopy[i] = 0;
                    countSymbols++;
                    break;
                }
            }
        }
        return word.length() == countSymbols;
    }*/
    public static boolean scrabble(String symbols, String word) {
        if (symbols.length() < word.length()) {
            return false;
        }
        Map<Character, Integer> countCharacters = new HashMap<>();
        for (char c : symbols.toLowerCase().toCharArray()) {
            countCharacters.compute(c, (key, count) -> count == null ? 1 : count + 1);
        }
        for (char c : word.toLowerCase().toCharArray()) {
            if (!countCharacters.containsKey(c)) {
                return false;
            }
            if (countCharacters.get(c) <= 0) {
                countCharacters.remove(c);
                return false;
            }
            countCharacters.compute(c, (key, count) -> count == null ? 1 : count - 1);
        }
        return true;
    }
}
//END
