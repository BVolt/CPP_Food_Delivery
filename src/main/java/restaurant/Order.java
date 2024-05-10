package restaurant;

import main.*;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private String dietaryRestriction;
    private Meal meal;
    private DeliveryDriver driver;
    private  PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String state;


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
    }

    public Meal getMeal() {
        return meal;
    }
}
