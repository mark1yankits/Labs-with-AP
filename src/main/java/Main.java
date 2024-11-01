import Command.*;
import Cruise.CruiseTour;
import Excursion.ExcursionTour;
import Medical.MedicalTour;
import Rest.RestTour;
import Shopping.ShoppingTour;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        logger.info("Програма запущена");

        do {
            try {
                System.out.println("\t Menu");
                System.out.println("1. Choice of travel");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                logger.info("Користувач обрав: " + choice);

                switch (choice) {
                    case 1:
                        logger.info("Початок вибору туру");

                        // Initialize each command with the necessary tour objects
                        RestCommand restCommand = new RestCommand(new RestTour());
                        ExcursionCommand excursionCommand = new ExcursionCommand(new ExcursionTour());
                        MedicalCommand medicalCommand = new MedicalCommand(new MedicalTour(sc)); // Pass scanner if needed
                        ShoppingCommand shoppingCommand = new ShoppingCommand(new ShoppingTour());
                        CruiseCommand cruiseCommand = new CruiseCommand(new CruiseTour());

                        // Pass these commands into ChoiceTravel
                        ChoiceTravel travel = new ChoiceTravel(restCommand, excursionCommand, medicalCommand, shoppingCommand, cruiseCommand);
                        travel.showMenu();
                        logger.info("Вибір туру завершено");
                        break;

                    case 2:
                        logger.info("Вихід із програми...");
                        System.out.println("Exiting program...");
                        break;

                    default:
                        logger.warn("Неправильний вибір: " + choice);
                        System.out.println("Invalid choice. Please select again.");
                }
            } catch (InputMismatchException e) {
                logger.error("Сталася критична помилка: " + e.getMessage(), e);
                System.out.println("Будь ласка, введіть числове значення.");
                sc.next(); // очищаємо ввід
            } catch (Exception e) {
                logger.error("Сталася критична помилка: " + e.getMessage(), e);
            }
        } while (choice != 2);

        sc.close();
        logger.info("Програма завершена");
    }
}
