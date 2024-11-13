package com.ps;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\n=== DELI-cious Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSandwich(order, scanner);
                    break;
                case 2:
                    addDrink(order, scanner);
                    break;
                case 3:
                    addChips(order, scanner);
                    break;
                case 4:
                    checkout(order);
                    break;
                case 0:
                    System.out.println("Thank you for visiting DELI-cious! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addSandwich(Order order, Scanner scanner) {
        System.out.println("\n=== Add Sandwich ===");
        System.out.print("Enter sandwich name: ");
        String name = scanner.nextLine();

        System.out.print("Enter bread type (white/wheat/rye): ");
        String breadType = scanner.nextLine();

        System.out.print("Do you want it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Enter sandwich price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        SandwichItem sandwich = new SandwichItem(name, breadType, toasted, price);
        order.addItem(sandwich);

        System.out.println("Sandwich added: " + sandwich.getDescription());
    }

    private static void addDrink(Order order, Scanner scanner) {
        System.out.println("\n=== Add Drink ===");
        System.out.print("Enter drink size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        System.out.print("Enter drink price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        DrinkItem drink = new DrinkItem(size, price);
        order.addItem(drink);

        System.out.println("Drink added: " + drink.getDescription());
    }

    private static void addChips(Order order, Scanner scanner) {
        System.out.println("\n=== Add Chips ===");
        System.out.print("Enter chips flavor: ");
        String flavor = scanner.nextLine();

        System.out.print("Enter chips price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        ChipsItem chips = new ChipsItem(flavor, price);
        order.addItem(chips);

        System.out.println("Chips added: " + chips.getDescription());
    }

    private static void checkout(Order order) {
        System.out.println("\n=== Checkout ===");
        order.printOrderDetails();
        System.out.println("\nOrder complete! Thank you for your purchase.");
        System.exit(0); // End the program after checkout
    }
}
