package RestaurantTest;

import restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


public class RestaurantTest {
    Restaurant restaurant = new Restaurant.Builder()
            .name("Test restaurant")
            .address("123 Street")
            .operatingHours("10:00", "23:00")
            .county("LA County")
            .cuisineType("Thai")
            .build();
    LocalTime time = LocalTime.now();

    @Test
    public void testIsOpen() {
        boolean expected = time.isAfter(LocalTime.of(10, 0)) && time.isBefore(LocalTime.of(23, 0));
        boolean actual = restaurant.isOpen();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetCounty() {
        String expected = "LA County";
        String actual = restaurant.getCounty();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetMeal() {
        // TO-DO
    }

}
