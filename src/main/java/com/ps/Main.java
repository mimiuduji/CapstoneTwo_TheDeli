package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createNewOrder(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for visiting DELI-cious. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSandwich(scanner, order);
                    break;
                case 2:
                    addDrink(scanner, order);
                    break;
                case 3:
                    addChips(scanner, order);
                    break;
                case 4:
                    checkout(order);
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSandwich(Scanner scanner, Order order) {
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Enter sandwich name: ");
        String name = scanner.nextLine();
        System.out.print("Enter bread type (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();
        System.out.print("Is it toasted? (true/false): ");
        boolean toasted = scanner.nextBoolean();
        System.out.print("Enter sandwich base price: ");
        double basePrice = scanner.nextDouble();

        List<String> toppings = addToppings(scanner);

        SandwichItem sandwich = new SandwichItem(name, basePrice, breadType, toasted);
        sandwich.addToppings(toppings);

        order.addItem(sandwich);
        System.out.println("Sandwich added to order.");
    }

    private static List<String> addToppings(Scanner scanner) {
        List<String> toppings = new ArrayList<>();
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("\nToppings Menu:");
            System.out.println("1) Add Meat");
            System.out.println("2) Add Cheese");
            System.out.println("3) Add Regular Toppings");
            System.out.println("4) Done Adding Toppings");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter meat topping: ");
                    String meat = scanner.nextLine();
                    toppings.add("Meat: " + meat);
                    break;
                case 2:
                    System.out.print("Enter cheese topping: ");
                    String cheese = scanner.nextLine();
                    toppings.add("Cheese: " + cheese);
                    break;
                case 3:
                    System.out.print("Enter regular topping: ");
                    String regularTopping = scanner.nextLine();
                    toppings.add("Topping: " + regularTopping);
                    break;
                case 4:
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        return toppings;
    }

    private static void addDrink(Scanner scanner, Order order) {
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Enter drink name: ");
        String name = scanner.nextLine();
        System.out.print("Enter drink price: ");
        double price = scanner.nextDouble();

        DrinkItem drink = new DrinkItem(name, price);
        order.addItem(drink);
        System.out.println("Drink added to order.");
    }

    private static void addChips(Scanner scanner, Order order) {
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Enter chip type: ");
        String name = scanner.nextLine();
        System.out.print("Enter chip price: ");
        double price = scanner.nextDouble();

        ChipsItem chips = new ChipsItem(name, price);
        order.addItem(chips);
        System.out.println("Chips added to order.");
    }

    private static void checkout(Order order) {
        System.out.println("\nOrder Summary:");
        System.out.println(order.getOrderDetails());
        System.out.println("Total Price: $" + order.getTotalPrice());
        System.out.println("Order has been completed and receipt saved.");
        order.saveReceipt(); // Save receipt to file
    }
}
