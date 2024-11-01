package Excursion;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcursionTour {
    private static final Logger logger = Logger.getLogger(ExcursionTour.class.getName());

    public double calculateDiscount(int people) {
        return people >= 5 ? 0.1 : 0.0;
    }

    public double calculateTotalCost(int people, double pricePerPerson, double foodCost, double guideCost, double discount) {
        double totalCost = (pricePerPerson * people) + foodCost + guideCost;
        return totalCost - totalCost * discount;
    }

    public void excursionDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of people for the excursion: ");
        int people = sc.nextInt();
        logger.log(Level.INFO, "Number of people: {0}", people);

        System.out.println("Choose an excursion package:");
        System.out.println("1. France - 5 days - €500 per person");
        System.out.println("2. Germany - 7 days - €700 per person");
        System.out.println("3. Greece - 4 days - €400 per person");

        int excursionChoice = sc.nextInt();
        int days = 0;
        double pricePerPerson = 0;
        String country = "";

        switch (excursionChoice) {
            case 1 -> {
                country = "France";
                days = 5;
                pricePerPerson = 500;
            }
            case 2 -> {
                country = "Germany";
                days = 7;
                pricePerPerson = 700;
            }
            case 3 -> {
                country = "Greece";
                days = 4;
                pricePerPerson = 400;
            }
            default -> {
                System.out.println("Invalid choice. Defaulting to France.");
                country = "France";
                days = 5;
                pricePerPerson = 500;
            }
        }
        logger.log(Level.INFO, "Country selected: {0}, Days: {1}, Price per person: {2}", new Object[]{country, days, pricePerPerson});

        // Choose excursion type
        System.out.println("Choose the type of excursion:");
        System.out.println("1. Cultural");
        System.out.println("2. Nature");
        System.out.println("3. Gastronomic");
        int excursionType = sc.nextInt();
        String type = switch (excursionType) {
            case 1 -> "Cultural";
            case 2 -> "Nature";
            case 3 -> "Gastronomic";
            default -> {
                System.out.println("Invalid choice. Defaulting to Cultural.");
                yield "Cultural";
            }
        };
        logger.log(Level.INFO, "Excursion type selected: {0}", type);

        // Choose meal inclusion
        System.out.println("Would you like to include meals?");
        System.out.println("1. Full board (€30 per day)");
        System.out.println("2. No meals");
        int foodChoice = sc.nextInt();
        double foodCost = (foodChoice == 1) ? 30 * days : 0;
        logger.log(Level.INFO, "Food choice selected: {0}, Food cost: {1}", new Object[]{foodChoice == 1 ? "Full board" : "No meals", foodCost});

        // Choose guide option
        System.out.println("Choose a guide option:");
        System.out.println("1. Personal guide (€50 per day)");
        System.out.println("2. Audio guide (€10 per day)");
        int guideChoice = sc.nextInt();
        double guideCost = (guideChoice == 1) ? 50 * days : 10 * days;
        logger.log(Level.INFO, "Guide option selected: {0}, Guide cost: {1}", new Object[]{guideChoice == 1 ? "Personal guide" : "Audio guide", guideCost});

        // Calculate discount if applicable
        double discount = calculateDiscount(people);
        logger.log(Level.INFO, "Discount applied: {0}%", discount * 100);

        // Calculate total cost
        double totalCost = calculateTotalCost(people, pricePerPerson, foodCost, guideCost, discount);
        logger.log(Level.INFO, "Total cost calculated: {0} €", totalCost);

        // Display results
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
