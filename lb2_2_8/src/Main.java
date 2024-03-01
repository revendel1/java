import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = in.nextInt();
        in.nextLine();
        in.close();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(n * (-1), n + 1);
            }
        }

        System.out.println("Исходная матрица:");
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

        System.out.println("Определитель матрицы: " + determinator(matrix));
    }

    // Метод вычисляет определитель матрицы, используя рекурсию
    private static int determinator(int matrix[][]) {
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int res = 0;
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                int[][] new_matrix = new int[n - 1][n - 1];
                for (int k = 1; k < n; k++) {
                    int colIndex = 0;
                    for (int l = 0; l < n; l++) {
                        if (l != i) {
                            new_matrix[k - 1][colIndex] = matrix[k][l];
                            colIndex++;
                        }
                    }
                }
                if (i % 2 == 0) {
                    res += matrix[0][i] * determinator(new_matrix);
                } else {
                    res -= matrix[0][i] * determinator(new_matrix);
                }
            }
            return res;
        }
    }
}