import java.io.*;
import java.util.Scanner;

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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input_path));
            FileWriter writer = new FileWriter(output_path, false);
            String s;
            while((s=reader.readLine())!=null){
                writer.write(process(s));
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String process(String str){
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                result.append(firstChar).append(word.substring(1)).append(" ");
            } else {
                result.append(" ");
            }
        }
        return result.toString();
    }
}