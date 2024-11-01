package Cruise;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CruiseTour {
    private static final Logger logger = Logger.getLogger(CruiseTour.class.getName());
    private Scanner sc = new Scanner(System.in);
    public int quantity;
    public int days;
    public String nutrition;
    public int cabinClass;
    public double ticketPrice;
    public double totalCost;
    public int foodChoice;
    public double foodCost;
    public double accommodationCost;




    public void inputDetails() {
        logger.log(Level.INFO, "Starting cruise package selection.");
        System.out.println("Cruise package selection");
        System.out.println("1. Mediterranean Cruise (Spain, Italy, Greece)");
        System.out.println("2. Caribbean Cruise (Bahamas, Jamaica, Cuba)");
        System.out.println("3. Scandinavian Cruise (Norway, Denmark, Sweden)");
        System.out.println("4. Alaska Cruise (USA, Canada)");
        System.out.println("5. Custom Cruise Tour");
        int choice = sc.nextInt();
        logger.log(Level.INFO, "Cruise package choice: {0}", choice);

        if (choice == 5) {
            createCustomTour(100, 7, 5, 1, 2, 0);
        } else {
            calculateTotalCost();
        }
    }

    public void displayDetails() {
        logger.log(Level.INFO, "Displaying cruise details.");
        System.out.println("Booking for " + quantity + " people.");
        System.out.println("Days: " + days);
        System.out.println("Nutrition: " + nutrition);
        System.out.println("Cabin Class: " + (cabinClass == 1 ? "Economy" : cabinClass == 2 ? "Premium" : "Luxury"));
        System.out.println("Total cost of the cruise: $" + totalCost + " USD");
    }

    public void displayCruiseDetails(String cruiseName, int basePrice, int tourDays, String currency) {
        logger.log(Level.INFO, "Displaying cruise details for {0}", cruiseName);
        System.out.println("------------------------------------------------");
        System.out.println("| Cruise: " + cruiseName);
        System.out.println("| Base Price per person: " + basePrice + " " + currency);
        System.out.println("| Duration: " + tourDays + " days");
        System.out.println("------------------------------------------------");

        System.out.print("How many people you want to book a cruise for: ");
        if (sc.hasNextInt()) {
            quantity = sc.nextInt();
            sc.nextLine(); // consume newline
            logger.log(Level.INFO, "Quantity: {0}", quantity);
        } else {
            System.out.println("Invalid input for quantity. Exiting...");
            sc.close();
            return;
        }

        days = tourDays;
        ticketPrice = basePrice;

        System.out.println("Cabin options:");
        System.out.println("1. Economy Cabin (50 " + currency + " per night)");
        System.out.println("2. Premium Cabin (80 " + currency + " per night)");
        System.out.println("3. Luxury Suite (150 " + currency + " per night, meals included)");

        if (sc.hasNextInt()) {
            cabinClass = sc.nextInt();
            logger.log(Level.INFO, "Cabin class selected: {0}", cabinClass);
        } else {
            System.out.println("Invalid input for cabin class. Exiting...");
            sc.close();
            return;
        }

        if (cabinClass != 3) {
            System.out.println("1. Breakfast - 10 " + currency);
            System.out.println("2. Half Board - 20 " + currency);
            System.out.println("3. Full Board - 30 " + currency);
            System.out.print("Choose food option: ");

            if (sc.hasNextInt()) {
                foodChoice = sc.nextInt();
                logger.log(Level.INFO, "Food choice selected: {0}", foodChoice);
            } else {
                System.out.println("Invalid input for food choice. Exiting...");
                sc.close();
                return;
            }

            switch (foodChoice) {
                case 1 -> {
                    foodCost = 10;
                    nutrition = "Breakfast";
                }
                case 2 -> {
                    foodCost = 20;
                    nutrition = "Half Board";
                }
                case 3 -> {
                    foodCost = 30;
                    nutrition = "Full Board";
                }
                default -> {
                    System.out.println("Invalid food choice. Exiting...");
                    sc.close();
                    return;
                }
            }
        } else {
            nutrition = "Meals included";
            foodCost = 0;
        }

        logger.log(Level.INFO, "Cruise details set successfully with nutrition type: {0}, food cost: {1}", new Object[]{nutrition, foodCost});
        sc.close();
    }

    public void createCustomTour(int i, int i1, int i2, int i3, int i4, int i5) {
        logger.log(Level.INFO, "Starting custom cruise tour creation.");
        System.out.println("------------------------------------------------");
        System.out.println("| Custom Cruise Tour");
        System.out.println("------------------------------------------------");

        ticketPrice = getInputDouble("Enter base price per person for cruise: ");
        if (ticketPrice <= 0) {
            logger.log(Level.WARNING, "Invalid ticket price: {0}", ticketPrice);
            System.out.println("Error: Ticket price must be a positive value.");
            return;
        }

        days = getInputInt("Enter number of days: ");
        if (days <= 0) {
            logger.log(Level.WARNING, "Invalid number of days: {0}", days);
            System.out.println("Error: Number of days must be a positive value.");
            return;
        }

        quantity = getInputInt("How many people you want to book a cruise for: ");
        if (quantity <= 0) {
            logger.log(Level.WARNING, "Invalid quantity: {0}", quantity);
            System.out.println("Error: Quantity must be a positive value.");
            return;
        }

        cabinClass = getInputInt("Cabin options:\n1. Economy Cabin\n2. Premium Cabin\n3. Luxury Suite\nChoose cabin class: ");
        if (cabinClass < 1 || cabinClass > 3) {
            logger.log(Level.WARNING, "Invalid cabin class selection: {0}", cabinClass);
            System.out.println("Error: Invalid cabin class selection.");
            return;
        }

        foodChoice = getInputInt("Food options:\n1. Breakfast\n2. Half Board\n3. Full Board\nChoose food option: ");
        if (foodChoice < 1 || foodChoice > 3) {
            logger.log(Level.WARNING, "Invalid food choice selection: {0}", foodChoice);
            System.out.println("Error: Invalid food choice selection.");
            return;
        }

        switch (foodChoice) {
            case 1 -> {
                foodCost = 10;
                nutrition = "Breakfast";
            }
            case 2 -> {
                foodCost = 20;
                nutrition = "Half Board";
            }
            case 3 -> {
                foodCost = 30;
                nutrition = "Full Board";
            }
        }

        calculateTotalCost();
    }

    private double getInputDouble(String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Please enter a valid number.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextDouble();
    }

    private int getInputInt(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error: Please enter a valid integer.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextInt();
    }

    public void calculateTotalCost() {
        switch (cabinClass) {
            case 1 -> accommodationCost = 50; // Economy cabin
            case 2 -> accommodationCost = 80; // Premium cabin
            case 3 -> accommodationCost = 150; // Luxury suite (meals included)
        }

        totalCost = (ticketPrice + (accommodationCost * days) + (foodCost * days)) * quantity;
        logger.log(Level.INFO, "Total cost calculated: {0}", totalCost);
        displayDetails();
    }
}
