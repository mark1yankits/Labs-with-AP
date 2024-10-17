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
                    ChoiceTravel travel = new ChoiceTravel();
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
