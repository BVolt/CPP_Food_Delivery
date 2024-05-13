package RestaurantTest;

import restaurant.BasicMeal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicMealTest {
    BasicMeal meal = new BasicMeal("name", "protein", "carbs", "fats");

    @Test
    public void testGetName() {
        String expected = "name";
        String actual = meal.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProtein() {
        String expected = "protein";
        String actual = meal.getProtein();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCarbs() {
        String expected = "carbs";
        String actual = meal.getCarbs();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFats() {
        String expected = "fats";
        String actual = meal.getFats();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String expected = "Meal: name [Protein: protein, Carbs: carbs, Fats: fats]";
        String actual = meal.toString();
        assertEquals(expected, actual);
    }

}
