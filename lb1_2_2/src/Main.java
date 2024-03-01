import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество чисел: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите числа: ");
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            } else if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Наименьшее число: " + min);
        System.out.println("Наибольшее число: " + max);
    }
}