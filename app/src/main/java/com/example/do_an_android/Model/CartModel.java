package com.example.do_an_android.Model;

import java.io.Serializable;

public class CartModel implements Serializable {
    private  int image;
    private  String name,quantity,price,subtoal;

    public CartModel(int image, String name, String quantity, String price, String subtoal) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.subtoal = subtoal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtoal() {
        return subtoal;
    }

    public void setSubtoal(String subtoal) {
        this.subtoal = subtoal;
    }
}