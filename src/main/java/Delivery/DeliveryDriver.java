package Delivery;

import main.CPPFoodDelivery;

public class DeliveryDriver {
    private CPPFoodDelivery platform;
    private String county = "";

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

    public boolean isOnShift(){
        return true;
    }
}
