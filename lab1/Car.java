import java.util.Objects;

public class Car {
    private int id;
    private String make;  
    private String model; 
    private int year;     
    private String color; 
    private double price; 
    private String regNumber; 

 
    public Car(int id, String make, String model, int year, String color, double price, String regNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    //  возраст автомобиля
    public int getAge(int currentYear) {
        return currentYear - this.year;
    }

   
    @Override
    public String toString() {
        return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", color=" + color
                + ", price=" + price + ", regNumber=" + regNumber + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year, color, price, regNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        return id == other.id && year == other.year && Double.compare(other.price, price) == 0
                && Objects.equals(make, other.make) && Objects.equals(model, other.model)
                && Objects.equals(color, other.color) && Objects.equals(regNumber, other.regNumber);
    }
}
