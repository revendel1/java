import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Help_desk {
    private List<Route> routes; // Список маршрутов

    Help_desk(){
        routes = new ArrayList<>();
    }

    // Добавить маршрут
    public void addRoute(LocalTime time, String start_point, String end_point, double cost) {
        Route route = new Route(time, start_point, end_point, cost);
        routes.add(route);
    }

    public void printRoutes() {
        System.out.println("Информация о маршрутах");
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    // Внутренний класс для хранения маршрутов
    private class Route {
        private LocalTime time; // Время в пути
        private String start_point; // Пункт начала
        private String end_point; // Конечная
        private double cost; // Цена за проезд

        Route(LocalTime time, String start_point, String end_point, double cost) {
            this.time = time;
            this.start_point = start_point;
            this.end_point = end_point;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Маршрут{ " +
                    "время=" + time +
                    ", начало='" + start_point + '\'' +
                    ", конечная='" + end_point + '\'' +
                    ", цена=" + cost +
                    " }";
        }
    }
}
