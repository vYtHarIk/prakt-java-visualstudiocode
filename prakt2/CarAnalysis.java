import java.util.ArrayList;

class Cars {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private double mileage;
    private double price;
    
    public Cars(String vin, String model, String manufacturer, 
               int year, double mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    public int getYear() {
        return year;
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
        ArrayList<Cars> cars = new ArrayList<>();
        
        cars.add(new Cars("VIN1", "Clio", "Renault", 2021, 35000, 18000));
        cars.add(new Cars("VIN2", "308", "Peugeot", 2022, 15000, 22000));
        cars.add(new Cars("VIN3", "C4", "Citroen", 2020, 42000, 16000));
        cars.add(new Cars("VIN4", "Focus", "Ford", 2023, 8000, 24000));
        cars.add(new Cars("VIN5", "Astra", "Opel", 2019, 55000, 14000));
        cars.add(new Cars("VIN6", "Megane", "Renault", 2022, 12000, 21000));
        cars.add(new Cars("VIN7", "208", "Peugeot", 2021, 28000, 17000));
        cars.add(new Cars("VIN8", "Berlingo", "Citroen", 2020, 48000, 15000));
        
        System.out.println("--- Все автомобили ---");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("  " + (i+1) + ". " + cars.get(i).getInfo());
        }
        
        System.out.println("Машины с пробегом < 50000 км:");
        int count1 = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getMileage() < 50000) {
                count1++;
                System.out.println("  " + count1 + ". " + cars.get(i).getInfo());
            }
        }
        if (count1 == 0) System.out.println("Нет таких машин");
        
        System.out.println("Топ-3 самых дорогих:");
        
        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = 0; j < cars.size() - i - 1; j++) {
                if (cars.get(j).getPrice() < cars.get(j + 1).getPrice()) {
                    Cars temp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, temp);
                }
            }
        }
        
        for (int i = 0; i < 3 && i < cars.size(); i++) {
            System.out.println("  " + (i+1) + ". " + cars.get(i).getInfo());
        }
        
        System.out.println("Средний пробег:");
        double sum = 0;
        for (int i = 0; i < cars.size(); i++) {
            sum += cars.get(i).getMileage();
        }
        double averageMileage = sum / cars.size();
        System.out.printf("  Средний пробег: %.2f км\n", averageMileage);
        
        System.out.println("По производителям:");
        
        ArrayList<Cars> renault = new ArrayList<>();
        ArrayList<Cars> peugeot = new ArrayList<>();
        ArrayList<Cars> citroen = new ArrayList<>();
        ArrayList<Cars> ford = new ArrayList<>();
        ArrayList<Cars> opel = new ArrayList<>();
        
        for (int i = 0; i < cars.size(); i++) {
            Cars c = cars.get(i);
            String mfr = c.getManufacturer();
            
            if (mfr.equals("Renault")) {
                renault.add(c);
            } else if (mfr.equals("Peugeot")) {
                peugeot.add(c);
            } else if (mfr.equals("Citroen")) {
                citroen.add(c);
            } else if (mfr.equals("Ford")) {
                ford.add(c);
            } else if (mfr.equals("Opel")) {
                opel.add(c);
            }
        }
        
        System.out.println("Renault (" + renault.size() + " шт.):");
        for (int i = 0; i < renault.size(); i++) {
            System.out.println("  - " + renault.get(i).getModel() + 
                             " (" + renault.get(i).getYear() + " г.)");
        }
        
        System.out.println("Peugeot (" + peugeot.size() + " шт.):");
        for (int i = 0; i < peugeot.size(); i++) {
            System.out.println("  - " + peugeot.get(i).getModel() + 
                             " (" + peugeot.get(i).getYear() + " г.)");
        }
        
        System.out.println("Citroen (" + citroen.size() + " шт.):");
        for (int i = 0; i < citroen.size(); i++) {
            System.out.println("  - " + citroen.get(i).getModel() + 
                             " (" + citroen.get(i).getYear() + " г.)");
        }
        
        System.out.println("Ford (" + ford.size() + " шт.):");
        for (int i = 0; i < ford.size(); i++) {
            System.out.println("  - " + ford.get(i).getModel() + 
                             " (" + ford.get(i).getYear() + " г.)");
        }
        
        System.out.println("Opel (" + opel.size() + " шт.):");
        for (int i = 0; i < opel.size(); i++) {
            System.out.println("  - " + opel.get(i).getModel() + 
                             " (" + opel.get(i).getYear() + " г.)");
        }
        
        // Дополнительно: статистика по маркам
        System.out.println("--- Дополнительная статистика ---");
        System.out.println("Всего машин: " + cars.size());
        System.out.println("Количество марок: 5 (Renault, Peugeot, Citroen, Ford, Opel)");
    }
}