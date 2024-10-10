package Battle;
import Droids.Droids.droids;
import Droids.DroidsInf.Droid_Inf;
import Map.MapClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle_Mode {

    public static void singleCombat() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of player 1:");
        String playerName = sc.nextLine();

        System.out.println("Player " + playerName + ", please choose your droid:");
        Droid_Inf droid1 = droids.createDroid(sc); // Вибір дроїда для гравця 1

        // Вибір дроїда для бота
        System.out.println("BOT is choosing its droid...");
        Droid_Inf droid2 = droids.createDroid(sc);

        // Запуск бою між двома дроїдами
        System.out.println("Starting a fight between " + playerName + "'s droid and BOT's droid!");
        BattleSystem battleSystem = new BattleSystem();
        String gameMode = MapClass.MapMenu();
        battleSystem.singleBattle(droid1, droid2, playerName, gameMode);
    }

    public static void teamCombat() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of your team:");
        String team_name = sc.nextLine();

        if (team_name == null || team_name.isEmpty()) {
            System.out.println("Team name cannot be null or empty.");
            return;
        }

        System.out.println("Team " + team_name + ", please specify the number of players in your team:");
        int team_num = sc.nextInt();
        sc.nextLine();

        if (team_num <= 1) {
            System.out.println("Team size must be greater than 1.");
            return;
        }

        ArrayList<String> players = new ArrayList<>();
        ArrayList<Droid_Inf> playerDroids = new ArrayList<>();

        // Введення імені гравців та вибір дроїдів
        for (int i = 0; i < team_num; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ": ");
            String playerName = sc.nextLine();

            if (playerName == null || playerName.isEmpty()) {
                System.out.println("Player name cannot be null or empty.");
                i--; // Якщо ім'я не введено, повторити запит
                continue;
            }

            players.add(playerName);

            System.out.println("Player " + playerName + ", please choose your droid:");
            Droid_Inf droid = droids.createDroid(sc);
            playerDroids.add(droid);
        }

        // Запуск командного бою
        BattleSystem battleSystem = new BattleSystem();
        for (int i = 0; i < team_num; i++) {
            String playerName = players.get(i);
            Droid_Inf playerDroid = playerDroids.get(i);

            Droid_Inf botDroid = droids.createDroid(sc); // Дрон для бота

            System.out.println("Starting a fight between " + playerName + "'s droid and BOT's droid!");

            //battleSystem.singleBattle(playerDroid, botDroid, playerName);
        }
    }
}
