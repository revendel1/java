import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        int num1 = in.nextInt();
        System.out.print("Input second number: ");
        int num2 = in.nextInt();

        System.out.printf("Sum: %d \n", num1 + num2 );
        System.out.printf("Sum: %d \n", num1 * num2 );
        in.close();
    }
}