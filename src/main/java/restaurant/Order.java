package restaurant;

import Customer.Customer;
import Delivery.DeliveryDriver;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.*;

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
        return "Order{" +
                "restaurant=" + restaurant +
                ", customer=" + customer +
                ", dietaryRestriction='" + dietaryRestriction + '\'' +
                ", meal=" + meal +
                ", driver=" + driver +
                ", support=" + support +
                ", state='" + state + '\'' +
                ", creationTime=" + creationTime +
                ", pickUpTime=" + pickUpTime +
                ", deliveredTime=" + deliveredTime +
                '}';
    }
}
