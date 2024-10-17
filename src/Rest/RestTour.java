package Rest;

import java.util.Scanner;

public class RestTour {
    Scanner sc = new Scanner(System.in);
    private int quantity;
    private int days;
    private String nutrition;
    private int hostelNum;
    private int transport;
    private double ticketPrice;
    private double totalCost;
    private int foodChoice;
    private double foodCost;
    private double accommodationCost;
    private String currency;


    public void inputDetails() {

        System.out.println("Rest table cost");
        System.out.println("1. Ua (Lviv) - UK (London)");
        System.out.println("2. Ua (Lviv) - Spain (Barcelona)");
        System.out.println("3. Ua (Lviv) - Italy (Rome)");
        System.out.println("4. Ua (Lviv) - Mauritius");
        int choice = sc.nextInt();

        choiceMarch(choice);
        calculateTotalCost();
    }

    public void displayDetails() {
        System.out.println("Booking for " + quantity + " people.");
        System.out.println("Days: " + days);
        System.out.println("Nutrition: " + nutrition);
        System.out.println("Transport: " + (transport == 1 ? "Plane" : "Bus"));
        System.out.println("Total cost: " + totalCost + " " + currency);
    }

    private void choiceMarch(int choice) {
        switch (choice) {
            case 1:
                currency = "£";
                displayRouteDetails("UK (London)", 150, 40, currency);
                break;
            case 2:
                currency = "€";
                displayRouteDetails("Spain (Barcelona)", 150, 40, currency);
                break;
            case 3:
                currency = "€";
                displayRouteDetails("Italy (Rome)", 150, 40, currency);
                break;
            case 4:
                currency = "$";
                displayRouteDetails("Mauritius", 300, 100, currency);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void displayRouteDetails(String destination, int planePrice, int busPrice, String currency) {
        System.out.println("------------------------------------------------");
        System.out.println("| Route: Ua (Lviv) - " + destination);
        System.out.println("| Plane cost: " + planePrice + " " + currency);
        System.out.println("| Bus cost: " + busPrice + " " + currency);
        System.out.println("------------------------------------------------");

        System.out.print("How many people you want to book a trip for: ");
        quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the number of days: ");
        days = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the type of transport: \n" +
                "1. Plane\n" +
                "2. Bus\n");
        transport = sc.nextInt();
        if (transport == 1) {
            ticketPrice = planePrice;
        } else if (transport == 2) {
            ticketPrice = busPrice;
        }

        System.out.println("Accommodation options:");
        System.out.println("1. 3-Star Hotel (50 " + currency + " per night)");
        System.out.println("2. 4-Star Hotel (80 " + currency + " per night)");
        System.out.println("3. 5-Star Hotel (150 " + currency + " per night, meals included)");
        System.out.println("4. Hostel (25 " + currency + " per night)");
        hostelNum = sc.nextInt();

        if (hostelNum != 3) {
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

    public void calculateTotalCost() {
        switch (hostelNum) {
            case 1:
                accommodationCost = 50; // 3-зірковий готель
                break;
            case 2:
                accommodationCost = 80; // 4-зірковий готель
                break;
            case 3:
                accommodationCost = 150; // 5-зірковий готель (харчування включено)
                break;
            case 4:
                accommodationCost = 25; // Хостел
                break;
        }

        totalCost = (ticketPrice + (accommodationCost * days) + (foodCost * days)) * quantity;

        displayDetails(); // Відображення деталей замовлення
    }
}
