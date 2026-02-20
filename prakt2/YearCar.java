import java.util.Arrays;
import java.util.Random;

public class YearCar {
    public static void main(String[] args) {
        int[] carYears = new int[50];
        Random random = new Random();
        
        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = 2000 + random.nextInt(26);
        }
        
        System.out.println("Годы выпуска всех машин:");
        System.out.println(Arrays.toString(carYears));
        
        System.out.println("Машины, выпущенные после 2015 года:");
        for (int year : carYears) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }
        System.out.println();
    }
}