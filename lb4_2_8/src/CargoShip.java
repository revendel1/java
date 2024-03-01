public class CargoShip implements Ship {
    private String name; //Имя корабля

    CargoShip(String name){
        this.name = name;
    }

    public String getName() { return name; }

    public void ship_name(){
        System.out.println("Корабль носит гордое имя " + getName());
    }

    public void goods(){
        System.out.println("Корабль перевозит грузы");
    }
}
