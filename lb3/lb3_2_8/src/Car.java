import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    private int id; // Идентификатор
    private String brand; // Марка
    private String model; // Модель
    private int year; // Год выпуска
    private String color; // Цвет
    private double cost; // Цена
    private int number; // Регистрационный номер

    // Конструктор
    public Car(int id, String brand, String model, int year, String color, double cost, int number) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.cost = cost;
        this.number = number;
    }

    // Методы доступа к данным
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return this.cost;
    }
    public void setCost(double cost) { this.cost = cost; }

    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "Car{id=" + this.id + ", brand='" + this.brand + "', model=" + this.model + ", year='" + this.year + "', color=" + this.color + "', cost=" + this.cost + ", number=" + this.number + "'}";
    }

    // Поиск автомобилей заданной марки
    public static Car[] searchByBrand(Car[] cars, String brand) {
        ArrayList<Car> result = new ArrayList<Car>();

        for (Car car : cars) {
            if (car.getBrand().compareTo(brand) == 0) {
                result.add(car);
            }
        }

        return (Car[])result.toArray(new Car[result.size()]);
    }

    // Поиск автомобилей заданной модели, которые эксплуатируются больше year лет
    public static Car[] searchByModelAndYear(Car[] cars, String model, int year) {
        ArrayList<Car> result = new ArrayList<Car>();

        for (Car car : cars) {
            if (car.getModel().compareTo(model) == 0 && car.getYear() < 2024 - year) {
                result.add(car);
            }
        }

        return (Car[])result.toArray(new Car[result.size()]);
    }

    // Список автомобилей заданного года с превышением цены
    public static Car[] searchByCost(Car[] cars, int year, double cost) {
        ArrayList<Car> result = new ArrayList<Car>();

        for (Car car : cars) {
            if (car.getYear() == year && car.getCost() > cost) {
                result.add(car);
            }
        }

        return (Car[])result.toArray(new Car[result.size()]);
    }

    public static Car[] generateCars(int count) {
        Car[] cars = new Car[count];
        String[] brands = new String[]{"Tesla", "BMW", "Ford"};
        String[] models = new String[]{"Model 1", "Model 2"};
        String[] colors = new String[]{"Синий", "Красный", "Желтый", "Зеленый"};

        for (int i = 0; i < count; ++i) {
            String brand = brands[(int) (Math.random() * (double) brands.length)];
            String model = models[(int) (Math.random() * (double) models.length)];
            String color = colors[(int) (Math.random() * (double) colors.length)];

            cars[i] = new Car(i+1, brand, model, (int) (Math.random() * 3 + 2000), color, Math.random() * 10, i+101 );
        }

        return cars;
    }
}
