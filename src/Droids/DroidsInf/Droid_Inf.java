package Droids.DroidsInf;

public class Droid_Inf {
    protected String name;
    protected int health;
    protected int damage;


    public Droid_Inf(String name, int damage, int health) {
        this.damage = damage;
        this.name = name;
        this.health = health;

    }

    public boolean isAlive() {
        return health > 0; // Повертає true, якщо здоров'я більше 0
    }

    // Метод для нанесення шкоди
    public void takeDamage(int damage) {
        health -= damage; // Зменшує здоров'я на значення шкоди
    }



    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name + " | Health: " + health + " | Damage: " + damage;
    }

    public static class TitanusMK7 extends Droid_Inf {
        public TitanusMK7() {
            super("Titanus MK-7", 35, 200);
        }
    }

    public static class SpecterX extends Droid_Inf {
        public SpecterX() {
            super("Specter-X", 45, 250);
        }
    }

    public static class ThunderstrikeR5 extends Droid_Inf {
        public ThunderstrikeR5() {
            super("Thunderstrike R-5", 60, 120);
        }
    }

    public static class Storm2V extends Droid_Inf {
        public Storm2V() {
            super("Storm-2V", 35, 250);
        }
    }

    public static class Skiff001 extends Droid_Inf {
        public Skiff001() {
            super("Skiff-001", 25, 300);
        }
    }
}
