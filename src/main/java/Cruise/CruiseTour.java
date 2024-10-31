package Cruise;

import java.util.Scanner;

public class CruiseTour {
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
    public String currency;

    public String getDestination() {
        return nutrition; // assuming "nutrition" stores the destination for simplicity
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getDays() {
        return days;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCabinClass() {
        return cabinClass;
    }

    public int getFoodChoice() {
        return foodChoice;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void inputDetails() {
        System.out.println("Cruise package selection");
        System.out.println("1. Mediterranean Cruise (Spain, Italy, Greece)");
        System.out.println("2. Caribbean Cruise (Bahamas, Jamaica, Cuba)");
        System.out.println("3. Scandinavian Cruise (Norway, Denmark, Sweden)");
        System.out.println("4. Alaska Cruise (USA, Canada)");
        System.out.println("5. Custom Cruise Tour");
        int choice = sc.nextInt();

        if (choice == 5) {
            createCustomTour(100, 7, 5, 1, 2, 0);
        } else {
            calculateTotalCost();
        }
    }

    public void displayDetails() {
        System.out.println("Booking for " + quantity + " people.");
        System.out.println("Days: " + days);
        System.out.println("Nutrition: " + nutrition);
        System.out.println("Cabin Class: " + (cabinClass == 1 ? "Economy" : cabinClass == 2 ? "Premium" : "Luxury"));
        System.out.println("Total cost of the cruise: $" + totalCost + " USD");
    }



    public void displayCruiseDetails(String cruiseName, int basePrice, int tourDays, String currency) {
        Scanner sc = new Scanner(System.in); // Ініціалізуємо Scanner локально

        System.out.println("------------------------------------------------");
        System.out.println("| Cruise: " + cruiseName);
        System.out.println("| Base Price per person: " + basePrice + " " + currency);
        System.out.println("| Duration: " + tourDays + " days");
        System.out.println("------------------------------------------------");

        System.out.print("How many people you want to book a cruise for: ");
        if (sc.hasNextInt()) {
            quantity = sc.nextInt();
            sc.nextLine(); // consume newline
        } else {
            System.out.println("Invalid input for quantity. Exiting...");
            sc.close(); // Закриваємо Scanner
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
        } else {
            System.out.println("Invalid input for cabin class. Exiting...");
            sc.close(); // Закриваємо Scanner
            return;
        }

        if (cabinClass != 3) {
            System.out.println("1. Breakfast - 10 " + currency);
            System.out.println("2. Half Board - 20 " + currency);
            System.out.println("3. Full Board - 30 " + currency);
            System.out.print("Choose food option: ");

            if (sc.hasNextInt()) {
                foodChoice = sc.nextInt();
            } else {
                System.out.println("Invalid input for food choice. Exiting...");
                sc.close(); // Закриваємо Scanner
                return;
            }

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
                default:
                    System.out.println("Invalid food choice. Exiting...");
                    sc.close(); // Закриваємо Scanner
                    return;
            }
        } else {
            nutrition = "Meals included";
            foodCost = 0;
        }

        System.out.println("Cruise details set successfully.");
        sc.close(); // Закриваємо Scanner
    }




    public void createCustomTour(int i, int i1, int i2, int i3, int i4, int i5) {
        System.out.println("------------------------------------------------");
        System.out.println("| Custom Cruise Tour");
        System.out.println("------------------------------------------------");

        ticketPrice = getInputDouble("Enter base price per person for cruise: ");
        if (ticketPrice <= 0) {
            System.out.println("Error: Ticket price must be a positive value.");
            return;
        }

        days = getInputInt("Enter number of days: ");
        if (days <= 0) {
            System.out.println("Error: Number of days must be a positive value.");
            return;
        }

        quantity = getInputInt("How many people you want to book a cruise for: ");
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be a positive value.");
            return;
        }

        cabinClass = getInputInt("Cabin options:\n1. Economy Cabin\n2. Premium Cabin\n3. Luxury Suite\nChoose cabin class: ");
        if (cabinClass < 1 || cabinClass > 3) {
            System.out.println("Error: Invalid cabin class selection.");
            return;
        }

        foodChoice = getInputInt("Food options:\n1. Breakfast\n2. Half Board\n3. Full Board\nChoose food option: ");
        if (foodChoice < 1 || foodChoice > 3) {
            System.out.println("Error: Invalid food choice selection.");
            return;
        }

        // Встановлюємо вартість їжі та тип харчування
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




    public void initCustomTour(String destination, double price, int days, int quantity, int cabinClass, int foodChoice) {
        this.ticketPrice = price;
        this.days = days;
        this.quantity = quantity;
        this.cabinClass = cabinClass;
        this.foodChoice = foodChoice;

        switch (foodChoice) {
            case 1:
                this.foodCost = 10;
                this.nutrition = "Breakfast";
                break;
            case 2:
                this.foodCost = 20;
                this.nutrition = "Half Board";
                break;
            case 3:
                this.foodCost = 30;
                this.nutrition = "Full Board";
                break;
        }

        switch (cabinClass) {
            case 1:
                this.accommodationCost = 50; // Economy
                break;
            case 2:
                this.accommodationCost = 80; // Premium
                break;
            case 3:
                this.accommodationCost = 150; // Luxury
                this.foodCost = 0; // Meals included
                this.nutrition = "Meals included";
                break;
        }

        calculateTotalCost();
    }

    public  void calculateTotalCost() {
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
