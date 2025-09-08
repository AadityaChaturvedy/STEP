public class BankAccount { 
    // Static variables
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // Instance variables
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate);
    }

    // Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to " + accountHolder);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountHolder);
        } else {
            System.out.println("Insufficient funds for " + accountHolder);
        }
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Earned: $" + calculateInterest());
    }

    public static void main(String[] args) { 
        // Set bank name and interest rate using static methods
        BankAccount.setBankName("Copilot Bank");
        BankAccount.setInterestRate(3.5);

        // Create multiple BankAccount objects
        BankAccount acc1 = new BankAccount("1001", "Alice", 5000);
        BankAccount acc2 = new BankAccount("1002", "Bob", 3000);

        // Show that static members are shared across all objects
        BankAccount.displayBankInfo();

        // Show that instance members are unique to each object
        acc1.deposit(500);
        acc2.withdraw(1000);

        System.out.println("\nAccount 1 Info:");
        acc1.displayAccountInfo();

        System.out.println("\nAccount 2 Info:");
        acc2.displayAccountInfo();

        // Demonstrate calling static methods with and without objects
        System.out.println("\nTotal Accounts (static): " + BankAccount.getTotalAccounts());
        System.out.println("Total Accounts (via object): " + BankAccount.getTotalAccounts());
    }
}