package Delivery;

import main.CPPFoodDelivery;

import java.time.*;

public class DeliveryDriver {
    private CPPFoodDelivery platform;
    private String name;
    private String address;
    private String county;
    private int shiftNumber;
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;

    private DeliveryDriver(Builder builder) {
        this.platform = builder.platform;
        this.name = builder.name;
        this.address = builder.address;
        this.county = builder.county;
        this.shiftNumber = builder.shiftNumber;
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
        if (shiftNumber == 2) {
            return !now.isBefore(shiftStart) || !now.isAfter(shiftEnd);
        } else {
            return !now.isBefore(shiftStart) && !now.isAfter(shiftEnd);
        }
    }

    public Object getShiftStart() {return this.shiftStart;}

    public Object getShiftEnd() {return this.shiftEnd;}

    public String getName() {return this.name;}
    public String getAddress() {return this.address;}

    public static class Builder {
        private CPPFoodDelivery platform;
        private String name;
        private String address;
        private String county;
        private int shiftNumber;

        public Builder(){
        }

        public Builder platform(CPPFoodDelivery platform) {
            this.platform = platform;
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

        public Builder shiftNumber(int shiftNumber) {
            this.shiftNumber = shiftNumber;
            return this;
        }

        public DeliveryDriver build() {
            return new DeliveryDriver(this);
        }
    }
}
