package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@AllArgsConstructor
@Setter
@Getter
@Value
//@Builder
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString;
        try {
            carAsString = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return carAsString;
        //return new String();
    }

    public static Car unserialize(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car;
        try {
            car = objectMapper.readValue(json, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
        //return new Car(12, "sadf", "dsf", "sdf", new User(456, "FDSF", "ASDF", 54));
    }
    // END
}
