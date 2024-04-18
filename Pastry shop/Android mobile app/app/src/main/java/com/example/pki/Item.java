package com.example.pki;

// CartItem.java
public class Item {

    private String imageName;
    private int quantity;

    public Item(String imageName, int quantity) {
        this.imageName = imageName;
        this.quantity = quantity;
    }

    public String getName() {
        return imageName;
    }
    public void inc(){quantity++;}
    public void dec(){if(quantity>=0){quantity--;}}
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
