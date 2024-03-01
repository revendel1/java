import java.util.List;

public class Autobase {
    private final int id; // id автобазы
    private final String name; // название автобазы
    private List<Automobile> automobiles; // список автомобилей
    private List<Driver> drivers; // список водителей
    private List<Dispatcher> dispatchers; // список диспетчеров
    private List<Trip> trips; // список рейсов

    Autobase(int id, String name, List<Automobile> automobiles, List<Driver> drivers, List<Dispatcher> dispatchers, List<Trip> trips) {
        this.id = id;
        this.name = name;
        this.dispatchers = dispatchers;
        this.drivers = drivers;
        this.automobiles = automobiles;
        this.trips = trips;
    }

    public List<Automobile> getAutomobiles() { return automobiles; }
    public List<Driver> getDrivers() { return drivers; }
    public List<Trip> getTrips() { return trips; }

    // Добавление нового рейса
    public void add_trip(Trip trip) {
        trips.add(trip);
        System.out.println("Поступила новая заявка на рейс " + trip.getStart() + "-" + trip.getEnd());
    }

    @Override
    public String toString() {
        return "Autobase{ " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", automobiles= " + automobiles +
                ", drivers= " + drivers +
                ", dispatchers= " + dispatchers +
                ", trips= " + trips +
                " }";
    }
}
