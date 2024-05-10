package restaurant.adapters;
import restaurant.*;
import java.util.HashMap;
import java.util.Map;

public class ThaiRestaurantAdapter  implements DietaryAdapter {
        private static final Map<String, String> veganSubstitutes;
        private static final Map<String, String> glutenFreeSubstitutes;

        static {
            veganSubstitutes = new HashMap<>();
            veganSubstitutes.put("Tuna", "Tofu");
            veganSubstitutes.put("Beef", "Edamame");
            veganSubstitutes.put("Pork", "Tofu");
            veganSubstitutes.put("Chicken", "Tofu");
            veganSubstitutes.put("Egg Noodles", "Rice Noodles");
            veganSubstitutes.put("Soy Sauce", "Tamari");

            glutenFreeSubstitutes = new HashMap<>();
            glutenFreeSubstitutes.put("Soy Sauce", "Tamari");
            glutenFreeSubstitutes.put("Egg Noodles", "Rice Noodles");
        }

        @Override
        public Meal adaptMeal(Meal originalMeal, String dietaryRestriction) {
            return DietaryAdapter.getMeal(originalMeal, dietaryRestriction, veganSubstitutes, glutenFreeSubstitutes);
        }
    }