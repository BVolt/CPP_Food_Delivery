package Customer;

import main.CPPFoodDelivery;
import restaurant.Order;
import restaurant.Restaurant;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Customer implements PropertyChangeListener {
    private CPPFoodDelivery deliveryPlatform;
    private String name;
    private String address;
    private String county;
    private String dietaryRestrictions;

    private Customer(Builder builder) {
        this.deliveryPlatform = builder.deliveryPlatform;
        this.name = builder.name;
        this.address = builder.address;
        this.county = builder.county;
        this.dietaryRestrictions = builder.dietaryRestrictions;
    }

    public String getName() {return name;}

    public String getAddress() {return address;}

    public String getCounty() {return county;}

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

    public static class Builder {
        private CPPFoodDelivery deliveryPlatform;
        private String name;
        private String address;
        private String county;
        private String dietaryRestrictions;

        public Builder(){
        }

        public Builder deliveryPlatform(CPPFoodDelivery deliveryPlatform) {
            this.deliveryPlatform = deliveryPlatform;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder county(String county) {
            this.county = county;
            return this;
        }

        public Builder dietaryRestrictions(String dietaryRestrictions) {
            this.dietaryRestrictions = dietaryRestrictions;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

}
