class Service {
    private final int id; // id услуги
    private final String title; // Название услуги
    private final double cost; // Цена за услугу

    public Service(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public double getCost() { return cost; }

    public String toString() { return "Service{ " + "id= " + id + ", title='" + title + "', cost='" + cost + '}'; }
}