import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание массива автомобилей
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 2015, "White", 12000, "ABC123"));
        cars.add(new Car(2, "Honda", "Accord", 2012, "Black", 9000, "DEF456"));
        cars.add(new Car(3, "Toyota", "Corolla", 2010, "Silver", 7000, "GHI789"));
        cars.add(new Car(4, "Ford", "Focus", 2018, "Blue", 13000, "JKL012"));
        cars.add(new Car(5, "Honda", "Civic", 2020, "Red", 15000, "MNO345"));

        // Инициализация CarManager
        CarManager manager = new CarManager(cars);

        // a) Список автомобилей заданной марки
        manager.printCarsByMake("Toyota");

        // b) Список автомобилей заданной модели, которые эксплуатируются больше n лет
        manager.printCarsByModelAndAge("Accord", 10, 2024);

        // c) Список автомобилей заданного года выпуска, цена которых больше указанной
        manager.printCarsByYearAndPrice(2020, 10000);
    }
}
