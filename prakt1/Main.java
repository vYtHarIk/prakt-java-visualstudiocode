public class Main {
    public static void main(String[] args) {
        BankAccount num1 = new BankAccount("Влад");
        BankAccount num2 = new BankAccount("Арина");
        
        num1.deposit(5000);
        num1.withdraw(500);
        num1.transfer(num2, 500);
        
        System.out.println("Баланс Влада: " + num1.balance);
        System.out.println("Баланс Арины: " + num2.balance);
    }
}