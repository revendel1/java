import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Разделяем числа на четные и нечетные с использованием partitioningBy
        Map<Boolean, List<Integer>> evenAndOddNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        // Выводим результат
        System.out.println("Четные числа: " + evenAndOddNumbers.get(true));
        System.out.println("Нечетные числа: " + evenAndOddNumbers.get(false));
    }
}
