import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir"); // Получение текущего рабочего каталога
        String newDirectoryName = "output"; // Создание новой директории в текущем рабочем каталоге
        Path newDirectoryPath = Paths.get(currentDir, newDirectoryName);
        try {
            Files.createDirectory(newDirectoryPath);
            System.out.println("Директория '" + newDirectoryName + "' создана в рабочем каталоге.");
        } catch (IOException e) {
            System.err.println("Не удалось создать директорию: " + e.getMessage());
        }

        String newFileName = "output.java"; // Создание нового файла в созданной директории
        Path newFilePath = newDirectoryPath.resolve(newFileName);
        try {
            Files.createFile(newFilePath);
            System.out.println("Файл '" + newFileName + "' создан в директории '" + newDirectoryName + "'.");
        } catch (IOException e) {
            System.err.println("Не удалось создать файл: " + e.getMessage());
        }

        /* String newFileName = "output.java"; */
        /* Path newFilePath = newDirectoryPath.resolve(newFileName);
        try {
            Files.createFile(newFilePath);
            System.out.println("Файл '" + newFileName + "' создан в директории '" + newDirectoryName + "'.");
        } catch (IOException e) {
            System.err.println("Не удалось создать файл: " + e.getMessage());
        } */

        String inputFileName = "src/Main.java";
        String bufferFileName = "buffer.java";
        String outputFileName = "output/output.java";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter writer = new PrintWriter(new FileWriter(bufferFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Удаление комментариев
                String lineWithoutComments = removeComments(line);
                writer.println(lineWithoutComments);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(bufferFileName);
             FileWriter writer = new FileWriter(outputFileName)) {

            boolean insideComment = false;
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                if (!insideComment) {
                    if (currentChar == '/') {
                        int nextChar = reader.read();
                        if (nextChar == '*') {
                            insideComment = true;
                        } else {
                            writer.write(currentChar);
                            if (nextChar != -1) {
                                writer.write(nextChar);
                            }
                        }
                    } else {
                        writer.write(currentChar);
                    }
                } else {
                    if (currentChar == '*') {
                        int nextChar = reader.read();
                        if (nextChar == '/') {
                            insideComment = false;
                        }
                    }
                }
            }
            (new File(bufferFileName)).delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeComments(String line) {
        // Регулярное выражение для удаления всех видов комментариев
        String regex = "(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll("");
    }
}