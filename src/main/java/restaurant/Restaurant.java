package restaurant;

import java.util.*;
import restaurant.adapters.*;


public class Restaurant {
    private String name;
    private String address;
    private String county;
    private String operatingHours;
    private String cuisineType;
    private List<String> toppings; // Assume toppings are strings for simplicity
    private List<Meal> menu;

    private DietaryAdapter mealAdapter;

    private Restaurant(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.county = builder.county;
        this.operatingHours = builder.operatingHours;
        this.cuisineType = builder.cuisineType;
        this.toppings = builder.toppings;
        this.menu = builder.menu;
        this.mealAdapter = builder.mealAdapter;
    }


    public boolean isOpen(){
        return true;
    }

    public String getCounty(){
        return "";
    }

    public Meal getMeal(int menuChoice, String dietaryRestrictions, String... toppings){
        Meal meal = menu.get(menuChoice);
        return mealAdapter.adaptMeal(meal, dietaryRestrictions);
    }

    public static class Builder{
        private String name;
        private String address;
        private String county;
        private String operatingHours;
        private String cuisineType;
        private List<String> toppings = new ArrayList<>();
        private List<Meal> menu = new ArrayList<>();
        private DietaryAdapter mealAdapter;

        public Builder(){
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder address(String name) {
            this.address = address;
            return this;
        }

        public Builder county(String county) {
            this.county = county;
            return this;
        }

        public Builder operatingHours(String hours) {
            this.operatingHours = hours;
            return this;
        }

        public Builder cuisineType(String type) {
            this.cuisineType = type;
            return this;
        }

        public void buildMenuAndToppings() {
            switch (cuisineType.toLowerCase()) {
                case "italian":
                    menu = Arrays.asList(
                            new Meal("Margherita Pizza", "Cheese", "Wheat Crust", "Olive Oil"),
                            new Meal("Pesto Pasta", "Chicken", "Wheat Pasta", "Pesto Sauce"),
                            new Meal("Caprese Salad", "Mozzarella", "Tomato", "Basil"),
                            new Meal("Minestrone Soup", "Mixed Vegetables", "Pasta", "Olive Oil")
                    );
                    toppings = Arrays.asList("Extra Cheese", "Pepperoni", "Olives");
                    mealAdapter = new ItalianRestaurantAdapter();
                    break;

                case "thai":
                    menu = Arrays.asList(
                            new Meal("Sushi Roll", "Tuna", "Rice", "Seaweed"),
                            new Meal("Stir Fry", "Beef", "Mixed Vegetables", "Soy Sauce"),
                            new Meal("Ramen", "Pork", "Egg Noodles", "Broth"),
                            new Meal("Rice Bowl", "Chicken", "Vegetables", "Rice")
                    );
                    toppings = Arrays.asList("Sesame Seeds", "Wasabi", "Soy Sauce");
                    mealAdapter = new ThaiRestaurantAdapter();
                    break;

                case "american diner":
                    menu = Arrays.asList(
                            new Meal("Cheeseburger", "Beef Patty", "Wheat Bun", "Cheese"),
                            new Meal("Club Sandwich", "Turkey", "Bread", "Bacon"),
                            new Meal("Mac & Cheese", "Macaroni", "Cheese", "Butter"),
                            new Meal("Fries and Wings Combo", "Chicken Wings", "Fries", "Barbecue Sauce")
                    );
                    toppings = Arrays.asList("Ketchup", "Pickles", "Mustard");
                    mealAdapter = new AmericanDinerAdapter();
                    break;

                case "mexican":
                    menu = Arrays.asList(
                            new Meal("Chicken Taco", "Chicken", "Wheat Tortilla", "Lard"),
                            new Meal("Beef Burrito", "Beef", "Wheat Tortilla", "Cheese"),
                            new Meal("Pork Tostada", "Pork", "Corn Tortilla", "Lard"),
                            new Meal("Quesadilla", "Cheese", "Wheat Tortilla", "Butter")
                    );
                    toppings = Arrays.asList("Guacamole", "Sour Cream", "Salsa");
                    mealAdapter = new MexicanRestaurantAdapter();
                    break;

                default:
                    System.out.println("Cuisine type not recognized.");
                    menu = new ArrayList<>();
                    toppings = new ArrayList<>();
                    break;
            }
        }

        public Restaurant build() {
            this.buildMenuAndToppings();
            return new Restaurant(this);
        }
    }

}
