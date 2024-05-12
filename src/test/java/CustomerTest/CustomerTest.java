package CustomerTest;

import Customer.Customer;
import main.CPPFoodDelivery;
import restaurant.Order;
import restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.beans.PropertyChangeEvent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
    private Customer customer;

    @Mock
    private CPPFoodDelivery deliveryPlatform;

    @Mock
    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        customer = new Customer(deliveryPlatform, "Vegan");
    }

    @Test
    public void constructorTest() {
        assertNotNull(customer, "Customer instance should not be null");
        assertEquals("Vegan", customer.getDietaryRestriction(), "Dietary restriction should be correctly set");
    }

    @Test
    public void testGetDietaryRestriction() {
        assertEquals("Vegan", customer.getDietaryRestriction(), "Should return correct dietary restriction");
    }

    @Test
    public void testPlaceOrder() {
        when(deliveryPlatform.placeOrder(any(Restaurant.class), eq(customer), anyInt(), any())).thenReturn(new Order(restaurant, customer, null, null));
        Order order = customer.placeOrder(restaurant, 1, "Extra Tofu");
        assertNotNull(order, "Order should not be null");
        verify(deliveryPlatform).placeOrder(restaurant, customer, 1, "Extra Tofu");
    }

    @Test
    public void testPropertyChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "order", null, "Order Placed");
        customer.propertyChange(event);
    }

    @Test
    public void testSetPlatform() {
        CPPFoodDelivery newPlatform = mock(CPPFoodDelivery.class);
        customer.setPlatform(newPlatform);
        customer.placeOrder(restaurant, 1);
        verify(newPlatform).placeOrder(restaurant, customer, 1);
    }
}
