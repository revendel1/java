import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = Phone.generatePhones(5);
        System.out.println("Сгенерированные значения");
        for(Phone phone : phones) {
            System.out.println(phone);
        }
        System.out.println();

        System.out.println("Абоненты с превышением времени:");
        Phone[] overflow_phones = Phone.searchByTimeInCity(phones, LocalTime.parse("12:00:00"));
        for(Phone phone : overflow_phones) {
            System.out.println(phone);
        }
        System.out.println();

        System.out.println("Абоненты звонившие на межгород:");
        Phone[] between_cities_phones = Phone.wasTimeBetween(phones);
        for(Phone phone : between_cities_phones) {
            System.out.println(phone);
        }
        System.out.println();

        System.out.println("Отсортированные абоненты:");
        Phone[] sorted_phones = Phone.sortByFio(phones);
        for(Phone phone : sorted_phones) {
            System.out.println(phone);
        }
    }
}