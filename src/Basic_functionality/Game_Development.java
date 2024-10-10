package Basic_functionality;

import Battle.Battle_Mode;

import java.util.Scanner;

public class Game_Development {

    private String name;
    private int players;

    public Game_Development(String name, int players) {
        this.name = name;
        this.players = players;
    }

    public  static void choiceOfCombatSystem(){
        Scanner sc = new Scanner(System.in);

        System.out.println("mode selection:");
        System.out.println("1. fight 1 vs 1");
        System.out.println("2. team battle");
        System.out.println("3. Exit");

        int choiceMode = sc.nextInt();
        switch(choiceMode){
            case 1:
                Battle_Mode.singleCombat();
                break;
            case 2:
                Battle_Mode.teamCombat();
            case 3:
                System.exit(0);
        }
    }
}
