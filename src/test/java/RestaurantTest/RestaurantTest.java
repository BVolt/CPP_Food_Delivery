package RestaurantTest;
import restaurant.*;
import restaurant.Restaurant;
import org.junit.jupiter.api.Test;


import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

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
    public void testGetName() {
        String expected = "Test restaurant";
        String actual = restaurant.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetOpeningTime() {
        LocalTime expected = LocalTime.of(10,0);
        LocalTime actual = restaurant.getOpeningTime();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetClosingTime() {
        LocalTime expected = LocalTime.of(23,0);
        LocalTime actual = restaurant.getClosingTime();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetMeal() {
        Meal expected = new BasicMeal("Vegan adapted Stir Fry", "Edamame", "Mixed Vegetables", "Soy Sauce");
        Meal actual = restaurant.getMeal(1, "Vegan");

        String [] expectedArray = {expected.getName(), expected.getProtein(), expected.getCarbs(), expected.getFats()};
        String [] actualArray = {actual.getName(), actual.getProtein(), actual.getCarbs(), actual.getFats()};
        assertArrayEquals(expectedArray, actualArray);
    }

}
