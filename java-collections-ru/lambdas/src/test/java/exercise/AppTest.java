package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testEnlargeArrayImage() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] largeImage = App.enlargeArrayImage(image);
        String[][] imageExpected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };
        assertThat(Arrays.deepEquals(largeImage, imageExpected));
    }

    @Test
    void testEnlargeArrayImage2() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
        };
        String[][] largeImage = App.enlargeArrayImage(image);
        String[][] imageExpected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"}
        };
        assertThat(Arrays.deepEquals(largeImage, imageExpected));
    }
}
// END
