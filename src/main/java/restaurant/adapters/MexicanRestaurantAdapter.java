package restaurant.adapters;

import restaurant.*;

import java.util.HashMap;
import java.util.Map;

public class MexicanRestaurantAdapter implements DietaryAdapter {
    private static final Map<String, String> veganSubstitutes;
    private static final Map<String, String> glutenFreeSubstitutes;

    static {
        veganSubstitutes = new HashMap<>();
        veganSubstitutes.put("Chicken", "Tofu");
        veganSubstitutes.put("Beef", "Jackfruit");
        veganSubstitutes.put("Pork", "Plant-Based Pork");
        veganSubstitutes.put("Cheese", "Vegan Cheese");
        veganSubstitutes.put("Lard", "Coconut Oil");

        glutenFreeSubstitutes = new HashMap<>();
        glutenFreeSubstitutes.put("Wheat Tortilla", "Corn Tortilla");
        glutenFreeSubstitutes.put("Pita Bread", "Corn Tortilla");
    }

    @Override
    public Meal adaptMeal(Meal originalMeal, String dietaryRestriction) {
        return DietaryAdapter.getMeal(originalMeal, dietaryRestriction, veganSubstitutes, glutenFreeSubstitutes);
    }
}