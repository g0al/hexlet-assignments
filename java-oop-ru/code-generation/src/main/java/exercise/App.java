package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String line = car.serialize();
        Files.writeString(path, line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static Car extract(Path path) throws IOException {
        String pathToCar = Files.readString(path);
        return Car.deserialize(pathToCar);
    }
}
// END
