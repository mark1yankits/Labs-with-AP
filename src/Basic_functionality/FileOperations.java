package Basic_functionality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

    // Метод для зчитування файлу
    public static void showBattleLog(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Виводимо кожну стрічку файлу
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
