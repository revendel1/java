import java.util.List;

public class Driver {
    private final int id; // id водителя
    private final String name; // имя водителя
    private boolean can_work; // может ли он работать
    private boolean in_trip; // находится ли сейчас в рейсе

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
        this.can_work = true;
        this.in_trip = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isCan_work() { return can_work; }
    public void setCan_work(boolean can_work) { this.can_work = can_work; }
    public boolean isIn_trip() { return in_trip; }
    public void setIn_trip(boolean in_trip) { this.in_trip = in_trip; }

    // Водитель может оставить заявку на ремонт автомобиля
    public void ask_for_repair(Automobile automobile) {
        automobile.setNeed_repair(true);
        System.out.println("Водитель " + id + ": " + name + " оставил заявку на ремонт автомобиля " + automobile.getId() + ": " + automobile.getTitle());
    }

    // Водитель может завершить рейс
    public void finish_trip(Trip trip) {
        System.out.println("Рейс " + trip.getId() + ": " + trip.getStart() + "-" + trip.getEnd() + " успешно завершен");
        Automobile automobile = trip.getAutomobile();
        automobile.setIn_trip(false);
        System.out.println("Автомобиль " + automobile.getId() + ": " + automobile.getTitle() + " свободен для других рейсов");
        List<Driver> drivers = automobile.getDrivers();
        for(Driver driver : drivers) {
            System.out.println("Водитель " + driver.getId() + ": " + driver.getName() + " свободен для других рейсов");
            driver.setIn_trip(false);
        }
        automobile.setDrivers(null);
        trip.setAutomobile(null);
    }

    @Override
    public String toString() {
        return "Driver{ " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", can_work= " + can_work +
                ", in_trip= " + in_trip +
                " }";
    }
}
