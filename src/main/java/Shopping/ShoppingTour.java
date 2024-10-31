package Shopping;

import java.util.Scanner;

public class ShoppingTour {
    public void shoppingDetails() {
        Scanner sc = new Scanner(System.in);

        // Вибір країни для шопінгу
        System.out.println("Choose a country for shopping:");
        System.out.println("1. Italy");
        System.out.println("2. France");
        System.out.println("3. USA");
        System.out.println("4. Japan");

        int countryChoice = sc.nextInt();
        String country = "";
        String[] topBrands = new String[3];

        switch (countryChoice) {
            case 1:
                country = "Italy";
                topBrands = new String[]{"Gucci", "Prada", "Armani"};
                break;
            case 2:
                country = "France";
                topBrands = new String[]{"Louis Vuitton", "Chanel", "Dior"};
                break;
            case 3:
                country = "USA";
                topBrands = new String[]{"Nike", "Ralph Lauren", "Michael Kors"};
                break;
            case 4:
                country = "Japan";
                topBrands = new String[]{"Uniqlo", "Sony", "Issey Miyake"};
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Italy.");
                country = "Italy";
                topBrands = new String[]{"Gucci", "Prada", "Armani"};
                break;
        }

        // Виведення топ брендів
        System.out.println("\nTop brands in " + country + ":");
        for (String brand : topBrands) {
            System.out.println("- " + brand);
        }

        // Вибір транспорту
        System.out.println("\nChoose a transport option:");
        System.out.println("1. Plane");
        System.out.println("2. Train");
        System.out.println("3. Bus");
        int transportChoice = sc.nextInt();
        String transport = "";
        switch (transportChoice) {
            case 1:
                transport = "Plane";
                break;
            case 2:
                transport = "Train";
                break;
            case 3:
                transport = "Bus";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Plane.");
                transport = "Plane";
                break;
        }

        // Вибір готелю
        System.out.println("\nChoose a hotel type:");
        System.out.println("1. Luxury Hotel (€200 per night)");
        System.out.println("2. Standard Hotel (€100 per night)");
        System.out.println("3. Budget Hotel (€50 per night)");
        int hotelChoice = sc.nextInt();
        String hotelType = "";
        double hotelCost = 0;
        switch (hotelChoice) {
            case 1:
                hotelType = "Luxury Hotel";
                hotelCost = 200;
                break;
            case 2:
                hotelType = "Standard Hotel";
                hotelCost = 100;
                break;
            case 3:
                hotelType = "Budget Hotel";
                hotelCost = 50;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Standard Hotel.");
                hotelType = "Standard Hotel";
                hotelCost = 100;
                break;
        }

        // Вибір оренди машини
        System.out.println("\nWould you like to rent a car? (€50 per day)");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int rentCarChoice = sc.nextInt();
        boolean rentCar = rentCarChoice == 1;
        double carRentalCost = rentCar ? 50 : 0;

        // Підрахунок загальної вартості
        System.out.print("\nEnter the number of days for the shopping tour: ");
        int days = sc.nextInt();
        double totalCost = (hotelCost * days) + (carRentalCost * days);

        // Виведення деталей туру
        System.out.println("\nShopping Tour Details:");
        System.out.println("Country: " + country);
        System.out.println("Transport: " + transport);
        System.out.println("Hotel: " + hotelType);
        System.out.println("Car rental: " + (rentCar ? "Yes" : "No"));
        System.out.println("Total cost: " + totalCost + " €");
    }
}
