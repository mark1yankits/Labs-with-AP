import Command.*;
import java.util.Scanner;

public class ChoiceTravel {

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
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choiceTravel != 6);

        sc.close();
    }

    public void executeRest() {
        restCommand.execute();
    }

    public void executeExcursion() {
        excursionCommand.execute();
    }

    public void executeMedical(Scanner sc) {
        medicalCommand.execute();
    }

    public void executeShopping() {
        shoppingCommand.execute();
    }

    public void executeCruise() {
        cruiseCommand.execute();
    }
}
