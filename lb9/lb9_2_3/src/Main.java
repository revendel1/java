import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Maria", 42),
                new People("Ivan", 16),
                new People("Petr", 23)
        );

        // Сортируем коллекцию по возрасту
        List<People> sortedByAge = peoples.stream()
                .sorted(Comparator.comparingInt(People::getAge))
                .collect(Collectors.toList());

        // Выводим отсортированный список
        sortedByAge.forEach(System.out::println);
    }

    static class People {
        private final String name;
        private final int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
