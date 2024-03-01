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
        System.out.print("Введите стоимость одного слова: ");
        double costPerWord = in.nextDouble();

        // Подсчет количества слов и расчет стоимости
        int numberOfWords = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "").split("\\s+").length;
        double totalCost = numberOfWords * costPerWord;

        System.out.println("\nКвитанция:");
        System.out.println("Количество слов: " + numberOfWords);
        System.out.println("Стоимость одного символа: " + costPerWord);
        System.out.println("Общая стоимость: " + totalCost);
        System.out.println("Текст телеграммы: " + text);

        in.close();
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