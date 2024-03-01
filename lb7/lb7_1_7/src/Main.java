import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile("input.txt");
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        // Ввод признака и, если необходимо, значения k
        Scanner in = new Scanner(System.in);
        System.out.print("Введите признак (0 или 1): ");
        int flag = in.nextInt();
        in.nextLine();

        System.out.print("Введите символ: ");
        String input = in.nextLine();
        char symbol = input.charAt(0);

        if (flag == 1) {
            System.out.print("Введите значение k: ");
            int k = in.nextInt();
            text = insertSymbolAfterK(text, k, symbol);
        } else if (flag == 0) {
            text = removeSymbol(text, symbol);
        } else {
            System.out.println("Введен неверный признак.");
            return;
        }

        System.out.println("Результат:");
        System.out.println(text);
    }

    // Метод для чтения текста из файла
    private static String readFile(String filename) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
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

    // Метод для удаления указанного символа в тексте
    private static String removeSymbol(String text, char symbol) {
        return text.replaceAll(String.valueOf(symbol), "");
    }

    // Метод для вставки символа после k-го символа в каждой строке текста
    private static String insertSymbolAfterK(String text, int k, char symbol) {
        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            StringBuilder modifiedLine = new StringBuilder();
            int count = 0;
            for (char c : line.toCharArray()) {
                modifiedLine.append(c);
                if (++count == k) {
                    modifiedLine.append(symbol);
                }
            }
            result.append(modifiedLine.toString()).append("\n");
        }
        return result.toString();
    }
}
