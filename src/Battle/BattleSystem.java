package Battle;

import Basic_functionality.TimeText;
import Droids.DroidsInf.Droid_Inf;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class BattleSystem {

    private static final Logger logger = Logger.getLogger(BattleSystem.class.getName());
    private static boolean logToFile = false;

    static {

        try {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleLogFormatter());  // Встановлюємо свій форматер для консолі
            logger.addHandler(consoleHandler);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Простий форматувальник, який виводить лише повідомлення
    public static class SimpleLogFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + "\n";  // Повертаємо лише текст повідомлення
        }
    }

    private static void initFileLogger(String filePath) {
        try {
            // Спочатку видаляємо всі наявні обробники
            for (Handler handler : logger.getHandlers()) {
                logger.removeHandler(handler);
            }

            // Додаємо новий обробник файлів
            FileHandler fileHandler = new FileHandler(filePath, true);  // true означає дописування в файл
            fileHandler.setFormatter(new SimpleLogFormatter());  // Встановлюємо свій форматер для файлу
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void teamBattle(List<Droid_Inf> team1, List<String> teamNames, List<Droid_Inf> team2) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to log the battle into a file? (yes/no)");
        String userChoice = scanner.nextLine();

        if (userChoice.equalsIgnoreCase("yes")) {
            logToFile = true;
            System.out.println("Please enter the path to save the log file (e.g., C:/logs/battle_log.log):");
            String filePath = scanner.nextLine();  // Запитуємо шлях збереження файлу
            initFileLogger(filePath);
        }

        if (team1.size() != team2.size()) {
            TimeText.printWithDelay("Both teams must have the same number of drones!", 2000);
            logger.info("Both teams must have the same number of drones!");
            return;
        }

        TimeText.printWithDelay("\t\tThe beginning of a team battle",1000);
        logger.info("The beginning of a team battle");
        System.out.println(" ");

        for (int i = 0; i < team1.size(); i++) {
            Droid_Inf droid_1 = team1.get(i);
            Droid_Inf droid_2 = team2.get(i);
            String playerName = teamNames.get(i);

            TimeText.printWithDelay("\nFight " + (i + 1) + ":",1000);
            logger.info("\nFight " + (i + 1) + ":");
            TimeText.printWithDelay(teamNames.get(i) + " Drone attacks Bot's drone!",2000);
            logger.info(teamNames.get(i) + " Drone attacks Bot's drone!");


            singleBattle(droid_1, droid_2, teamNames.get(i),"Damage Mode");
        }
    }


    public static void singleBattle(Droid_Inf droid_1, Droid_Inf droid_2, String playerName, String battleMode) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to log the battle into a file? (yes/no)");
        String userChoice = scanner.nextLine();

        if (userChoice.equalsIgnoreCase("yes")) {
            logToFile = true;
            System.out.println("Please enter the path to save the log file (e.g., C:/logs/battle_log_single.txt):");
            String filePath = scanner.nextLine();  // Запитуємо шлях збереження файлу
            initFileLogger(filePath);
        }

        Random rand = new Random();
        int health_1 = droid_1.getHealth();
        int health_2 = droid_2.getHealth();

        TimeText.printWithDelay(playerName + " drone attacks bot drone",2000);
        logger.info(playerName + " drone attacks bot drone");

        while (health_1 > 0 && health_2 > 0) {

            int hit_1 = rand.nextInt(droid_1.getDamage());
            health_2 -= hit_1;

            int randNumber = rand.nextInt(10) + 1;
            if(battleMode.equals("Damage Mode")) {
                health_2 -= randNumber;
                System.out.println("Map damage applied to BOT's droid: " + randNumber);
                logger.info("Map damage applied to BOT's droid: " + randNumber);
            } else if(battleMode.equals("Healing Mode")) {
                health_2 += randNumber;
                System.out.println("Map healing applied to BOT's droid: " + randNumber);
                logger.info("Map healing applied to BOT's droid: " + randNumber);
            }

            TimeText.printWithDelay(playerName + " drone attacks bot drone " + hit_1 + " damage." +
                    "\n\nBot's drone health = " + health_2 + "\n\n\n", 1000  );

            logger.info(playerName + " drone attacks bot drone " + hit_1 +
                    " damage. Bot's drone health = " + health_2 + "\n\n\n");

            if (health_2 <= 0) {
                System.out.println("\n\t\t" + playerName + " WINS !!!!");
                logger.info("\n\t\t" +playerName + " WINS !!!!");
                break;
            }

            int hit_2 = rand.nextInt(droid_2.getDamage());
            health_1 -= hit_2;

            int randNumber_2 = rand.nextInt(10) + 1;
            if (battleMode.equals("Damage Mode")) {
                health_1 -= randNumber_2;
                System.out.println("Map damage droid " + playerName + ": " + randNumber_2);
                logger.info("Map damage droid " + playerName + ": " + randNumber_2);
            } else if (battleMode.equals("Healing Mode")) {
                health_1 += randNumber_2;
                System.out.println("Map healing droid " + playerName + ": " + randNumber_2);
                logger.info("Map healing droid " + playerName + ": " + randNumber_2);
            }


            TimeText.printWithDelay("Bot's drone inflicts a drone " + playerName + " " + hit_2 + " damage." +
                    "\n\n drone health " + playerName + " = " + health_1 + "\n\n\n", 1000);
            logger.info("Bot's drone inflicts a drone " + playerName + " " + hit_2
                    + " damage. \n\ndrone health " + playerName + " = " + health_1 + "\n\n\n");

            if (health_1 <= 0) {
                TimeText.printWithDelay("\n\t\tBOT WINS !!!!", 2000);
                logger.info("\n\t\tBOT WINS !!!!");
                break;
            }
        }


    }

}
