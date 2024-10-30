import java.util.ArrayList;

public class CarManager {
    private ArrayList<Car> cars;

    public CarManager(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // a) Список автомобилей заданной марки
    public void printCarsByMake(String make) {
        System.out.println("Cars of make: " + make);
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                System.out.println(car);
            }
        }
    }

    // b) Список автомобилей заданной модели, которые эксплуатируются больше n лет
    public void printCarsByModelAndAge(String model, int n, int currentYear) {
        System.out.println("Cars of model: " + model + " older than " + n + " years");
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.getAge(currentYear) > n) {
                System.out.println(car);
            }
        }
    }

    // c) Список автомобилей заданного года выпуска, цена которых больше указанной
    public void printCarsByYearAndPrice(int year, double price) {
        System.out.println("Cars of year: " + year + " with price more than " + price);
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                System.out.println(car);
            }
        }
    }
}
