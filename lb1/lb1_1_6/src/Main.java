import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Фамилия разработчика: Тихомиров");

        Calendar c1 = new GregorianCalendar(2024, 2, 10, 13, 50); // Дата получения задания
        Calendar c2 = new GregorianCalendar(); // Текущая дата (дата сдачи задания)

        System.out.println("Дата получения задания: " + c1.getTime());
        System.out.println("Дата сдачи задания: " + c2.getTime());
    }
}