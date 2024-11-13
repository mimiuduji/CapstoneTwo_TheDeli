package com.ps;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        for (Item item : items) {
            System.out.println("- " + item.getDescription() + " | Price: $" + item.getPrice());
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}
