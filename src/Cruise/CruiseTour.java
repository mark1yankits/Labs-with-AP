package Cruise;

import java.util.Scanner;

public class CruiseTour {
    Scanner sc = new Scanner(System.in);
    private int quantity;
    private String name;
    private int days;
    private String nutrition;
    private int cabinClass;
    private int transport;
    private double ticketPrice;
    private double totalCost;
    private int foodChoice;
    private double foodCost;
    private double accommodationCost;
    private String currency;

    public void inputDetails() {
        System.out.println("Cruise package selection");
        System.out.println("1. Mediterranean Cruise (Spain, Italy, Greece)");
        System.out.println("2. Caribbean Cruise (Bahamas, Jamaica, Cuba)");
        System.out.println("3. Scandinavian Cruise (Norway, Denmark, Sweden)");
        System.out.println("4. Alaska Cruise (USA, Canada)");
        System.out.println("5. Custom Cruise Tour");
        int choice = sc.nextInt();

        if (choice == 5) {
            createCustomTour();
        } else {
            preDefinedTour(choice);
            calculateTotalCost();
        }
    }

    public void displayDetails() {
        System.out.println("Booking for " + quantity + " people.");
        System.out.println("Days: " + days);
        System.out.println("Nutrition: " + nutrition);
        System.out.println("Cabin Class: " + (cabinClass == 1 ? "Economy" : cabinClass == 2 ? "Premium" : "Luxury"));
        System.out.println("Total cost: " + totalCost + " " + currency);
    }

    private void preDefinedTour(int choice) {
        switch (choice) {
            case 1:
                currency = "€";
                displayCruiseDetails("Mediterranean Cruise", 1000, 7, currency);
                break;
            case 2:
                currency = "$";
                displayCruiseDetails("Caribbean Cruise", 1200, 10, currency);
                break;
            case 3:
                currency = "€";
                displayCruiseDetails("Scandinavian Cruise", 1300, 8, currency);
                break;
            case 4:
                currency = "$";
                displayCruiseDetails("Alaska Cruise", 1400, 9, currency);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void displayCruiseDetails(String cruiseName, int basePrice, int tourDays, String currency) {
        System.out.println("------------------------------------------------");
        System.out.println("| Cruise: " + cruiseName);
        System.out.println("| Base Price per person: " + basePrice + " " + currency);
        System.out.println("| Duration: " + tourDays + " days");
        System.out.println("------------------------------------------------");

        System.out.print("How many people you want to book a cruise for: ");
        quantity = sc.nextInt();
        sc.nextLine();

        days = tourDays;
        ticketPrice = basePrice;

        System.out.println("Cabin options:");
        System.out.println("1. Economy Cabin (50 " + currency + " per night)");
        System.out.println("2. Premium Cabin (80 " + currency + " per night)");
        System.out.println("3. Luxury Suite (150 " + currency + " per night, meals included)");
        cabinClass = sc.nextInt();

        if (cabinClass != 3) {
            System.out.println("1. Breakfast - 10 " + currency);
            System.out.println("2. Half Board - 20 " + currency);
            System.out.println("3. Full Board - 30 " + currency);
            System.out.print("Choose food option: ");
            foodChoice = sc.nextInt();

            switch (foodChoice) {
                case 1:
                    foodCost = 10;
                    nutrition = "Breakfast";
                    break;
                case 2:
                    foodCost = 20;
                    nutrition = "Half Board";
                    break;
                case 3:
                    foodCost = 30;
                    nutrition = "Full Board";
                    break;
            }
        } else {
            nutrition = "Meals included";
            foodCost = 0;
        }
    }

    private void createCustomTour() {
        System.out.println("------------------------------------------------");
        System.out.println("| Custom Cruise Tour");
        System.out.println("------------------------------------------------");

        System.out.print("Enter your destination: ");
        sc.nextLine(); // consume newline
        String destination = sc.nextLine();

        System.out.print("Enter base price per person for cruise: ");
        ticketPrice = sc.nextDouble();

        System.out.print("Enter number of days: ");
        days = sc.nextInt();

        System.out.print("How many people you want to book a cruise for: ");
        quantity = sc.nextInt();

        System.out.println("Cabin options:");
        System.out.println("1. Economy Cabin");
        System.out.println("2. Premium Cabin");
        System.out.println("3. Luxury Suite");
        cabinClass = sc.nextInt();

        System.out.println("1. Breakfast");
        System.out.println("2. Half Board");
        System.out.println("3. Full Board");
        System.out.print("Choose food option: ");
        foodChoice = sc.nextInt();

        switch (foodChoice) {
            case 1:
                foodCost = 10;
                nutrition = "Breakfast";
                break;
            case 2:
                foodCost = 20;
                nutrition = "Half Board";
                break;
            case 3:
                foodCost = 30;
                nutrition = "Full Board";
                break;
        }

        calculateTotalCost();
    }

    public void calculateTotalCost() {
        switch (cabinClass) {
            case 1:
                accommodationCost = 50; // Economy cabin
                break;
            case 2:
                accommodationCost = 80; // Premium cabin
                break;
            case 3:
                accommodationCost = 150; // Luxury suite (meals included)
                break;
        }

        totalCost = (ticketPrice + (accommodationCost * days) + (foodCost * days)) * quantity;
        displayDetails();
    }
}
