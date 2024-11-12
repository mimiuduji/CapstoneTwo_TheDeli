package com.ps;

import java.util.List;

public class Sandwich {
    private int size;
    private String bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(int size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    // Add a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double basePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };

        double toppingCost = toppings.stream()
                .mapToDouble(Topping::getCost)
                .sum();

        return basePrice + toppingCost;
    }

    @Override
    public String toString() {
        return "Sandwich [size=" + size + "\", bread=" + bread + ", toppings=" + toppings + ", toasted=" + toasted + "]";
    }
}

