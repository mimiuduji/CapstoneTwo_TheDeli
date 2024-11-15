package com.ps;

import java.io.FileWriter;
import java.io.IOException;
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

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("Order Details:\n");
        for (Item item : items) {
            details.append("- ").append(item.getDescription()).append("\n");
        }
        return details.toString();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void saveReceipt() {
        String fileName = "receipts/" + System.currentTimeMillis() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(getOrderDetails());
            writer.write("Total Price: $" + getTotalPrice());
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
