import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ab", "cd", "ef", "gh");

        // Преобразуем коллекцию строк в Map
        Map<Character, Character> map = strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0), // ключ - первый символ строки
                        s -> s.charAt(1) // значение - второй символ строки
                ));

        // Выводим результат
        System.out.println(map);
    }
}
