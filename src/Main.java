import java.util.Scanner;

import Basic_functionality.FileOperations;
import Basic_functionality.Game_Development;
import Droids.Droids.droids;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start game:");

        while (true) {  // Додаємо цикл для повторного показу меню після кожного вибору
            System.out.println("\nMenu:");
            System.out.println("1. Create team");
            System.out.println("2. Show all drons");
            System.out.println("3. Rules of the game");
            System.out.println("4. Show battle log");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Game_Development.choiceOfCombatSystem();
                    break;
                case 2:
                    droids.showAllDroids();
                    break;
                case 3:
                    showGameRules();  // Виклик методу для показу правил гри
                    break;
                case 4:
                    System.out.println("Enter the path to the battle log file: ");
                    sc.nextLine();  // Очистити буфер після введення числа
                    String filePath = sc.nextLine();
                    FileOperations.showBattleLog(filePath);  // Виклик методу зчитування файлу
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Метод для показу правил гри
    public static void showGameRules() {
        System.out.println("\n===== Game Rules =====");
        System.out.println("1. The game consists of two teams of droid fighting each other.");
        System.out.println("2. Each team must have an equal number of droid.");
        System.out.println("3. Every droid has its own health and damage points.");
        System.out.println("4. The goal is to destroy all droid on the opponent's team.");
        System.out.println("5. Battles take place turn by turn. On each turn, a droid attacks an opponent.");
        System.out.println("6. During the battle, random damage can be applied, including map effects like additional damage or healing.");
        System.out.println("7. The game offers two battle modes: 'Damage Mode' (where extra damage is applied) and 'Healing Mode' (where health is restored).");
        System.out.println("8. The team that eliminates all opponent droid wins the game.");
        System.out.println("======================\n");
    }
}
