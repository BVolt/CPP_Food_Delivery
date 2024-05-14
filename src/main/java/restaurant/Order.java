package restaurant;

import Customer.Customer;
import Delivery.DeliveryDriver;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private String dietaryRestriction;
    private Meal meal;
    private DeliveryDriver driver;
    private  PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String state;
    private LocalDateTime creationTime;

    private LocalDateTime pickUpTime;

    private LocalDateTime deliveredTime;


    public Order(Restaurant restaurant, Customer customer, Meal meal, DeliveryDriver driver) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.dietaryRestriction = customer.getDietaryRestriction();
        this.meal = meal;
        this.driver = driver;
        addObserver(customer);
        setState("Ready For Pickup");
    }

    public void addObserver(PropertyChangeListener observer){
        support.addPropertyChangeListener(observer);
    }

    public void setState(String state){
        support.firePropertyChange("state", this.state, state);
        this.state = state;
        if(state.equals("Ready For Pickup")){
            this.creationTime = LocalDateTime.now();
        }else if(state.equals("Order Out For Delivery")){
            this.pickUpTime = LocalDateTime.now();
        }else {
            this.deliveredTime = LocalDateTime.now();
        }
    }

    public DeliveryDriver getDriver(){
        return this.driver;
    }

    public Meal getMeal() {
        return meal;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return "Order Details:\n" +
                "- Restaurant: " + restaurant.getName() + "\n" +
                "- Customer: " + customer.getName() + "\n" +
                "- Dietary Restriction: " + dietaryRestriction + "\n" +
                "- " + meal + "\n" +
                "- Driver: " + driver.getName() + "\n" +
                "- Status: " + state + "\n" +
                "- Creation Time: " + (creationTime != null ? dtf.format(creationTime) : "N/A") + "\n" +
                "- Pick Up Time: " + (pickUpTime != null ? dtf.format(pickUpTime) : "N/A") + "\n" +
                "- Delivered Time: " + (deliveredTime != null ? dtf.format(deliveredTime) : "N/A") + "\n";
    }

}
