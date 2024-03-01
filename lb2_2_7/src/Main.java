import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = in.nextInt();
        in.nextLine();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(n * (-1), n + 1);
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix, n);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Матрица, повернутая на " + 90 * i + "градусов:");
            matrix = rotateMatrix(matrix, n);
        }
        in.close();
    }

    // Метод, поворачивающий матрицу на 90* против часовой
    private static int[][] rotateMatrix(int matrix[][], int n) {
        int[][] new_matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_matrix[n - j - 1][i] = matrix[i][j];
            }
        }
        printMatrix(new_matrix, n);
        return new_matrix;
    }

    // Метод, выводящий матрицу в консоль
    private static void printMatrix(int matrix[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= 0) {
                    System.out.print(" " + matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}