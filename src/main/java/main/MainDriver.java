package main;

import Customer.Customer;
import Delivery.DeliveryDriver;
import restaurant.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Arrays;

public class MainDriver {
    public static void main(String[] args) {
        CPPFoodDelivery deliveryPlatform = CPPFoodDelivery.getInstance();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        //Build 4 Restaurants
        Restaurant thaiRestaurant = new Restaurant.Builder()
                .name("That Thai Place")
                .address("123 Street")
                .operatingHours("10:00", "23:00")
                .county("LA County")
                .cuisineType("Thai")
                .build();
        Restaurant mexicanRestaurant = new Restaurant.Builder()
                .name("Fast and Fiesta")
                .address("354 Street")
                .operatingHours("00:00", "13:00")
                .county("LA County")
                .cuisineType("mexican")
                .build();
        Restaurant italianRestaurant = new Restaurant.Builder()
                .name("Litaly")
                .address("367 Street")
                .operatingHours("08:00", "21:00")
                .county("Orange County")
                .cuisineType("italian")
                .build();
        Restaurant americanDiner = new Restaurant.Builder()
                .name("The Die ner")
                .address("5565 Street")
                .operatingHours("06:00", "20:00")
                .county("San Bernardino County")
                .cuisineType("american diner")
                .build();

        //Register the restaurants with our mediator
        deliveryPlatform.register(thaiRestaurant);
        deliveryPlatform.register(mexicanRestaurant);
        deliveryPlatform.register(italianRestaurant);
        deliveryPlatform.register(americanDiner);

        System.out.println("Current time: " + dtf.format(LocalDateTime.now()));
        System.out.println();
        System.out.println("Available Restaurants at this time:");
        for (Restaurant restaurant : deliveryPlatform.getRestaurants()) {
            if (restaurant.isOpen()) {
                System.out.println(restaurant.getName() + " (" + restaurant.getOpeningTime() + " - " + restaurant.getClosingTime() + ")");
            }
        }
        System.out.println();

        // Build 8 drivers
        DeliveryDriver d1 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 1")
                .address("101 Drive Way")
                .county("LA County")
                .shiftNumber(2)
                .build();

        DeliveryDriver d2 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 2")
                .address("202 Drive Way")
                .county("Orange County")
                .shiftNumber(3)
                .build();

        DeliveryDriver d3 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 3")
                .address("303 Drive Way")
                .county("San Bernardino County")
                .shiftNumber(3)
                .build();

        DeliveryDriver d4 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 4")
                .address("404 Drive Way")
                .county("LA County")
                .shiftNumber(1)
                .build();

        DeliveryDriver d5 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 5")
                .address("505 Drive Way")
                .county("Orange County")
                .shiftNumber(1)
                .build();

        DeliveryDriver d6 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 6")
                .address("606 Drive Way")
                .county("San Bernardino County")
                .shiftNumber(3)
                .build();

        DeliveryDriver d7 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 7")
                .address("707 Drive Way")
                .county("LA County")
                .shiftNumber(1)
                .build();

        DeliveryDriver d8 = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 8")
                .address("808 Drive Way")
                .county("Orange County")
                .shiftNumber(2)
                .build();

        // Register the drivers with our mediator
        for (DeliveryDriver deliveryDriver : Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8)) {
            deliveryPlatform.register(deliveryDriver);
        }

        // Build 10 customers
        Customer c1 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 1")
                .address("100 Main St")
                .county("LA County")
                .dietaryRestrictions("Vegan")
                .build();

        Customer c2 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 2")
                .address("200 Main St")
                .county("Orange County")
                .dietaryRestrictions("None")
                .build();

        Customer c3 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 3")
                .address("300 Main St")
                .county("San Bernardino County")
                .dietaryRestrictions("Gluten-Free")
                .build();

        Customer c4 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 4")
                .address("400 Main St")
                .county("LA County")
                .dietaryRestrictions("Vegan")
                .build();

        Customer c5 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 5")
                .address("500 Main St")
                .county("Orange County")
                .dietaryRestrictions("None")
                .build();

        Customer c6 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 6")
                .address("600 Main St")
                .county("San Bernardino County")
                .dietaryRestrictions("Gluten-Free")
                .build();

        Customer c7 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 7")
                .address("700 Main St")
                .county("LA County")
                .dietaryRestrictions("Vegan")
                .build();

        Customer c8 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 8")
                .address("800 Main St")
                .county("Orange County")
                .dietaryRestrictions("Gluten-Free")
                .build();

        Customer c9 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 9")
                .address("900 Main St")
                .county("San Bernardino County")
                .dietaryRestrictions("Vegan")
                .build();

        Customer c10 = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 10")
                .address("1000 Main St")
                .county("LA County")
                .dietaryRestrictions("Gluten-Free")
                .build();

        // Register the customers with our mediator
        for (Customer customer : Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)) {
            deliveryPlatform.register(customer);
        }

        Order order1 = c1.placeOrder(thaiRestaurant, 3, "Sesame Seeds", "Wasabi");
        moveOrderAlong(order1);

        Order order2 = c2.placeOrder(mexicanRestaurant, 1);
        moveOrderAlong(order2);

        Order order3 = c3.placeOrder(italianRestaurant, 2);
        moveOrderAlong(order3);

        Order order4 = c4.placeOrder(americanDiner, 4);
        moveOrderAlong(order4);

        Order order5 = c5.placeOrder(italianRestaurant, 1, "Extra Cheese", "Pepperoni", "Olives");
        moveOrderAlong(order5);
    }

    public static void moveOrderAlong(Order order){
        if(order != null){
            DeliveryDriver assignedDriver = order.getDriver();
            assignedDriver.pickUpOrder();
            assignedDriver.deliverOrder();
            System.out.println();
            System.out.println(order);
        }
    }
}
