package com.ps;


public class DrinkItem extends Item {
    private String size;

    public DrinkItem(String size, double price) {
        super("Drink", price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getDescription() {
        return "Drink Size: " + size;
    }
}


