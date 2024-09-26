package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax (int[] arrayIn) {
        Map<String, Integer> minMax = new HashMap<String, Integer>();
        MaxThread maxThread = new MaxThread(arrayIn);
        MinThread minThread = new MinThread(arrayIn);
        maxThread.start();
        minThread.start();
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        minMax.put("min", minThread.getMin());
        minMax.put("max", maxThread.getMax());
        return minMax;
    }
    // END
}
