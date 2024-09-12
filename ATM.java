import java.util.Scanner;

// Step 4: BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }
}

// Step 1: ATM class to represent the ATM machine
public class ATM {
    private BankAccount account; // Step 5: Connect ATM with BankAccount

    // Constructor to associate the ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Step 2: ATM User Interface
    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            // Make sure to validate integer input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Step 3: Check Balance
                    System.out.println("Current Balance: $" + account.checkBalance());
                    break;
                
                case 2:
                    // Step 3: Deposit
                    System.out.print("Enter amount to deposit: $");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next(); // Consume invalid input
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                    
                case 3:
                    // Step 3: Withdraw
                    System.out.print("Enter amount to withdraw: $");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next(); // Consume invalid input
                    }
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                    
                case 4:
                    // Exit ATM
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        // Step 4: Initialize BankAccount with a starting balance
        BankAccount account = new BankAccount(500); // Initial balance of $500
        
        // Step 6: Validate user input and interact with the ATM
        ATM atm = new ATM(account);
        atm.startATM();  // Start the ATM user interface
    }
}
