import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATHS_FILE = "params.txt";
    public static String input_path;
    public static String output_path;

    public static void main(String[] args) {
        try {
            readPaths();
            readFileAndProcess();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPaths() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите 0 для чтения из файла и любое другое число для ввода собственных путей: ");
        int num = in.nextInt();
        if (num != 0) {
            System.out.print("Введите путь файла ввода: ");
            input_path = in.nextLine();
            System.out.println("Введите путь файла вывода: ");
            output_path = in.nextLine();
        } else {
            try (FileReader fr = new FileReader(PATHS_FILE)) {
                BufferedReader reader = new BufferedReader(fr);
                input_path = reader.readLine();
                output_path = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        }
        in.close();
    }

    private static void readFileAndProcess() throws IOException {
        Map<Character, Integer> letterFrequency = new HashMap<>();
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input_path));

            String line;
            while ((line = reader.readLine()) != null) {
                for (char letter : line.toCharArray()) {
                    if (Character.isLetter(letter)) {
                        letter = Character.toLowerCase(letter);
                        letterFrequency.put(letter, letterFrequency.getOrDefault(letter, 0) + 1);
                    }
                }

                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            FileWriter writer = new FileWriter(output_path, false);
            writer.write("Частота букв:\n");
            for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
                writer.write("Буква '" + entry.getKey() + "': " + entry.getValue() + " раз");
                writer.append('\n');
            }
            writer.write("\nЧастота слов:\n");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.write("Слово '" + entry.getKey() + "': " + entry.getValue() + " раз");
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}