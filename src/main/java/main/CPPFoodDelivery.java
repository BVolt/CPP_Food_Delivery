package main;


import restaurant.*;
import java.util.*;

public class CPPFoodDelivery {
    private static CPPFoodDelivery platform;
    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<DeliveryDriver> drivers;

    private CPPFoodDelivery(){
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        drivers = new ArrayList<>();
    }

    public static CPPFoodDelivery getInstance(){
        if(platform == null){
            platform = new CPPFoodDelivery();
        }
        return platform;
    }

    public void register(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public void register(Customer customer){
        customers.add(customer);
    }
    public void register(DeliveryDriver driver){
        drivers.add(driver);
    }

    public Order placeOrder(Restaurant restaurant, Customer customer, int MenuChoice, String... toppings){
        //Check if open
        if(!restaurant.isOpen()){
            System.out.println("restaurant.Restaurant is not open!");
            return null;
        }

        //Find available driver
        DeliveryDriver driver = findDeliveryDriver(restaurant);
        if(driver == null){
            System.out.println("No available delivery driver");
            return null;
        }

        //Adapted restaurant.Meal with Toppings
        Meal meal = restaurant.getMeal(MenuChoice, customer.getDietaryRestriction() , toppings);
        System.out.println(meal);

        return new Order(restaurant, customer, meal, driver);

    }

    public DeliveryDriver findDeliveryDriver(Restaurant restaurant) {
        for (DeliveryDriver driver : drivers) {
            if (driver.isOnShift() && driver.getCounty().equals(restaurant.getCounty())) {
                return driver;
            }
        }
        return null;
    }

}
