package RestaurantTest;

import main.CPPFoodDelivery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Customer.Customer;
import Delivery.DeliveryDriver;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.Meal;
import restaurant.Order;
import restaurant.Restaurant;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class OrderTest {
    private Restaurant restaurant;
    private Customer customer;
    private Meal meal;
    private DeliveryDriver driver;
    CPPFoodDelivery deliveryPlatform = CPPFoodDelivery.getInstance();


    @BeforeEach
    public void setup() {
        restaurant = new Restaurant.Builder()
                .name("Test Restaurant")
                .address("123 Street")
                .operatingHours("10:00", "23:00")
                .county("LA County")
                .cuisineType("Thai")
                .build();
        driver = new DeliveryDriver.Builder()
                .platform(deliveryPlatform)
                .name("Driver 1")
                .address("101 Drive Way")
                .county("LA County")
                .shiftNumber(2)
                .build();
        customer = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 1")
                .address("100 Main St")
                .county("LA County")
                .dietaryRestrictions("Vegan")
                .build();
    }



}
