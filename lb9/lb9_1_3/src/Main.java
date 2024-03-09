import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfOddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0) // Отфильтровываем нечетные числа
                .mapToInt(Integer::intValue) // Преобразуем Integer в int
                .sum(); // Вычисляем сумму

        System.out.println("Сумма нечетных чисел: " + sumOfOddNumbers);
    }
}
