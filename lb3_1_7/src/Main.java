import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество дробей: ");
        int k = in.nextInt();

        Fraction[] arr = new Fraction[k];
        for (int i = 0; i < k; ++i) {
            System.out.print("Введите числитель дроби " + (i+1) + ": ");
            int m = in.nextInt();
            System.out.print("Введите знаменатель дроби " + (i+1) + ": ");
            int n = in.nextInt();
            arr[i] = new Fraction(m, n);
        }
        in.close();
        System.out.println();

        System.out.println("Исходные дроби: ");
        for (int i = 0; i < k; ++i) {
            System.out.print(arr[i].m + "/" + arr[i].n + " ");
        }
        System.out.println();

        fold_fractions(arr);
        System.out.println("Измененные дроби: ");
        for (int i = 0; i < k; ++i) {
            System.out.print(arr[i].m + "/" + arr[i].n + " ");
        }
    }

    // Сложение дробей в массиве по четным индексам со следующим элементом
    private static void fold_fractions(Fraction arr[]) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            arr[i].plus(arr[i+1]);
        }
    }
}