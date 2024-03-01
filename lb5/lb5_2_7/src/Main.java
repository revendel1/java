import java.util.Scanner;
import java.time.LocalTime;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите количество абонентов: ");
            int k = in.nextInt();

            Phone[] phones = new Phone[k];
            for (int i = 0; i < k; ++i) {
                System.out.print("Введите номер абонента " + (i + 1) + ": ");
                int number = in.nextInt();
                if (number == 666)
                    throw new InvalidPhoneException("Невалидный номер");
                in.nextLine();
                System.out.print("Введите фамилию абонента " + (i + 1) + ": ");
                String surname1 = in.nextLine();
                if (surname1.equals("rrr"))
                        throw new InvalidPhoneException("Невалидная фамилия");
                System.out.print("Введите имя абонента " + (i + 1) + ": ");
                String name = in.nextLine();
                System.out.print("Введите отчество абонента " + (i + 1) + ": ");
                String patronymic = in.nextLine();
                System.out.print("Введите адрес абонента " + (i + 1) + ": ");
                String address = in.nextLine();

                System.out.print("Введите дебет абонента " + (i + 1) + ": ");
                double debit = in.nextDouble();
                System.out.print("Введите кредит абонента " + (i + 1) + ": ");
                double credit = in.nextDouble();
                in.nextLine();
                System.out.print("Введите внутригородское время абонента в формате HH:MM:DD" + (i + 1) + ": ");
                String time = in.nextLine();
                LocalTime time1 = LocalTime.parse(time);
                System.out.print("Введите междугороднее время абонента в формате HH:MM:DD" + (i + 1) + ": ");
                time = in.nextLine();
                LocalTime time2 = LocalTime.parse(time);
                phones[i] = new Phone(i+1, surname1, name, patronymic, address, number, debit, credit, time1, time2);
            }
            System.out.println();

            System.out.println("Введенные значения: ");
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
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Вы умудрились исчерпать оперативку. Поздравляем!");
        } catch (InvalidPhoneException e) {
            System.out.println("InvalidPhoneException " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}