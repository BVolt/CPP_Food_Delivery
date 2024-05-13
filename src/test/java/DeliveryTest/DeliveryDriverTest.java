package DeliveryTest;

import Delivery.DeliveryDriver;
import main.CPPFoodDelivery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeliveryDriverTest {
    private DeliveryDriver driver;

    @Mock
    private CPPFoodDelivery platform;

    @BeforeEach
    public void setUp() {
        driver = new DeliveryDriver.Builder()
                .platform(platform)
                .name("Driver 1")
                .address("123 Drive Lane")
                .county("LA County")
                .shiftNumber(1)
                .build();
        driver.setPlatform(platform);
    }

    @Test
    public void testConstructorAndShiftAssignment() {
        assertEquals("LA County", driver.getCounty(), "County should be set correctly.");
        assertEquals("Driver 1", driver.getName(), "Driver's name should be set correctly.");
        assertEquals("123 Main St", driver.getAddress(), "Driver's address should be set correctly.");

        LocalDate today = LocalDate.now();
        assertEquals(LocalDateTime.of(today, LocalTime.of(8, 0)), driver.getShiftStart(), "Shift start should be at 8 AM for shift 1.");
        assertEquals(LocalDateTime.of(today, LocalTime.of(16, 0)), driver.getShiftEnd(), "Shift end should be at 4 PM for shift 1.");
    }

    @Test
    public void testPickUpOrder() {
        driver.pickUpOrder();
        verify(platform).pickUpOrder(driver);
    }

    @Test
    public void testDeliverOrder() {
        driver.deliverOrder();
        verify(platform).deliverOrder(driver);
    }

    @Test
    public void testSetPlatform() {
        CPPFoodDelivery newPlatform = mock(CPPFoodDelivery.class);
        driver.setPlatform(newPlatform);
        driver.pickUpOrder();
        verify(newPlatform).pickUpOrder(driver);
    }
}
