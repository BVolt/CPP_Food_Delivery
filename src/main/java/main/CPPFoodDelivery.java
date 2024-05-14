package main;


import Customer.Customer;
import Delivery.DeliveryDriver;
import restaurant.*;
import java.util.*;

public class CPPFoodDelivery {
    private static CPPFoodDelivery platform;
    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<DeliveryDriver> drivers;

    private Map<DeliveryDriver, Order> assignedOrders;

    private CPPFoodDelivery(){
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        drivers = new ArrayList<>();
        assignedOrders = new HashMap<>();
    }

    public static CPPFoodDelivery getInstance(){
        if(platform == null){
            platform = new CPPFoodDelivery();
        }
        return platform;
    }

    public void register(Restaurant restaurant){
        restaurants.add(restaurant);
        restaurant.setPlatform(this);
    }

    public void register(Customer customer){
        customers.add(customer);
        customer.setPlatform(this);
    }
    public void register(DeliveryDriver driver){
        drivers.add(driver);
        driver.setPlatform(this);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<DeliveryDriver> getDrivers() {
        return drivers;
    }

    public Order placeOrder(Restaurant restaurant, Customer customer, int MenuChoice, String... toppings){

        System.out.println(customer.getName() + " created a new order.");

        if(!customers.contains(customer)){
            System.out.println("Customer not registered");
            return null;
        }

        if(!restaurants.contains(restaurant)){
            System.out.println("Restaurant not registerd");
            return null;
        }

        //Check if open
        if(!restaurant.isOpen()){
            System.out.println("Restaurant is not open!");
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

        Order order = new Order(restaurant, customer, meal, driver);
        assignedOrders.put(driver, order);

        System.out.println("Driver assigned: " + driver.getName());

        return order;
    }

    public DeliveryDriver findDeliveryDriver(Restaurant restaurant) {
        for (DeliveryDriver driver : drivers) {
            if (driver.isOnShift() && driver.getCounty().equals(restaurant.getCounty()) && !assignedOrders.containsKey(driver)) {
                return driver;
            }
        }
        return null;
    }

    public void pickUpOrder(DeliveryDriver driver){
        Order order = assignedOrders.get(driver);
        order.setState("Order Out For Delivery");
    }

    public void deliverOrder(DeliveryDriver driver){
        Order order = assignedOrders.get(driver);
        order.setState("Order Delivered");
        assignedOrders.remove(driver);
    }
}
