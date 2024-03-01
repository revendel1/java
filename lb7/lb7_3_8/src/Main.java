import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = in.nextLine();

        String decryptedText = decryptText(text);
        System.out.println("Дешифрованный текст: " + decryptedText);
    }

    private static String decryptText(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();

        // Определяем длину каждой из трех последовательностей символов
        int n = encryptedText.length();
        int size1 = (int) Math.ceil(n / 3.0);
        int size2 = (int) Math.ceil(n / 3.0);
        if (n % 3 == 1){
            size2--;
        }

        // Разбиваем исходную строку на последовательности символов
        String substring1 = encryptedText.substring(0, size1);
        String substring2 = encryptedText.substring(size1, size1 + size2);
        String substring3 = encryptedText.substring(size1 + size2, n);

        // Формируем дешифрованную строку из подстрок
        int g = Math.min(size1, size2);
        g = Math.min(g, n - size1 - size2);
        for (int i = 0; i < g; i++) {
            decryptedText.append(substring1.charAt(i));
            decryptedText.append(substring2.charAt(i));
            decryptedText.append(substring3.charAt(i));
        }

        // Добавляем 1-2 оставшихся символа, не учтенных в предыдущем шаге
        if (n % 3 == 1){
            decryptedText.append(substring1.charAt(size1 - 1));
        } else if (n % 3 == 2) {
            decryptedText.append(substring1.charAt(size1 - 1));
            decryptedText.append(substring2.charAt(size2 - 1));
        }

        return decryptedText.toString();
    }
}