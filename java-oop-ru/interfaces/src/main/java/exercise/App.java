package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int nums) {
        return homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(nums)
                .map(Object::toString)
                .toList();
    }
}
// END
