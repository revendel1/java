import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Инициализация сущностей
        Driver driver1 = new Driver(1, "Михалыч");
        Driver driver2 = new Driver(2, "Петрович");
        Driver driver3 = new Driver(3, "Иваныч");
        List<Driver> drivers = new ArrayList<Driver>(){{
            add(driver1);
            add(driver2);
            add(driver3);
        }};
        Automobile automobile1 = new Automobile(1, "BMW");
        Automobile automobile2 = new Automobile(2, "Ford");
        List<Automobile> automobiles = new ArrayList<Automobile>(){{
           add(automobile1);
           add(automobile2);
        }};
        Dispatcher dispatcher = new Dispatcher(1, "Dispatcher");
        List<Dispatcher> dispatchers = new ArrayList<Dispatcher>(){{add(dispatcher);}};
        Trip trip1 = new Trip(1, "Москва", "Минск");
        List<Trip> trips = new ArrayList<Trip>(){{add(trip1);}};
        Autobase autobase = new Autobase(1, "Автобаза", automobiles, drivers, dispatchers, trips);
        System.out.println(autobase);

        // Диспетчер получает списки доступных водителей и автомобилей и начинает рейс
        List<Driver> available_drivers = dispatcher.get_available_drivers(autobase);
        List<Automobile> available_automobiles = dispatcher.get_available_automobiles(autobase);
        dispatcher.start_trip(trip1, available_automobiles.get(0), new ArrayList<Driver>(){{add(available_drivers.get(0)); add(available_drivers.get(1));}});
        System.out.println(autobase.getTrips().get(0));

        // Поступает заявка на новый рейс
        System.out.println();
        autobase.add_trip(new Trip(2, "Минск", "Варшава"));
        System.out.println(autobase);

        // Водитель оставляет заявку на ремонт автомобиля
        System.out.println();
        System.out.println(automobile2);
        driver3.ask_for_repair(automobile2);
        System.out.println(automobile2);

        // Диспетчер отстраняет водителя от работы
        System.out.println();
        System.out.println(driver3);
        dispatcher.block_driver(driver3);
        System.out.println(driver3);

        // Водитель завершает рейс
        System.out.println();
        driver2.finish_trip(trip1);
        System.out.println(trip1);
        System.out.println(automobile1);
        System.out.println(driver1);
        System.out.println(driver2);
    }
}