package restaurant;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

import main.CPPFoodDelivery;
import restaurant.adapters.*;


public class Restaurant {
    private String name;
    private String address;
    private String county;
    private LocalTime openingTime;
    private LocalTime closingTime;

    private String cuisineType;
    private List<String> toppings; // Assume toppings are strings for simplicity
    private List<Meal> menu;

    private DietaryAdapter mealAdapter;

    private CPPFoodDelivery platform;

    private Restaurant(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.county = builder.county;
        this.openingTime = builder.openingTime;
        this.closingTime = builder.closingTime;
        this.cuisineType = builder.cuisineType;
        this.toppings = builder.toppings;
        this.menu = builder.menu;
        this.mealAdapter = builder.mealAdapter;
    }


    public boolean isOpen() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(openingTime) && !now.isAfter(closingTime);
    }

    public String getName(){
        return this.name;
    }
    public LocalTime getOpeningTime(){
        return this.openingTime;
    }
    public LocalTime getClosingTime(){
        return this.closingTime;
    }

    public String getCounty(){
        return this.county;
    }

    public Meal getMeal(int menuChoice, String dietaryRestrictions, String... toppings){
        Meal meal = menu.get(menuChoice);
        meal = mealAdapter.adaptMeal(meal, dietaryRestrictions);
        for(String topping: toppings){
            if(this.toppings.contains(topping))
                meal = new MealWithToppings(meal, topping);
            else
                System.out.println("Topping not present on the menu");
        }
        return meal;
    }

    public void setPlatform(CPPFoodDelivery platform) {
        this.platform = platform;
    }

    public static class Builder{
        private String name;
        private String address;
        private String county;
        private LocalTime openingTime;
        private LocalTime closingTime;
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

        public Builder operatingHours(String openingHours, String closingHours) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            this.openingTime = LocalTime.parse(openingHours, formatter);
            this.closingTime = LocalTime.parse(closingHours, formatter);
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
                            new BasicMeal("Margherita Pizza", "Cheese", "Wheat Crust", "Olive Oil"),
                            new BasicMeal("Pesto Pasta", "Chicken", "Wheat Pasta", "Pesto Sauce"),
                            new BasicMeal("Caprese Salad", "Mozzarella", "Tomato", "Basil"),
                            new BasicMeal("Minestrone Soup", "Mixed Vegetables", "Pasta", "Olive Oil")
                    );
                    toppings = Arrays.asList("Extra Cheese", "Pepperoni", "Olives");
                    mealAdapter = new ItalianRestaurantAdapter();
                    break;

                case "thai":
                    menu = Arrays.asList(
                            new BasicMeal("Sushi Roll", "Tuna", "Rice", "Seaweed"),
                            new BasicMeal("Stir Fry", "Beef", "Mixed Vegetables", "Soy Sauce"),
                            new BasicMeal("Ramen", "Pork", "Egg Noodles", "Broth"),
                            new BasicMeal("Rice Bowl", "Chicken", "Vegetables", "Rice")
                    );
                    toppings = Arrays.asList("Sesame Seeds", "Wasabi", "Soy Sauce");
                    mealAdapter = new ThaiRestaurantAdapter();
                    break;

                case "american diner":
                    menu = Arrays.asList(
                            new BasicMeal("Cheeseburger", "Beef Patty", "Wheat Bun", "Cheese"),
                            new BasicMeal("Club Sandwich", "Turkey", "Bread", "Bacon"),
                            new BasicMeal("Mac & Cheese", "Macaroni", "Cheese", "Butter"),
                            new BasicMeal("Fries and Wings Combo", "Chicken Wings", "Fries", "Barbecue Sauce")
                    );
                    toppings = Arrays.asList("Ketchup", "Pickles", "Mustard");
                    mealAdapter = new AmericanDinerAdapter();
                    break;

                case "mexican":
                    menu = Arrays.asList(
                            new BasicMeal("Chicken Taco", "Chicken", "Wheat Tortilla", "Lard"),
                            new BasicMeal("Beef Burrito", "Beef", "Wheat Tortilla", "Cheese"),
                            new BasicMeal("Pork Tostada", "Pork", "Corn Tortilla", "Lard"),
                            new BasicMeal("Quesadilla", "Cheese", "Wheat Tortilla", "Butter")
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
