package CustomerTest;

import Customer.Customer;
import main.CPPFoodDelivery;
import restaurant.Order;
import restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
        customer = new Customer.Builder()
                .deliveryPlatform(deliveryPlatform)
                .name("Customer 1")
                .address("123 Main St")
                .county("LA County")
                .dietaryRestrictions("Vegan")
                .build();
    }

    @Test
    public void constructorTest() {
        assertNotNull(customer, "Customer instance should not be null");
        assertEquals("Vegan", customer.getDietaryRestriction(), "Dietary restriction should be correctly set");
        assertEquals("Customer 1", customer.getName(), "Customer name should be correctly set");
        assertEquals("123 Main St", customer.getAddress(), "Customer address should be correctly set");
        assertEquals("LA County", customer.getCounty(), "Customer county should be correctly set");
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
    @Test
    public void testGetDietaryRestriction() {
        String expected = "Vegan";
        String actual = customer.getDietaryRestriction();
        assertEquals(expected, actual, "returning wrong dietary restriction");
    }
    @Test
    public void testGetName() {
        String expected = "Customer 1";
        String actual = customer.getName();
        assertEquals(expected,actual, "returning wrong customer name");
    }
    @Test
    public void testGetAddress() {
        String expected = "123 Main St";
        String actual = customer.getAddress();
        assertEquals(expected,actual, "returning wrong address");
    }

    @Test
    public void testGetCounty() {
        String expected = "LA County";
        String actual = customer.getCounty();
        assertEquals(expected,actual, "returning wrong county");
    }
}
