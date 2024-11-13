package com.ps;

public abstract class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getCost();
}

class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getCost() {
        return 0; // Regular toppings are free
    }
}

class PremiumTopping extends Topping {
    private double cost;

    public PremiumTopping(String name, double cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
