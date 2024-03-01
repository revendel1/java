import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile();
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        int count = countWords(text);
        System.out.println("Количество слов, начинающихся с прописной буквы: " + count);
    }

    private static int countWords(String text) {
        int count = 0;

        // Разбиваем текст на слова
        String[] words = text.split("\\s+");

        // Проверяем каждое слово
        for (String word : words) {
            // Если первая буква слова - прописная, увеличиваем счетчик
            if (Character.isUpperCase(word.charAt(0))) {
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