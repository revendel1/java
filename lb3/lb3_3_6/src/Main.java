public class Main {
    public static void main(String[] args) {
        Rose rose = new Rose(3);
        System.out.println("Роза: " + rose);
        System.out.println();

        // Роза цветет
        rose.blossomed();
        System.out.println("Роза расцвела: " + rose);
        System.out.println();

        // Роза завяла
        rose.withered();
        System.out.println("Роза завяла: " + rose);
        System.out.println();

        // Какого цвета роза
        String color = rose.getColor();
        System.out.println("Цвет: " + color);
    }
}