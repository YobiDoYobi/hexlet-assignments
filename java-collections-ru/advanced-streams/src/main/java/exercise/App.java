package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String str) {
        List<String> list = List.of(str.split("\n"));
        String result = list.stream()
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\"")))
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(s -> s.startsWith("X_FORWARDED"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
        System.out.println(result);
        return result;
    }

}
//END


//environment="X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en"
//environment="key5=value5,X_FORWARDED_var3=value,key6=value6"