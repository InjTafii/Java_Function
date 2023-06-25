package com;

public class Car {

    private String carID; // ko đc lặp lại
    private Brand brand; // nhập bằng menu
    private String color; // not null
    private String frameID;  // có định dạng F00000 và ko đc lặp lại
    private String engineID; // có định dạng E00000 và ko đc lặp lại

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return carID.toUpperCase() + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }

    public int comparedTo(Car c) {
        int d = this.brand.brandName.compareTo(c.brand.brandName);
        if (d != 0) {
            return d;
        }
        return 0;
    }

    public String screenString() {
        return brand +", \n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }

}
