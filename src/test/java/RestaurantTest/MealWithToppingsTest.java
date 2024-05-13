package RestaurantTest;

import restaurant.BasicMeal;
import restaurant.MealWithToppings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealWithToppingsTest {
    BasicMeal meal = new BasicMeal("name", "protein", "carbs", "fats");
    MealWithToppings mealWithToppings = new MealWithToppings(meal, "topping");

    @Test
    public void testGetName() {
        String expected = "name";
        String actual = mealWithToppings.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProtein() {
        String expected = "protein";
        String actual = mealWithToppings.getProtein();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCarbs() {
        String expected = "carbs";
        String actual = mealWithToppings.getCarbs();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFats() {
        String expected = "fats";
        String actual = mealWithToppings.getFats();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String expected = "Meal: name [Protein: protein, Carbs: carbs, Fats: fats], added topping";
        String actual = mealWithToppings.toString();
        assertEquals(expected, actual);
    }
}
