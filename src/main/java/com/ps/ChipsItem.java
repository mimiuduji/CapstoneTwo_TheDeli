package com.ps;


public class ChipsItem extends Item {
    private String flavor;

    public ChipsItem(String flavor, double price) {
        super("Chips", price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String getDescription() {
        return "Chips Flavor: " + flavor;
    }
}


