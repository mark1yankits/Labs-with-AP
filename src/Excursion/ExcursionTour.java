package Excursion;

import java.util.Scanner;

public class ExcursionTour {
    public void excursionDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of people for the excursion: ");
        int people = sc.nextInt();

        System.out.println("Choose an excursion package:");
        System.out.println("1. France - 5 days - €500 per person");
        System.out.println("2. Germany - 7 days - €700 per person");
        System.out.println("3. Greece - 4 days - €400 per person");

        int excursionChoice = sc.nextInt();
        int days = 0;
        double pricePerPerson = 0;
        String country = "";

        switch (excursionChoice) {
            case 1:
                country = "France";
                days = 5;
                pricePerPerson = 500;
                break;
            case 2:
                country = "Germany";
                days = 7;
                pricePerPerson = 700;
                break;
            case 3:
                country = "Greece";
                days = 4;
                pricePerPerson = 400;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to France.");
                country = "France";
                days = 5;
                pricePerPerson = 500;
                break;
        }

        // Додаємо вибір типу екскурсії
        System.out.println("Choose the type of excursion:");
        System.out.println("1. Cultural");
        System.out.println("2. Nature");
        System.out.println("3. Gastronomic");
        int excursionType = sc.nextInt();
        String type = "";
        switch (excursionType) {
            case 1:
                type = "Cultural";
                break;
            case 2:
                type = "Nature";
                break;
            case 3:
                type = "Gastronomic";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Cultural.");
                type = "Cultural";
                break;
        }

        // Додаємо вибір харчування
        System.out.println("Would you like to include meals?");
        System.out.println("1. Full board (€30 per day)");
        System.out.println("2. No meals");
        int foodChoice = sc.nextInt();
        double foodCost = 0;
        if (foodChoice == 1) {
            foodCost = 30 * days;
        }


        System.out.println("Choose a guide option:");
        System.out.println("1. Personal guide (€50 per day)");
        System.out.println("2. Audio guide (€10 per day)");
        int guideChoice = sc.nextInt();
        double guideCost = 0;
        if (guideChoice == 1) {
            guideCost = 50 * days;
        } else {
            guideCost = 10 * days;
        }

        double discount = 0;
        if (people >= 5) {
            discount = 0.1;
        }

        // Розрахунок загальної вартості
        double totalCost = (pricePerPerson * people) + foodCost + guideCost;
        totalCost -= totalCost * discount; // Віднімання знижки

        // Виведення результатів
        System.out.println("\nExcursion Details:");
        System.out.println("Country: " + country);
        System.out.println("Excursion type: " + type);
        System.out.println("Number of people: " + people);
        System.out.println("Days: " + days);
        System.out.println("Transport: Bus");
        System.out.println("Meals cost: " + foodCost + " €");
        System.out.println("Guide cost: " + guideCost + " €");
        System.out.println("Discount: " + (discount * 100) + "%");
        System.out.println("Total cost: " + totalCost + " €");
    }
}
