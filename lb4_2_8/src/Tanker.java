public class Tanker extends CargoShip {
    private int liters; // Объем груза корабля

    Tanker(String name, int liters){
        super(name);
        this.liters = liters;
    }

    @Override
    public void goods() {
        System.out.println("Танкер перевозит жидкие грузы с максимальным объемом в " + liters + " литров");
    }
}
