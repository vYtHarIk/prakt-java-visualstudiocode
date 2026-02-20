import java.util.*;

public class CarCollection {
    public static void main(String[] args) {
        List<String> carModels = new ArrayList<>(Arrays.asList(
            "Toyota Camry", 
            "BMW X5", 
            "Tesla Model S", 
            "Honda Civic",
            "Toyota Camry", 
            "Tesla Model 3", 
            "BMW X5", 
            "Audi A4",
            "Mercedes C Class", 
            "Tesla Model S", 
            "Honda Civic", 
            "Ford Focus"
        ));
        
        System.out.println("Исходный список (с дубликатами):");
        System.out.println(carModels);
        
        Set<String> uniqueModels = new LinkedHashSet<>(carModels);
        List<String> uniqueList = new ArrayList<>(uniqueModels);
        Collections.sort(uniqueList, Collections.reverseOrder());
        
        System.out.println("\nПосле удаления дубликатов и сортировки (обратный алфавитный порядок):");
        System.out.println(uniqueList);
        
        Set<String> modelSet = new TreeSet<>(Collections.reverseOrder());
        modelSet.addAll(uniqueList);
        
        List<String> modifiedModels = new ArrayList<>();
        for (String model : carModels) {
            if (model.contains("Tesla")) {
                modifiedModels.add("ELECTRO_CAR");
            } else {
                modifiedModels.add(model);
            }
        }
        
        System.out.println("Список с заменой Tesla на ELECTRO_CAR:");
        System.out.println(modifiedModels);
    }
}