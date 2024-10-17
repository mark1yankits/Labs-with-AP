import Command.CruiseCommand;
import Command.MedicalCommand;
import Command.ShoppingCommand;
import Command.RestCommand;
import Command.ExcursionCommand;
import Cruise.CruiseTour;
import Excursion.ExcursionTour;
import Medical.MedicalTour;
import Rest.RestTour;
import Shopping.ShoppingTour;

import java.util.Scanner;

public class ChoiceTravel {

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choiceTravel;

        do {
            System.out.println("\t Menu");
            System.out.println("1. Rest");
            System.out.println("2. Excursion");
            System.out.println("3. Treatment");
            System.out.println("4. Shopping");
            System.out.println("5. Cruise");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choiceTravel = sc.nextInt();

            switch (choiceTravel) {
                case 1:
                    new RestCommand(new RestTour()).execute();
                    break;
                case 2:
                    new ExcursionCommand(new ExcursionTour()).execute();
                    break;
                case 3:
                    new MedicalCommand(new MedicalTour()).execute();
                    break;
                case 4:
                    new ShoppingCommand(new ShoppingTour()).execute();
                    break;
                case 5:
                    new CruiseCommand(new CruiseTour()).execute();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choiceTravel != 6);

        sc.close();
    }
}
