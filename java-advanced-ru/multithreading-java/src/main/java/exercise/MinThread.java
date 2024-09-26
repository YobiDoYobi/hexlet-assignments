package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private int[] array;
    private int min;

    public MinThread(int[] array) {
        this.array = array;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread MinThread started");
        min = Arrays.stream(array).min().getAsInt();
    }
}
// END
