import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile();
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        // Удаление небуквенных символов
        text = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "");
        // Заменить последовательности пробелов на один
        text = text.replaceAll("\\s+", " ");

        System.out.println("Результат:\n" + text);
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