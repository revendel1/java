import java.util.Scanner;
import java.util.ArrayList;

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

        // Используем динамические массивы, так как кол-во чисел неизвестно
        ArrayList<Integer> nums_3 = new ArrayList<>();
        ArrayList<Integer> nums_9 = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if(arr[i] % 3 == 0){
                nums_3.add(arr[i]);
                if(arr[i] % 9 == 0) {
                    nums_9.add(arr[i]);
                }
            }
        }

        if (nums_3.size() > 0) {
            System.out.print("Числа делящиеся на 3: ");
            for (int i = 0; i < nums_3.size(); i++){
                System.out.print(nums_3.get(i) + " ");
            }
            System.out.println();
            if (nums_9.size() > 0) {
                System.out.print("Числа делящиеся на 9: ");
                for (int i = 0; i < nums_9.size(); i++) {
                    System.out.print(nums_9.get(i) + " ");
                }
            } else {
                System.out.println("Нет чисел которые делились бы на 9");
            }
        } else {
            System.out.println("Нет чисел которые делились бы на 3 или 9");
        }
    }
}