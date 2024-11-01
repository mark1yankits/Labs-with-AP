import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Command.*;
import java.util.Scanner;

public class ChoiceTravel {

    private static final Logger logger = LogManager.getLogger(ChoiceTravel.class);

    private final RestCommand restCommand;
    private final ExcursionCommand excursionCommand;
    private final MedicalCommand medicalCommand;
    private final ShoppingCommand shoppingCommand;
    private final CruiseCommand cruiseCommand;

    public ChoiceTravel(RestCommand restCommand, ExcursionCommand excursionCommand,
                        MedicalCommand medicalCommand, ShoppingCommand shoppingCommand,
                        CruiseCommand cruiseCommand) {
        this.restCommand = restCommand;
        this.excursionCommand = excursionCommand;
        this.medicalCommand = medicalCommand;
        this.shoppingCommand = shoppingCommand;
        this.cruiseCommand = cruiseCommand;
        logger.info("ChoiceTravel об'єкт створено з усіма командами");
    }

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
            logger.info("Користувач обрав опцію: " + choiceTravel);

            switch (choiceTravel) {
                case 1:
                    executeRest();
                    break;
                case 2:
                    executeExcursion();
                    break;
                case 3:
                    executeMedical(sc);
                    break;
                case 4:
                    executeShopping();
                    break;
                case 5:
                    executeCruise();
                    break;
                case 6:
                    logger.info("Користувач завершив програму.");
                    System.out.println("Exiting program...");
                    break;
                default:
                    logger.warn("Неправильний вибір: " + choiceTravel);
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choiceTravel != 6);

        sc.close();
        logger.info("Сканер закрито після завершення меню вибору.");
    }

    public void executeRest() {
        logger.info("Виконується RestCommand");
        restCommand.execute();
    }

    public void executeExcursion() {
        logger.info("Виконується ExcursionCommand");
        excursionCommand.execute();
    }

    public void executeMedical(Scanner sc) {
        logger.info("Виконується MedicalCommand");
        medicalCommand.execute();
    }

    public void executeShopping() {
        logger.info("Виконується ShoppingCommand");
        shoppingCommand.execute();
    }

    public void executeCruise() {
        logger.info("Виконується CruiseCommand");
        cruiseCommand.execute();
    }
}
