package Customer;

import main.CPPFoodDelivery;
import restaurant.Order;
import restaurant.Restaurant;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Customer implements PropertyChangeListener {
    private CPPFoodDelivery deliveryPlatform;
    private String dietaryRestrictions;

    public Customer(CPPFoodDelivery deliveryPlatform, String dietaryRestrictions) {
        this.deliveryPlatform = deliveryPlatform;
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getDietaryRestriction(){
        return dietaryRestrictions;
    }


    public Order placeOrder(Restaurant restaurant, int menuChoice, String... toppings){
        return deliveryPlatform.placeOrder(restaurant, this, menuChoice, toppings);
    }

    public void propertyChange(PropertyChangeEvent event){
        System.out.println(event.getNewValue());
    }

    public void setPlatform(CPPFoodDelivery platform){
        this.deliveryPlatform = platform;
    }

}
