package restaurant.adapters;

import restaurant.*;
import java.util.HashMap;
import java.util.Map;

public class  ItalianRestaurantAdapter implements DietaryAdapter {
    private static final Map<String, String> veganSubstitutes;
    private static final Map<String, String> glutenFreeSubstitutes;

    static {
        veganSubstitutes = new HashMap<>();
        veganSubstitutes.put("Cheese", "Vegan Cheese");
        veganSubstitutes.put("Chicken", "Tofu");
        veganSubstitutes.put("Wheat Crust", "Gluten-Free Crust");
        veganSubstitutes.put("Wheat Pasta", "Gluten-Free Pasta");

        glutenFreeSubstitutes = new HashMap<>();
        glutenFreeSubstitutes.put("Wheat Crust", "Gluten-Free Crust");
        glutenFreeSubstitutes.put("Wheat Pasta", "Gluten-Free Pasta");
    }

    @Override
    public Meal adaptMeal(Meal originalMeal, String dietaryRestriction) {
        return DietaryAdapter.getMeal(originalMeal, dietaryRestriction, veganSubstitutes, glutenFreeSubstitutes);
    }
}