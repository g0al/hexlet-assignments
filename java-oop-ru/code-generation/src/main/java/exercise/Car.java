package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car deserialize(String json) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Car.class);
    }
    // END
}
