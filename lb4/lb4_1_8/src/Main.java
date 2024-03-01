public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.addResource(1, "Операционная система");
        computer.addResource(7,"Процессор");
        computer.addResource(8, "Оперативная память");

        computer.printResources();
    }
}