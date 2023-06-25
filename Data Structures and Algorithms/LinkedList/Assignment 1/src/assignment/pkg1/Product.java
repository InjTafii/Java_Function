/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

public class Product {
    String pcode;
    String proName;
    int quantity;
    double price;

    public Product() {
    }

    public Product(String pcode, String proName, int quantity, double price) {
        this.pcode = pcode;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return pcode + " | " + proName + " | " + quantity + " | " + price;
    }
}

