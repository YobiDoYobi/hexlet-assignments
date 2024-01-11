package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbersIn = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> numbersOut = App.take(numbersIn, 2);
        List<Integer> expectingOut = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(numbersOut.containsAll(expectingOut));

        List<Integer> numbersIn2 = new ArrayList<>(Arrays.asList());
        List<Integer> numbersOut2 = App.take(numbersIn, 2);
        List<Integer> expectingOut2 = new ArrayList<>();
        assertThat(numbersOut2.containsAll(expectingOut2));

        List<Integer> numbersIn3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> numbersOut3 = App.take(numbersIn, 20);
        List<Integer> expectingOut3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(numbersOut3.containsAll(expectingOut3));
        // END
    }
}
