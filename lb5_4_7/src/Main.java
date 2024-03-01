//*******************************************************************************
// Результат работы программы(читаемый код) расположен в файле output/output.java
//*******************************************************************************
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
                        String currentDir  =   System.getProperty("user.dir"); // Получение текущего рабочего каталога
                String       newDirectoryName  =    "output";
        Path             newDirectoryPath       =          Paths.get(currentDir, newDirectoryName);
        try         {
            Files.createDirectory(newDirectoryPath); // Создание новой директории в текущем рабочем каталоге
                System.out.println("Директория '" + newDirectoryName + "' создана в рабочем каталоге.");
        }            catch          (IOException e) {
            System.err.println("Не удалось создать директорию: " +          e.getMessage());
        }

            String newFileName   =   "output.java";
                Path             newFilePath     =   newDirectoryPath.resolve(newFileName);
        try {
                    Files.createFile(newFilePath); // Создание нового файла в созданной директории
            System.out.println("Файл '"    +  newFileName +   "' создан в директории '" + newDirectoryName + "'.");
        }           catch (IOException e) {
                    System.err.println("Не удалось создать файл: " + e.getMessage());
        }

        String                                               inputFileName = "src/Main.java";
                    String                           bufferFileName = "buffer.java";
            String outputFileName =         "output/output.java";
        try (BufferedReader         reader              = new BufferedReader(new FileReader(inputFileName));
        PrintWriter         writer = new PrintWriter(new FileWriter(bufferFileName))) {
                        String          line;
                 while       ((line =       reader.readLine()) != null) {
                // Удаление лишних пробелов и табуляций c помощью регулярного выражения
                     // ищущего последовательность пробелов
                        line             = line.replaceAll("\\s+", " ");
                    writer.println(line);
            }
                 }                               catch (IOException e) {
                                                                                e.printStackTrace();
        }

              try                       (BufferedReader reader = new BufferedReader(new FileReader(bufferFileName));
              FileWriter    writer = new FileWriter(outputFileName)) {
                String               line;
      int                    indentationLevel = 0; // количество отступов
        while               ((line = reader.readLine()) != null) {
                 if (line.startsWith(" }") && line.endsWith("{")) {
             // если в строке есть обе скобки, то эту строку мы сдвигаем назад
                    // а следующую сдвигаем вперед
                              indentationLevel = Math.max(0, indentationLevel - 1);
           writer.write(getIndentation(indentationLevel));
   writer.write(line + '\n');
                                 indentationLevel++;
                                                         } else if (line.endsWith("{")) {
        // если строка заканчивается открывающей скобкой,
                           // то все следующие строки сдвинуты на один вправо
                    writer.write(getIndentation(indentationLevel));
                               writer.write(line + '\n');
           indentationLevel++;
                } else          if (line.contains("}")) {
        // если строка имеет закрывающую скобку
                    // то сдвигаем строки на один влево
                              indentationLevel =            Math.max(0, indentationLevel - 1);
                    writer.write(getIndentation(indentationLevel));
                                        writer.write(line+ '\n');
       } else                                    {
                           writer.write(getIndentation(indentationLevel));
                    writer.write(line+ '\n');
                                 }
            }
    (new                            File(bufferFileName)).delete();
                  } catch       (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод, добавляющий отступы к строке
                    private static String getIndentation(int level) {
     StringBuilder indentation = new StringBuilder();
                     for (int i = 0; i < level; i++) {
                   indentation.append("\t");
        }
                return indentation.toString();
    }
}