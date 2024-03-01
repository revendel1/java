import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String text = readFile();
        if (text == null) {
            System.out.println("Ошибка при чтении файла.");
            return;
        }

        String encryptedText = encryptText(text.replaceAll("\\n", ""));
        System.out.println("Зашифрованный текст: " + encryptedText);
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

    // Метод шифрования
    private static String encryptText(String text) {
        StringBuilder encryptedText = new StringBuilder();
        int n = text.length();

        for (int i = 0; i < n; i += 3) {
            encryptedText.append(text.charAt(i));
        }
        for (int i = 1; i < n; i += 3) {
            encryptedText.append(text.charAt(i));
        }
        for (int i = 2; i < n; i += 3) {
            encryptedText.append(text.charAt(i));
        }
        return encryptedText.toString();
    }
}