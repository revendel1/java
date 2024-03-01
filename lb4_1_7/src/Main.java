import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Help_desk help_desk = new Help_desk();

        help_desk.addRoute(LocalTime.parse("03:13:23"), "Москва", "Одесса", 12.23);
        help_desk.addRoute(LocalTime.parse("05:12:53"), "Москва", "Воронеж", 2.45);
        help_desk.addRoute(LocalTime.parse("01:43:17"), "Казань", "Самара", 4.17);

        help_desk.printRoutes();
    }
}