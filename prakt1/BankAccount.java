import java.time.LocalDateTime;

public class BankAccount {
    String ownerName;
    int balance;
    LocalDateTime openingDate;
    boolean isBlocked;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть больше 0");
            return false;
        }
        if (isBlocked) {
            System.out.println("Счет заблокирован");
            return false;
        }
        balance += amount;
        System.out.println("Пополнено: " + amount + ", баланс: " + balance);
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть больше 0");
            return false;
        }
        if (isBlocked) {
            System.out.println("Счет заблокирован");
            return false;
        }
        if (balance < amount) {
            System.out.println("Недостаточно средств");
            return false;
        }
        balance -= amount;
        System.out.println("Снято: " + amount + ", баланс: " + balance);
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть больше 0");
            return false;
        }
        if (isBlocked || otherAccount.isBlocked) {
            System.out.println("Один из счетов заблокирован");
            return false;
        }
        if (balance < amount) {
            System.out.println("Недостаточно средств");
            return false;
        }
        
        balance -= amount;
        otherAccount.balance += amount;
        System.out.println("Переведено: " + amount + " на счет " + otherAccount.ownerName);
        return true;
    }
}