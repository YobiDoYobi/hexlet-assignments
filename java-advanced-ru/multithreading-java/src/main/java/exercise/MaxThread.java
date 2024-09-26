package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private final int[] array;
    private int max;

    public MaxThread(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread MaxThread started");
        max = Arrays.stream(array).max().getAsInt();
    }
}
// END
