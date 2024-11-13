package com.ps;


public class SandwichItem extends Item {
    private String breadType;
    private boolean toasted;

    public SandwichItem(String name, String breadType, boolean toasted, double price) {
        super(name, price);
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    @Override
    public String getDescription() {
        return "Sandwich: " + getName() + ", Bread Type: " + breadType + ", Toasted: " + (toasted ? "Yes" : "No");
    }
}
