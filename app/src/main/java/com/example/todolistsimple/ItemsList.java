package com.example.todolistsimple;

public class ItemsList {
    private String name;
    private int quantity ;

    public ItemsList (String name , int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
