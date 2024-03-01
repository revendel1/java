public class Main {
    public static void main(String[] args) {
        Car[] cars = Car.generateCars(10);
        System.out.println("Сгенерированные значения");
        for(Car car : cars) {
            System.out.println(car);
        }
        System.out.println();

        System.out.println("Машины заданной марки BMW:");
        Car[] brand_cars = Car.searchByBrand(cars, "BMW");
        for(Car car : brand_cars) {
            System.out.println(car);
        }
        System.out.println();

        System.out.println("Машины Model 1 со сроком больше 22:");
        Car[] old_cars = Car.searchByModelAndYear(cars, "Model 1", 22);
        for(Car car : old_cars) {
            System.out.println(car);
        }
        System.out.println();

        System.out.println("Машины 2001 года выпуска с ценой больше 5:");
        Car[] cost_cars = Car.searchByCost(cars, 2001, 5);
        for(Car car : cost_cars) {
            System.out.println(car);
        }
    }
}