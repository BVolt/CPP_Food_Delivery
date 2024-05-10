package Delivery;

import main.CPPFoodDelivery;

import java.time.*;

public class DeliveryDriver {
    private CPPFoodDelivery platform;
    private String county;
    private int shiftNumber;
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;

    public DeliveryDriver(String county, int shiftNumber) {
        this.county = county;
        this.shiftNumber = shiftNumber;
        assignShiftStartAndEnd();
    }

    private void assignShiftStartAndEnd(){
        LocalDate today = LocalDate.now();
        switch(shiftNumber){
            case 1:
                this.shiftStart = LocalDateTime.of(today, LocalTime.of(8, 0));
                this.shiftEnd = LocalDateTime.of(today, LocalTime.of(16, 0));
                break;
            case 2:
                this.shiftStart = LocalDateTime.of(today, LocalTime.of(16, 0));
                this.shiftEnd = LocalDateTime.of(today, LocalTime.of(0, 0));
                break;
            case 3:
                this.shiftStart = LocalDateTime.of(today, LocalTime.of(0, 0));
                this.shiftEnd = LocalDateTime.of(today, LocalTime.of(8, 0));
                break;
            default:
                throw new IllegalArgumentException("Invalid shift number.");
        }
    }

    public void pickUpOrder(){
        platform.pickUpOrder(this);
    }

    public void deliverOrder(){
        platform.deliverOrder(this);
    }

    public void setPlatform(CPPFoodDelivery platform) {
        this.platform = platform;
    }

    public String getCounty(){
        return this.county;
    }

    public boolean isOnShift() {
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(shiftStart) && !now.isAfter(shiftEnd);
    }
}
