import java.util.List;

public class Automobile {
    private final int id; // id автомобиля
    private final String title; // марка автомобиля
    private boolean need_repair; // нуждается ли автомобиль в ремонте
    private boolean in_trip; // находится ли сейчас в рейсе
    private List<Driver> drivers; // список водителей, управляющих автомобилем

    Automobile(int id, String title) {
        this.id = id;
        this.title = title;
        this.need_repair = false;
        this.in_trip = false;
        this.drivers = null;
    }
    Automobile(int id, String title, List<Driver> drivers) {
        this.id = id;
        this.title = title;
        this.need_repair = false;
        this.in_trip = false;
        this.drivers = drivers;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setNeed_repair(boolean need_repair) { this.need_repair = need_repair; }
    public boolean isIn_trip() { return in_trip; }
    public void setIn_trip(boolean in_trip) { this.in_trip = in_trip; }
    public List<Driver> getDrivers() { return drivers; }
    public void setDrivers(List<Driver> drivers) { this.drivers = drivers; }

    @Override
    public String toString() {
        return "Automobile{ " +
                "id= " + id +
                ", title= '" + title + '\'' +
                ", need_repair= " + need_repair +
                ", in_trip= " + in_trip +
                ", drivers= " + drivers +
                " }";
    }
}
