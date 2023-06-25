package com;

public class Brand {

    private String brandID; // nhập bằng menu
    String brandName; // ko đc để trống
    private String soundBrand; // ko đc để trống
    private  double price; // là 1 số thực dương

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand() {
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    @Override
    public String toString() {
        return getBrandID().toUpperCase() + ", " + getBrandName() + ", " + getSoundBrand() + ": " + getPrice();
    }

}
