import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt"; // Путь к файлу с текстом
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Разделение строки на слова
                for (String word : words) {
                    word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", ""); // Удаление знаков препинания из слов
                    uniqueWords.add(word.toLowerCase()); // Добавление слов в сет с преобразованием их к нижнему регистру
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Уникальные слова в тексте:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}