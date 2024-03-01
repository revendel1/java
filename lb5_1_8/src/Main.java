import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите размерность векторов: ");
            int n = in.nextInt();

            Complex[] vector1 = new Complex[n];
            Complex[] vector2 = new Complex[n];
            System.out.println("Инициализация первого вектора");
            for (int i = 0; i < n; ++i) {
                System.out.print("Введите действительную часть числа " + (i + 1) + ": ");
                int a = in.nextInt();
                System.out.print("        Введите мнимую часть числа " + (i + 1) + ": ");
                int b = in.nextInt();
                vector1[i] = new Complex(a, b);
            }
            System.out.println();
            System.out.println("Инициализация второго вектора");
            for (int i = 0; i < n; ++i) {
                System.out.print("Введите действительную часть числа " + (i + 1) + ": ");
                int a = in.nextInt();
                System.out.print("        Введите мнимую часть числа " + (i + 1) + ": ");
                int b = in.nextInt();
                vector2[i] = new Complex(a, b);
            }
            System.out.println();

            System.out.println("Исходные вектора: ");
            print(vector1);
            print(vector2);

            fold_vectors(vector1, vector2);
            System.out.println("Результат сложения: ");
            print(vector1);
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch(OutOfMemoryError e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }

    private static void fold_vectors(Complex[] vector1, Complex[] vector2) {
        for (int i = 0; i < vector1.length; ++i) {
            vector1[i].plus(vector2[i]);
        }
    }

    private static void print(Complex[] vector1) {
        for (int i = 0; i < vector1.length; ++i) {
            System.out.print(vector1[i].a + " + " + vector1[i].b + "i, ");
        }
        System.out.println();
    }
}