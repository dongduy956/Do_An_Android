package com.example.do_an_android.Model;

import java.io.Serializable;

public class CartModel implements Serializable {
  private ProductModel productModel;
  private  int quantity;

    public CartModel(ProductModel productModel, int quantity) {
        this.productModel = productModel;
        this.quantity = quantity;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}