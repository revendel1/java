public class Main {
    public static void main(String[] args) {
        CargoShip cargoship = new CargoShip("Flown");
        cargoship.ship_name();
        cargoship.goods();

        System.out.println();

        Tanker tanker = new Tanker("Bold", 1000);
        tanker.ship_name();
        tanker.goods();
    }
}