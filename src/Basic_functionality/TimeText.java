package Basic_functionality;

public class TimeText {
    public static void printWithDelay(String message, int delay) {
        try {
            Thread.sleep(delay);  // Затримка перед виведенням всього тексту
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Вивести текст червоним кольором, потім повернути стандартний колір
        System.out.println("\033[31m" + message + "\033[0m");
    }
}
