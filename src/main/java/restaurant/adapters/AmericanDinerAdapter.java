package restaurant.adapters;

import java.util.HashMap;
import java.util.Map;
import restaurant.*;

public class AmericanDinerAdapter implements DietaryAdapter {
    private static final Map<String, String> veganSubstitutes;
    private static final Map<String, String> glutenFreeSubstitutes;

    static {
        veganSubstitutes = new HashMap<>();
        veganSubstitutes.put("Beef Patty", "Plant-Based Patty");
        veganSubstitutes.put("Turkey", "Plant-Based Patty");
        veganSubstitutes.put("Chicken", "Plant-Based Patty");
        veganSubstitutes.put("Bacon", "Vegan Bacon");
        veganSubstitutes.put("Cheese", "Vegan Cheese");
        veganSubstitutes.put("Wheat Bun", "Gluten-Free Bun");
        veganSubstitutes.put("Bread", "Gluten-Free Bread");

        glutenFreeSubstitutes = new HashMap<>();
        glutenFreeSubstitutes.put("Wheat Bun", "Gluten-Free Bun");
        glutenFreeSubstitutes.put("Bread", "Gluten-Free Bread");
        glutenFreeSubstitutes.put("Macaroni", "Rice Macaroni");
    }

    @Override
    public Meal adaptMeal(Meal originalMeal, String dietaryRestriction) {
        return DietaryAdapter.getMeal(originalMeal, dietaryRestriction, veganSubstitutes, glutenFreeSubstitutes);
    }
}
