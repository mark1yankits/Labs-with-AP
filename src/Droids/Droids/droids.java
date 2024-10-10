package Droids.Droids;

import Droids.DroidsInf.Droid_Inf;

import java.util.Scanner;

public class droids {

    public static Droid_Inf createDroid(Scanner scanner) {

        System.out.println("Do you want look for information about all drones?");
        System.out.println("yes or no ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("yes")) {
            showAllDroids();
        }

        System.out.println("Choose a type of droid to create:");
        System.out.println("1.Titanus MK-7");
        System.out.println("2.Specter-X");
        System.out.println("3.Thunderstrike R-5");
        System.out.println("4.Storm-2V");
        System.out.println("5.Skiff-001");
        System.out.println("6.information about all drones");

        int droidType = scanner.nextInt();
        scanner.nextLine();

        Droid_Inf droid;

        switch (droidType) {
            case 1:
                System.out.println("you have chosen a droid: \n Titanus MK-7");
                droid = new Droid_Inf.TitanusMK7();
                break;
            case 2:
                System.out.println("you have chosen a droid: \n Specter-X");
                droid = new Droid_Inf.SpecterX();
                break;
            case 3:
                System.out.println("you have chosen a droid: \n Thunderstrike R-5");
                droid = new Droid_Inf.ThunderstrikeR5();
                break;
            case 4:
                System.out.println("you have chosen a droid: \n Storm-2V");
                droid = new Droid_Inf.Storm2V();
                break;
            case 5:
                System.out.println("you have chosen a droid: \n Skiff-001");
                droid = new Droid_Inf.Skiff001();
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Titanus MK-7.");
                droid = new Droid_Inf.TitanusMK7();
                break;
        }
        System.out.println("Created Droid: " + droid);
        return droid;
    }

    public static void showAllDroids() {
        System.out.println("1. Titanus MK-7:");
        System.out.println("\tDamage: 85  | Health: 2000  |");
        System.out.println("2. Specter-X:");
        System.out.println("\tDamage: 65  | Health: 800   |");
        System.out.println("3. Thunderstrike R-5:");
        System.out.println("\tDamage: 70  | Health: 1200  |");
        System.out.println("4. Storm-2V:");
        System.out.println("\tDamage: 95  | Health: 2500  |");
        System.out.println("5. Skiff-001:");
        System.out.println("\tDamage: 60  | Health: 700   |");
    }


}

