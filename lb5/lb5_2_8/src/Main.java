import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите количество машин: ");
            int k = in.nextInt();
            in.nextLine();

            Car[] cars = new Car[k];
            for (int i = 0; i < k; ++i) {
                System.out.print("Введите марку машины " + (i + 1) + ": ");
                String brand = in.nextLine();
                if (brand.equals("rrr"))
                    throw new InvalidCarException("Невалидная марка");
                System.out.print("Введите модель машины " + (i + 1) + ": ");
                String model = in.nextLine();
                System.out.print("Введите год выпуска" + (i + 1) + ": ");
                int year = in.nextInt();
                in.nextLine();
                if (year < 1896 || year > 2024)
                    throw new InvalidCarException("Невалидный год");
                System.out.print("Введите цвет автомобиля" + (i + 1) + ": ");
                String color = in.nextLine();
                System.out.print("Введите цену автомобиля " + (i + 1) + ": ");
                double cost = in.nextDouble();
                System.out.print("Введите номер автомобиля" + (i + 1) + ": ");
                int number = in.nextInt();
                cars[i] = new Car(i+1, brand, model, year, color, cost, number);
            }
            System.out.println();

            System.out.println("Введенные значения");
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
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Вы умудрились исчерпать оперативку. Поздравляем!");
        } catch (InvalidCarException e) {
            System.out.println("InvalidPhoneException " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    public static class InvalidCarException extends Exception {
        public InvalidCarException(String mess) {
            super(mess);
        }
    }
}