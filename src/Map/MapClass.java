package Map;

import java.util.Scanner;

public class MapClass {

    public static String MapMenu() {
        Scanner sc = new Scanner(System.in);
        int Mapchoice;

        do {
            System.out.println("Map menu:");
            System.out.println("1. Damage Mode");
            System.out.println("2. Healing Mode");
            System.out.println("3. Standard Mode");
            System.out.println("4. Information Mode");
            System.out.println("Enter your choice: ");
            Mapchoice = sc.nextInt();

            if (Mapchoice == 4) {
                MapInf();  // Виклик інформаційного меню
            }
        } while (Mapchoice == 4);  // Повертаємось до меню після показу інформації, доки не виберуть режим 1-3

        return MapBatlleMode(Mapchoice);
    }


    public static String MapBatlleMode(int map) {
        String battleMode = "";
        int modeDamage = (int) (Math.random() * 15);
        switch (map) {
            case 1:
                battleMode = "Damage Mode";

                break;
            case 2:
                battleMode = "Healing Mode";
                break;
            case 3:
                battleMode = "Standard Mode";
                break;
            default:
                battleMode = "Invalid choice";
                break;
        }
        return battleMode;
    }

    private static void MapInf() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which map would you like to know about?: ");
        System.out.println("1. Damage Mode");
        System.out.println("2. Healing Mode");
        System.out.println("3. Standard Mode");
        int Mapchoice = sc.nextInt();

        switch (Mapchoice) {
            case 1:
                System.out.println("Damage Mode: In this mode, the map causes additional damage to all droid.");
                break;
            case 2:
                System.out.println("Healing Mode: In this mode, the map heals droid randomly.");
                break;
            case 3:
                System.out.println("Standard Mode: No additional effects from the map.");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

