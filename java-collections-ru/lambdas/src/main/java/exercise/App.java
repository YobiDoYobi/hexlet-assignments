package exercise;

import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] strings) {
        String[] flatIn = Stream.of(strings)
                .flatMap(Stream::of)
                .toArray(String[]::new);
        int sourceRowLength = strings[0].length;
        int sourceCountRows = strings.length;
        String[][] stringsOut = new String[sourceCountRows * 2][sourceRowLength * 2];
        //String[] flatOut = new String[sourceCountRows * 2 * sourceRowLength * 2];
        int currIndex = 0;
        for (int y = 0; y < stringsOut.length; y += 2) {
            for (int x = 0; x < stringsOut[y].length; x += 2) {
                stringsOut[y][x] = flatIn[currIndex];
                stringsOut[y][x + 1] = flatIn[currIndex];
                stringsOut[y + 1][x] = flatIn[currIndex];
                stringsOut[y + 1][x + 1] = flatIn[currIndex];
                currIndex++;
            }
        }
        return stringsOut;
    }
}
// END
