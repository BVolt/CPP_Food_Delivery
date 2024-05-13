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
    private DeliveryDriver driver_1;
    private DeliveryDriver driver_2;
    private DeliveryDriver driver_3;
    LocalTime time = LocalTime.now();
    LocalDate today = LocalDate.now();

    @Mock
    private CPPFoodDelivery platform;

    @BeforeEach
    public void setUp() {
        driver_1 = new DeliveryDriver.Builder()
                .platform(platform)
                .name("Driver 1")
                .address("123 Drive Lane")
                .county("LA County")
                .shiftNumber(1)
                .build();
        driver_1.setPlatform(platform);

        driver_2 = new DeliveryDriver.Builder()
                .platform(platform)
                .name("Driver 1")
                .address("123 Drive Lane")
                .county("LA County")
                .shiftNumber(2)
                .build();
        driver_2.setPlatform(platform);

        driver_3 = new DeliveryDriver.Builder()
                .platform(platform)
                .name("Driver 1")
                .address("123 Drive Lane")
                .county("LA County")
                .shiftNumber(3)
                .build();
        driver_3.setPlatform(platform);
    }

    @Test
    public void testConstructorAndShiftAssignment() {
        assertEquals("LA County", driver_1.getCounty(), "County should be set correctly.");
        assertEquals("Driver 1", driver_1.getName(), "Driver's name should be set correctly.");
        assertEquals("123 Drive Lane", driver_1.getAddress(), "Driver's address should be set correctly.");

        LocalDate today = LocalDate.now();
        assertEquals(LocalDateTime.of(today, LocalTime.of(8, 0)), driver_1.getShiftStart(), "Shift start should be at 8 AM for shift 1.");
        assertEquals(LocalDateTime.of(today, LocalTime.of(16, 0)), driver_1.getShiftEnd(), "Shift end should be at 4 PM for shift 1.");
    }

    @Test
    public void testPickUpOrder() {
        driver_1.pickUpOrder();
        verify(platform).pickUpOrder(driver_1);
    }

    @Test
    public void testDeliverOrder() {
        driver_1.deliverOrder();
        verify(platform).deliverOrder(driver_1);
    }

    @Test
    public void testSetPlatform() {
        CPPFoodDelivery newPlatform = mock(CPPFoodDelivery.class);
        driver_1.setPlatform(newPlatform);
        driver_1.pickUpOrder();
        verify(newPlatform).pickUpOrder(driver_1);
    }
    @Test
    public void testGetCounty() {
        String expected = "LA County";
        String actual = driver_1.getCounty();
        assertEquals(expected, actual, "returning wrong county");
    }
    @Test
    public void testGetName() {
        String expected = "Driver 1";
        String actual = driver_1.getName();
        assertEquals(expected, actual, "returning wrong name");
    }
    @Test
    public void testGetAddress() {
        String expected = "123 Drive Lane";
        String actual = driver_1.getAddress();
        assertEquals(expected, actual, "returning wrong address");
    }
    @Test
    public void testIsOnShift1() {
        boolean expected = time.isAfter(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(16, 0));
        boolean actual = driver_1.isOnShift();
        assertEquals(expected, actual);
    }
    @Test
    public void testIsOnShift2() {
        boolean expected = time.isAfter(LocalTime.of(16, 0)) && time.isBefore(LocalTime.of(0, 0));
        boolean actual = driver_2.isOnShift();
        assertEquals(expected, actual);
    }
    @Test
    public void testIsOnShift3() {
        boolean expected = time.isAfter(LocalTime.of(0, 0)) && time.isBefore(LocalTime.of(8, 0));
        boolean actual = driver_3.isOnShift();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftStart1() {
        Object expected = LocalDateTime.of(today,LocalTime.of(8,0));
        Object actual = driver_1.getShiftStart();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftStart2() {
        Object expected = LocalDateTime.of(today,LocalTime.of(16,0));
        Object actual = driver_2.getShiftStart();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftStart3() {
        Object expected = LocalDateTime.of(today,LocalTime.of(0,0));
        Object actual = driver_3.getShiftStart();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftEnd1() {
        Object expected = LocalDateTime.of(today,LocalTime.of(16,0));
        Object actual = driver_1.getShiftEnd();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftEnd2() {
        Object expected = LocalDateTime.of(today,LocalTime.of(0,0));
        Object actual = driver_2.getShiftEnd();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetShiftEnd3() {
        Object expected = LocalDateTime.of(today,LocalTime.of(8,0));
        Object actual = driver_3.getShiftEnd();
        assertEquals(expected, actual);
    }
}
