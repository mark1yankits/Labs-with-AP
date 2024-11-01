package Rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class RestTour {
    private static final Logger logger = LogManager.getLogger(RestTour.class);

    private Scanner sc;
    public int quantity;
    public int days;
    public String nutrition = "No meal option selected"; // Значення за замовчуванням
    public int hostelNum;
    public int transport;
    public double ticketPrice;
    public double totalCost;
    private int foodChoice;
    public double foodCost;
    public double accommodationCost;
    public String currency;
    public String destination;

    public RestTour(Scanner sc) {
        this.sc = sc;
    }

    public RestTour() {
        this(new Scanner(System.in));
    }

    public void inputDetails() {
        System.out.println("Rest table cost");
        System.out.println("1. Ua (Lviv) - UK (London)");
        System.out.println("2. Ua (Lviv) - Spain (Barcelona)");
        System.out.println("3. Ua (Lviv) - Italy (Rome)");
        System.out.println("4. Ua (Lviv) - Mauritius");

        int choice = sc.nextInt();
        logger.info("Вибраний маршрут: " + choice);

        if (!choiceMarch(choice)) {
            logger.warn("Неправильний вибір маршруту: " + choice);
        }

        calculateTotalCost();
    }

    public void displayDetails() {
        System.out.println("Booking for " + quantity + " people.");
        System.out.println("Days: " + days);
        System.out.println("Nutrition: " + nutrition);
        System.out.println("Transport: " + (transport == 1 ? "Plane" : "Bus"));
        System.out.println("Total cost: " + totalCost + " " + currency);
        logger.info("Деталі туру: " + quantity + ", Загальна вартість: " + totalCost + " " + currency);
    }

    public boolean choiceMarch(int choice) {
        boolean isCurrencyValid;
        switch (choice) {
            case 1 -> {
                currency = "£";
                destination = "UK (London)";
                displayRouteDetails(destination, 150, 40, currency);
                isCurrencyValid = true;
            }
            case 2 -> {
                currency = "€";
                destination = "Spain (Barcelona)";
                displayRouteDetails(destination, 150, 40, currency);
                isCurrencyValid = true;
            }
            case 3 -> {
                currency = "€";
                destination = "Italy (Rome)";
                displayRouteDetails(destination, 150, 40, currency);
                isCurrencyValid = true;
            }
            case 4 -> {
                currency = "$";
                destination = "Mauritius";
                displayRouteDetails(destination, 300, 100, currency);
                isCurrencyValid = true;
            }
            default -> {
                System.out.println("Invalid choice.");
                currency = null;
                destination = null;
                isCurrencyValid = false;
            }
        }
        logger.info("Вибраний напрямок: " + destination + ", Валюта: " + currency);
        return isCurrencyValid;
    }

    public void displayRouteDetails(String destination, int planePrice, int busPrice, String currency) {
        this.destination = destination;
        this.currency = currency;

        System.out.println("------------------------------------------------");
        System.out.println("| Route: " + destination);
        System.out.println("| Plane cost: " + planePrice + " " + currency);
        System.out.println("| Bus cost: " + busPrice + " " + currency);
        System.out.println("------------------------------------------------");

        if (!sc.hasNextInt()) {
            logger.warn("Недостатньо введених даних для тестування.");
            return;
        }

        System.out.print("How many people you want to book a trip for: ");
        this.quantity = sc.nextInt();
        logger.info("Кількість людей: " + quantity);

        System.out.print("Enter the number of days: ");
        this.days = sc.nextInt();
        logger.info("Кількість днів: " + days);

        System.out.println("Enter the type of transport: ");
        System.out.println("1. Plane");
        System.out.println("2. Bus");
        this.transport = sc.nextInt();
        this.ticketPrice = (this.transport == 1) ? planePrice : busPrice;
        logger.info("Вибраний транспорт: " + (transport == 1 ? "Літак" : "Автобус") + ", Ціна квитка: " + ticketPrice);

        System.out.println("Accommodation options:");
        System.out.println("1. 3-Star Hotel (50 " + currency + " per night)");
        System.out.println("2. 4-Star Hotel (80 " + currency + " per night)");
        System.out.println("3. 5-Star Hotel (150 " + currency + " per night, meals included)");
        System.out.println("4. Hostel (25 " + currency + " per night)");
        this.hostelNum = sc.nextInt();

        if (this.hostelNum != 3) {
            System.out.println("1. Breakfast - 10 " + currency);
            System.out.println("2. Half Board - 20 " + currency);
            System.out.println("3. Full Board - 30 " + currency);
            System.out.print("Choose food option: ");

            if (sc.hasNextInt()) {
                this.foodChoice = sc.nextInt();
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
                    default -> nutrition = "No meal option selected";
                }
            } else {
                nutrition = "No meal option selected";
            }
        } else {
            nutrition = "Meals included";
            foodCost = 0;
        }
        logger.info("Вибрано харчування: " + nutrition + ", Вартість харчування на день: " + foodCost);
    }

    public void calculateTotalCost() {
        switch (hostelNum) {
            case 1 -> accommodationCost = 50;
            case 2 -> accommodationCost = 80;
            case 3 -> accommodationCost = 150;
            case 4 -> accommodationCost = 25;
        }
        totalCost = (ticketPrice + (accommodationCost * days) + (foodCost * days)) * quantity;
        logger.info("Розрахунок загальної вартості: " + totalCost + " " + currency);
        displayDetails();
    }
}
