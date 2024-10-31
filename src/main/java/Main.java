import Command.*;
import Cruise.CruiseTour;
import Excursion.ExcursionTour;
import Medical.MedicalTour;
import Rest.RestTour;
import Shopping.ShoppingTour;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t Menu");
            System.out.println("1. Choice of travel");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Initialize each command with the necessary tour objects
                    RestCommand restCommand = new RestCommand(new RestTour());
                    ExcursionCommand excursionCommand = new ExcursionCommand(new ExcursionTour());
                    MedicalCommand medicalCommand = new MedicalCommand(new MedicalTour(sc)); // Pass scanner if needed
                    ShoppingCommand shoppingCommand = new ShoppingCommand(new ShoppingTour());
                    CruiseCommand cruiseCommand = new CruiseCommand(new CruiseTour());

                    // Pass these commands into ChoiceTravel
                    ChoiceTravel travel = new ChoiceTravel(restCommand, excursionCommand, medicalCommand, shoppingCommand, cruiseCommand);
                    travel.showMenu();
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 2);

        sc.close();
    }
}
