public class PersonalFinanceManager {
    public static void main(String[] args) {
        // Set bank name (static, shared by all accounts)
        PersonalAccount.setBankName("Future Bank");

        // Create 3 accounts
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

        // Perform transactions
        acc1.addIncome(2000, "Salary");
        acc1.addExpense(500, "Rent");
        acc1.addExpense(200, "Groceries");

        acc2.addIncome(1500, "Freelance");
        acc2.addExpense(300, "Utilities");
        acc2.addIncome(200, "Gift");

        acc3.addIncome(3000, "Business");
        acc3.addExpense(1000, "Supplies");
        acc3.addExpense(400, "Travel");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Show static vs instance variable difference
        System.out.println("\nBank Name (static): " + PersonalAccount.bankName);
        System.out.println("Total Accounts (static): " + PersonalAccount.getTotalAccounts());
        System.out.println("Alice's Balance: " + acc1.getCurrentBalance());
        System.out.println("Bob's Balance: " + acc2.getCurrentBalance());
        System.out.println("Charlie's Balance: " + acc3.getCurrentBalance());
    }
}

class PersonalAccount {
    // Private instance variables
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    public static int totalAccounts = 0;
    public static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            totalIncome += amount;
            currentBalance += amount;
            System.out.println(accountHolderName + " received income: " + amount + " (" + description + ")");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            totalExpenses += amount;
            currentBalance -= amount;
            System.out.println(accountHolderName + " spent: " + amount + " (" + description + ")");
        } else if (amount > currentBalance) {
            System.out.println(accountHolderName + " tried to spend " + amount + " (" + description + ") but insufficient balance.");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\nAccount Summary for " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "ACCT" + (1000 + totalAccounts);
    }

    // Getter for currentBalance (for demonstration)
    public double getCurrentBalance() {
        return currentBalance;
    }
}