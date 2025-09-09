import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Default constructor
    BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = 0;
        this.balance = 0;
    }

    // Constructor with name
    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(100000);
        this.balance = 0;
    }

    // Constructor with name and balance
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(100000);
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if(amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance!");
    }

    void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + 
                ", Account No: " + accountNumber + ", Balance: $" + balance);
    }
}

public class MainBank {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount("Alice");
        BankAccount b3 = new BankAccount("Bob", 1000);

        b2.deposit(500);
        b3.withdraw(200);

        b1.displayAccount();
        b2.displayAccount();
        b3.displayAccount();
    }
}
