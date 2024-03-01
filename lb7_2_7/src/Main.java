import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile();
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        text = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", ""); // Кроме слов другие символы не нужны
        String[] words = text.split("\\s+"); // Разбиваем текст на слова

        // Находим минимальную и максимальную длину слов
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            minLength = Math.min(length, minLength);
            maxLength = Math.max(length, maxLength);
        }

        // Собираем все слова минимальной и максимальной длины
        List<String> minWords = new ArrayList<>();
        List<String> maxWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == minLength) {
                minWords.add(word);
            }
            if (word.length() == maxLength) {
                maxWords.add(word);
            }
        }

        System.out.println("Слова минимальной длины " + minLength + " символов): " + minWords);
        System.out.println("Слова максимальной длины " + maxLength + " символов): " + maxWords);
    }

    // Метод для чтения текста из файла
    private static String readFile() {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();
            return text.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}