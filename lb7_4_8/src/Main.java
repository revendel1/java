import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile();
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово которое надо найти: ");
        String word = in.nextLine();

        int count = count(text, word);
        System.out.println("Слово \"" + word + "\" встречается в тексте " + count + " раз(а).");
    }

    private static int count(String text, String word) {
        int count = 0;

        // Удаление небуквенных символов
        text = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "");

        // Разбиваем текст на слова
        String[] words = text.split("\\s+");

        // Сравниваем каждое слово с заданным словом
        for (String w : words) {
            // Игнорируем регистр символов
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }

        return count;
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