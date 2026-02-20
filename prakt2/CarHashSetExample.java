import java.util.HashSet;

class Car {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private double mileage;
    private double price;
    
    public Car(String vin, String model, String manufacturer, int year, double mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Car car = (Car) obj;
        return vin.equals(car.vin);
    }
    
    @Override
    public int hashCode() {
        return vin.hashCode();
    }
    
    public int compareTo(Car other) {
        return other.year - this.year;
    }
    
    public String getVin() { return vin; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    
    @Override
    public String toString() {
        return String.format("VIN: %s, Модель: %s, Год: %d, Цена: %.0f", 
                           vin, model, year, price);
    }
}

public class CarHashSetExample {
    public static void main(String[] args) {
        Car car1 = new Car("ABC123", "Camry", "Toyota", 2020, 45000, 25000);
        Car car2 = new Car("XYZ789", "X5", "BMW", 2021, 30000, 55000);
        Car car3 = new Car("ABC123", "Corolla", "Toyota", 2022, 10000, 23000);
        
        HashSet<Car> cars = new HashSet<>();
        
        System.out.println("Добавляем первую машину:");
        cars.add(car1);
        System.out.println("Размер HashSet: " + cars.size()); // 1
        
        System.out.println("Добавляем вторую машину (другой VIN):");
        cars.add(car2);
        System.out.println("Размер HashSet: " + cars.size()); // 2
        
        System.out.println("Добавляем третью машину (такой же VIN как у первой):");
        cars.add(car3);
        System.out.println("Размер HashSet: " + cars.size()); // 2 (дубликат не добавился)
        
        System.out.println("Машины в HashSet:");
        for (Car car : cars) {
            System.out.println(car);
        }
        
        System.out.println("Проверка сравнения:");
        System.out.println("car1 equals car2? " + car1.equals(car2));
        System.out.println("car1 equals car3? " + car1.equals(car3));
        
        System.out.println("Сортировка по году: (от новых к старым)");
        Car[] carArray = {car1, car2, car3};
        
        for (int i = 0; i < carArray.length - 1; i++) {
            for (int j = 0; j < carArray.length - i - 1; j++) {
                if (carArray[j].compareTo(carArray[j + 1]) > 0) {
                    Car temp = carArray[j];
                    carArray[j] = carArray[j + 1];
                    carArray[j + 1] = temp;
                }
            }
        }
        
        for (Car car : carArray) {
            System.out.println(car.getYear() + " - " + car.getModel() + " (" + car.getVin() + ")");
        }
    }
}