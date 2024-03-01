import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите количество дробей: ");
            int k = in.nextInt();

            Fraction[] arr = new Fraction[k];
            for (int i = 0; i < k; ++i) {
                System.out.print("Введите числитель дроби " + (i + 1) + ": ");
                int m = in.nextInt();
                System.out.print("Введите знаменатель дроби " + (i + 1) + ": ");
                int n = in.nextInt();
                if (n == 0)
                   throw new NilDenominatorException("Знаменатель не может быть равен нулю");
                arr[i] = new Fraction(m, n);
            }
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
        } catch (NilDenominatorException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Вы умудрились исчерпать оперативку. Поздравляем!");
        }
    }

    public static void fold_fractions(Fraction[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            arr[i].plus(arr[i+1]);
        }
    }

    public static class NilDenominatorException extends Exception {
        public NilDenominatorException(String mess){
            super(mess);
        }
    }
}