package com.ps;

import java.util.ArrayList;
import java.util.List;

public class SandwichItem extends Item {
    private String breadType;
    private boolean toasted;
    private List<String> toppings;

    public SandwichItem(String name, double price, String breadType, boolean toasted) {
        super(name, price);
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public void addToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(super.getName() + " on " + breadType + " bread");
        if (toasted) {
            description.append(", toasted");
        }
        if (!toppings.isEmpty()) {
            description.append(" with toppings: ").append(String.join(", ", toppings));
        }
        return description.toString();
    }
}
