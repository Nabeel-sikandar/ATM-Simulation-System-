import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO ATM SIMULATION SYSTEM ===\n");

        // PIN verification with 3 attempts using for loop
        boolean loginSuccessful = false;

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter your PIN: ");
            int enteredPIN = scanner.nextInt();

            if (ATMSystem.verifyPIN(enteredPIN)) {
                loginSuccessful = true;
                System.out.println("PIN verified successfully!\n");
                break;
            } else {
                System.out.println("Incorrect PIN! Attempt " + attempt + " of 3");
                if (attempt < 3) {
                    System.out.println("Please try again.\n");
                }
            }
        }

        // Check if account should be locked
        if (!loginSuccessful) {
            ATMSystem.lockAccount();
            System.out.println("Account locked due to 3 failed PIN attempts!");
            System.out.println("Please contact your bank for assistance.");
            scanner.close();
            return;
        }

        // Main ATM menu using while loop
        while (true) {
            System.out.println("=== ATM MENU ===");
            System.out.println("a) Deposit");
            System.out.println("b) Withdraw");
            System.out.println("c) Check Balance");
            System.out.println("d) Exit");
            System.out.print("Choose an option (a/b/c/d): ");

            String choice = scanner.next().toLowerCase();
            System.out.println();

            switch (choice) {
                case "a":
                    handleDeposit(scanner);
                    break;

                case "b":
                    handleWithdrawal(scanner);
                    break;

                case "c":
                    System.out.println("=== BALANCE INQUIRY ===");
                    ATMSystem.checkBalance();
                    break;

                case "d":
                    System.out.println("Thank you for using our ATM!");
                    System.out.println("Have a great day!");
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid option! Please choose a, b, c, or d.");
                    continue; // Continue to next iteration
            }

            System.out.println("\n" + "=".repeat(40) + "\n");
        }
    }

    private static void handleDeposit(Scanner scanner) {
        System.out.println("=== DEPOSIT ===");
        System.out.print("Enter deposit amount: $");

        if (scanner.hasNextInt()) {
            int amount = scanner.nextInt();
            ATMSystem.deposit(amount);
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
    }

    private static void handleWithdrawal(Scanner scanner) {
        System.out.println("=== WITHDRAWAL ===");
        System.out.print("Enter withdrawal amount: $");

        if (scanner.hasNextInt()) {
            int amount = scanner.nextInt();
            ATMSystem.withdraw(amount);
        } else {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
    }
}