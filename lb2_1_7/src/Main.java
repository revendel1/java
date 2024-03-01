import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество слов: ");
        int n = in.nextInt();
        in.nextLine();

        String uniqueWord = null;

        System.out.println("Введите слова:");
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }

        for (int i = 0; i < n; i++) {
            if (isUnique(words[i])) {
                uniqueWord = words[i];
                break;
            }
        }
        if (uniqueWord != null) {
            System.out.println("Уникальное слово: " + uniqueWord);
        } else {
            System.out.println("Уникальных слов не найдено.");
        }

        in.close();
    }

    // Метод, проверяющий состоит ли слово из уникальных символов
    private static boolean isUnique(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}