import java.util.ArrayList;

class Car {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private double mileage;
    private double price;
    
    public Car(String vin, String model, String manufacturer, 
               int year, double mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public double getMileage() { return mileage; }
    public double getPrice() { return price; }
    
    public String getInfo() {
        return manufacturer + " " + model + " (" + year + ") - " + 
               mileage + " км, $" + price;
    }
}

public class CarAnalysis {
    public static void main(String[] args) {
        // Создаем несколько машин вручную (всего 5 штук для простоты)
        ArrayList<Car> cars = new ArrayList<>();
        
        cars.add(new Car("VIN1", "Camry", "Toyota", 2020, 45000, 25000));
        cars.add(new Car("VIN2", "X5", "BMW", 2021, 30000, 55000));
        cars.add(new Car("VIN3", "Model 3", "Tesla", 2023, 5000, 45000));
        cars.add(new Car("VIN4", "Civic", "Honda", 2019, 60000, 18000));
        cars.add(new Car("VIN5", "Corolla", "Toyota", 2022, 10000, 23000));
        
        // Задание 1: Машины с пробегом < 50000
        System.out.println("Машины с пробегом < 50000 км:");
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getMileage() < 50000) {
                System.out.println("  " + cars.get(i).getInfo());
            }
        }
        
        // Задание 2-3: Топ-3 по цене
        System.out.println("\nТоп-3 самых дорогих:");
        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = 0; j < cars.size() - i - 1; j++) {
                if (cars.get(j).getPrice() < cars.get(j + 1).getPrice()) {
                    Car temp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("  " + (i+1) + ". " + cars.get(i).getInfo());
        }
        
        // Задание 4: Средний пробег
        double sum = 0;
        for (int i = 0; i < cars.size(); i++) {
            sum += cars.get(i).getMileage();
        }
        System.out.println("\nСредний пробег: " + (sum / cars.size()) + " км");
        
        // Задание 5: Группировка
        System.out.println("\nПо производителям:");
        ArrayList<Car> toyota = new ArrayList<>();
        ArrayList<Car> others = new ArrayList<>();
        
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.getManufacturer().equals("Toyota")) {
                toyota.add(c);
            } else {
                others.add(c);
            }
        }
        
        System.out.println("Toyota (" + toyota.size() + "):");
        for (int i = 0; i < toyota.size(); i++) {
            System.out.println("  " + toyota.get(i).getModel());
        }
        
        System.out.println("Остальные (" + others.size() + "):");
        for (int i = 0; i < others.size(); i++) {
            System.out.println("  " + others.get(i).getManufacturer() + 
                             " " + others.get(i).getModel());
        }
    }
}