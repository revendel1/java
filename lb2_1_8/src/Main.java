import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество слов: ");
        int n = in.nextInt();
        in.nextLine();

        System.out.println("Введите слова:");
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }

        ArrayList<String> need_words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isNumber(words[i]) && isPalindrom(words[i])) {
                need_words.add(words[i]);
            }
        }
        if (need_words.size() > 1) {
            System.out.println("Нужное слово: " + need_words.get(1));
        } else if (need_words.size() > 0) {
            System.out.println("Нужное слово: " + need_words.get(0));
        } else {
            System.out.println("Нужных слов не найдено.");
        }

        in.close();
    }

    // Метод, проверяющий состоит ли слово только из цифр
    private static boolean isNumber(String word) {
        return word.matches("-?\\d+");
    }

    // Метод, проверяющий является ли слово палиндромом
    private static boolean isPalindrom(String word) {
        for (int i = 0; i < word.length() / 2 - 1; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}