package restaurant.adapters;

import restaurant.*;

import java.util.Map;

public interface DietaryAdapter {
    Meal adaptMeal(Meal originalMeal, String dietaryRestriction);

    static Meal getMeal(Meal originalMeal, String dietaryRestriction, Map<String, String> veganSubstitutes, Map<String, String> glutenFreeSubstitutes) {
        Map<String, String> substitutes = null;

        if (dietaryRestriction.equalsIgnoreCase("Vegan")) {
            substitutes = veganSubstitutes;
        } else if (dietaryRestriction.equalsIgnoreCase("Gluten-Free")) {
            substitutes = glutenFreeSubstitutes;
        }

        if (substitutes != null) {
            String adaptedProtein = substitutes.getOrDefault(originalMeal.getProtein(), originalMeal.getProtein());
            String adaptedCarbs = substitutes.getOrDefault(originalMeal.getCarbs(), originalMeal.getCarbs());
            String adaptedFats = originalMeal.getFats();

            return new Meal(dietaryRestriction+" adapted " + originalMeal.getName(), adaptedProtein, adaptedCarbs, adaptedFats);
        }

        return originalMeal;
    }
}
