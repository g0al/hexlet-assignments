package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homeList, int count) {
        return homeList.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(count)
                .map(Object::toString)
                .toList();
    }
}
// END
