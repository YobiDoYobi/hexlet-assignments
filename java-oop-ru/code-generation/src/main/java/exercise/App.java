package exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        String str = car.serialize();
        byte[] strToBytes = str.getBytes();
        Files.write(path, strToBytes);
    }

    public static Car extract(Path path) throws IOException {
        String s = Files.readString(path);
        return Car.unserialize(s);
    }
}
// END
