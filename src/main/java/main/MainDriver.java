package main;

import restaurant.*;

public class MainDriver {
    public static void main(String[] args) {
        CPPFoodDelivery deliveryPlatform = CPPFoodDelivery.getInstance();

        //Build 4 Restaurants
        Restaurant thaiRestaurant = new Restaurant.Builder()
                .name("That Thai Place")
                .address("123 Street")
                .operatingHours("10AM-11PM")
                .county("LA County")
                .cuisineType("Thai")
                .build();
        Restaurant mexicanRestaurant = new Restaurant.Builder()
                .name("Fast and Fiesta")
                .address("354 Street")
                .operatingHours("12AM-1PM")
                .county("LA County")
                .cuisineType("Thai")
                .build();
        Restaurant italianRestaurant = new Restaurant.Builder()
                .name("Litaly")
                .address("367 Street")
                .operatingHours("8AM-9PM")
                .county("Orange County")
                .cuisineType("Thai")
                .build();
        Restaurant americanDiner = new Restaurant.Builder()
                .name("The Die ner")
                .address("5565 Street")
                .operatingHours("6AM-5PM")
                .county("San Bernardino County")
                .cuisineType("Thai")
                .build();

        //Register the restaurants with our mediator
        deliveryPlatform.register(thaiRestaurant);
        deliveryPlatform.register(mexicanRestaurant);
        deliveryPlatform.register(italianRestaurant);
        deliveryPlatform.register(americanDiner);


        DeliveryDriver george = new DeliveryDriver();
        deliveryPlatform.register(george);

        Customer c1 = new Customer(deliveryPlatform, "Vegan");

        c1.placeOrder(thaiRestaurant, 3, "");

    }
}
