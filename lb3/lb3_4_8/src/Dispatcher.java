import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private final int id; // id диспетчера
    private final String name; // имя диспетчера

    Dispatcher(int id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Driver> get_available_drivers(Autobase autobase) {
        List<Driver> available_drivers = new ArrayList<>();
        for(Driver driver : autobase.getDrivers()){
            if (!driver.isIn_trip() && driver.isCan_work()){
                available_drivers.add(driver);
            }
        }
        return available_drivers;
    }

    public List<Automobile> get_available_automobiles(Autobase autobase) {
        List<Automobile> available_automobiles = new ArrayList<>();
        for(Automobile automobile : autobase.getAutomobiles()){
            if (!automobile.isIn_trip()){
                available_automobiles.add(automobile);
            }
        }
        return available_automobiles;
    }

    public void start_trip(Trip trip, Automobile automobile, List<Driver> drivers){
        trip.setAutomobile(automobile);
        automobile.setIn_trip(true);
        automobile.setDrivers(drivers);
        System.out.println("Автомобиль " + automobile.getId() + ": " + automobile.getTitle() + " начал рейс");
        for(Driver driver : drivers) {
            System.out.println("Водитель " + driver.getId() + ": " + driver.getName() + " начал рейс");
            driver.setIn_trip(true);
        }
        System.out.println("Рейс " + trip.getId() + ": " + trip.getStart() + "-" + trip.getEnd() + " успешно начат");
    }

    public void block_driver(Driver driver) {
        driver.setCan_work(false);
        System.out.println("Диспетчер " + id + ": " + name + " отстранил от работы водителя " + driver.getId() + ": " + driver.getName());
    }

    @Override
    public String toString() {
        return "Dispatcher{ " +
                "id=" + id +
                ", name= '" + name + '\'' +
                " }";
    }
}
