public class SecureBankAccount {
    // Private fields
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    // Constants
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    // Constructor
    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0; // default, must be set later
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    // --- Account Info Methods ---
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked!");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    // --- Security Methods ---
    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
            return true;
        }
        return false;
    }

    // --- Transactions ---
    public boolean deposit(double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, int pin) {
        if (validatePin(pin) && !isLocked && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(SecureBankAccount target, double amount, int pin) {
        if (withdraw(amount, pin)) {
            target.deposit(amount, pin);
            return true;
        }
        return false;
    }

    // --- Private Helpers ---
    private void lockAccount() {
        isLocked = true;
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("A123", 500);
        SecureBankAccount acc2 = new SecureBankAccount("B456", 300);

        // ❌ Direct field access not allowed:
        // acc1.balance = 1000; // ERROR

        acc1.setPin(0, 1234);
        acc2.setPin(0, 9999);

        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);

        System.out.println("Acc1 Balance: " + acc1.getBalance());

        acc1.transfer(acc2, 200, 1234);
        System.out.println("Acc2 Balance: " + acc2.getBalance());

        // Wrong PIN attempts
        acc1.withdraw(50, 1111); // ❌
        acc1.withdraw(50, 1111); // ❌
        acc1.withdraw(50, 1111); // ❌ (locks account)
        System.out.println("Locked? " + acc1.isAccountLocked());
    }
}
