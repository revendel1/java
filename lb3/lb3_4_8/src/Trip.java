public class Trip {
    private final int id; // id рейса
    private final String start; // пункт начала рейса
    private final String end; // конечная рейса
    private Automobile automobile; // автомобиль на рейсе

    Trip(int id, String start, String end){
        this.id = id;
        this.start = start;
        this.end = end;
        this.automobile = null;
    }

    public int getId() { return id; }
    public String getStart() { return start; }
    public String getEnd() { return end; }
    public Automobile getAutomobile() { return automobile; }
    public void setAutomobile(Automobile automobile) { this.automobile = automobile; }

    @Override
    public String toString() {
        return "Trip{ " +
                "id= " + id +
                ", start= '" + start + '\'' +
                ", end= '" + end + '\'' +
                ", automobile= " + automobile +
                " }";
    }
}
