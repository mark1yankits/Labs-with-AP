package Medical;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalTour {
    private static final Logger logger = Logger.getLogger(MedicalTour.class.getName());
    public Scanner sc;
    public String country;
    public String accommodationType;
    public String condition;
    public String transport;
    public String currency;
    public int days;
    public double accommodationCost;
    public double treatmentCost;
    public double transportCost;
    public double foodCost;
    public double totalCost;

    // Constructor with Scanner
    public MedicalTour(Scanner sc) {
        this.sc = sc;
        logger.log(Level.INFO, "MedicalTour instance created.");
    }

    public void inputDetails() {
        displayCountryOptions();
        int countryChoice = sc.nextInt();
        sc.nextLine();
        chooseCountry(countryChoice);

        displayAccommodationPrices();
        chooseAccommodation();

        displayTransportPrices();
        chooseTransport();

        displayTreatmentPrices();
        chooseCondition();

        calculateTotalCost();
    }

    private void displayCountryOptions() {
        System.out.println("Choose a country for treatment:");
        System.out.println("1. UK (London) - £150 per day");
        System.out.println("2. Spain (Barcelona) - €120 per day");
        System.out.println("3. Italy (Rome) - €130 per day");
        System.out.println("4. Mauritius - $110 per day");
    }

    public void chooseCountry(int choice) {
        switch (choice) {
            case 1 -> {
                country = "UK (London)";
                accommodationCost = 150;
                currency = "£";
            }
            case 2 -> {
                country = "Spain (Barcelona)";
                accommodationCost = 120;
                currency = "€";
            }
            case 3 -> {
                country = "Italy (Rome)";
                accommodationCost = 130;
                currency = "€";
            }
            case 4 -> {
                country = "Mauritius";
                accommodationCost = 110;
                currency = "$";
            }
            default -> {
                System.out.println("Invalid choice, defaulting to UK (London).");
                country = "UK (London)";
                accommodationCost = 150;
                currency = "£";
            }
        }
        logger.log(Level.INFO, "Country selected: {0}, Accommodation cost per day: {1} {2}", new Object[]{country, accommodationCost, currency});
    }

    private void displayAccommodationPrices() {
        System.out.println("Accommodation options:");
        System.out.println("1. Hospital (50% more expensive, food £50/day)");
        System.out.println("2. Hotel (food £30/day)");
    }

    public void chooseAccommodation() {
        System.out.println("Do you want to stay in a hospital or hotel?");
        int accChoice = sc.nextInt();
        sc.nextLine();

        if (accChoice == 1) {
            accommodationType = "Hospital";
            accommodationCost *= 1.5;
            foodCost = 50;
        } else {
            accommodationType = "Hotel";
            foodCost = 30;
        }

        System.out.print("Enter the number of days for treatment: ");
        days = sc.nextInt();
        logger.log(Level.INFO, "Accommodation selected: {0}, Cost per day: {1} {2}, Days: {3}", new Object[]{accommodationType, accommodationCost, currency, days});
    }

    private void displayTransportPrices() {
        System.out.println("Transport options:");
        System.out.println("1. Airplane - fixed cost: £300");
        System.out.println("2. Bus - fixed cost: £100");
    }

    public void chooseTransport() {
        System.out.println("Choose a transport option:");
        int transportChoice = sc.nextInt();
        sc.nextLine();

        if (transportChoice == 1) {
            transport = "Airplane";
            transportCost = 300;
        } else {
            transport = "Bus";
            transportCost = 100;
        }
        logger.log(Level.INFO, "Transport selected: {0}, Transport cost: {1} {2}", new Object[]{transport, transportCost, currency});
    }

    private void displayTreatmentPrices() {
        System.out.println("Treatment options:");
        System.out.println("1. Cancer - £5000");
        System.out.println("2. Skin Infection - £2000");
        System.out.println("3. Childbirth - £3000");
        System.out.println("4. Heart Surgery - £8000");
    }

    public void chooseCondition() {
        System.out.println("What condition are you seeking treatment for?");
        int conditionChoice = sc.nextInt();
        sc.nextLine();

        switch (conditionChoice) {
            case 1 -> {
                condition = "Cancer";
                treatmentCost = 5000;
            }
            case 2 -> {
                condition = "Skin Infection";
                treatmentCost = 2000;
            }
            case 3 -> {
                condition = "Childbirth";
                treatmentCost = 3000;
            }
            case 4 -> {
                condition = "Heart Surgery";
                treatmentCost = 8000;
            }
            default -> {
                System.out.println("Invalid choice, defaulting to Skin Infection.");
                condition = "Skin Infection";
                treatmentCost = 2000;
            }
        }
        logger.log(Level.INFO, "Condition selected: {0}, Treatment cost: {1} {2}", new Object[]{condition, treatmentCost, currency});
    }

    public void calculateTotalCost() {
        totalCost = (accommodationCost * days) + treatmentCost + (foodCost * days) + transportCost;
        logger.log(Level.INFO, "Total cost calculated: {0} {1}", new Object[]{totalCost, currency});
        displayDetails();
    }

    public void displayDetails() {
        System.out.println("\nBooking Details:");
        System.out.println("Country: " + country);
        System.out.println("Accommodation: " + accommodationType);
        System.out.println("Condition: " + condition);
        System.out.println("Transport: " + transport);
        System.out.println("Days: " + days);
        System.out.println("Total cost: " + totalCost + " " + currency);
    }

    // Getters
    public String getCondition() {
        return condition;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }
}
