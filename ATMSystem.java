public class ATMSystem {
    private static final int CORRECT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 3;
    private static int balance = 1000; // Starting balance
    private static boolean isLocked = false;

    // Method to verify PIN with 3 attempts
    public static boolean verifyPIN(int enteredPIN) {
        return enteredPIN == CORRECT_PIN;
    }

    // Method to check if account is locked
    public static boolean isAccountLocked() {
        return isLocked;
    }

    // Method to lock the account
    public static void lockAccount() {
        isLocked = true;
    }

    // Method to deposit money
    public static void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
            System.out.println("Amount deposited: $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid amount! Deposit amount must be greater than 0.");
        }
    }

    // Method to withdraw money
    public static void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds!");
            System.out.println("Your current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Amount withdrawn: $" + amount);
            checkBalance();
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Method to get current balance (for internal use)
    public static int getCurrentBalance() {
        return balance;
    }
}