
import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private double balance;
    private ArrayList<String> transactions;

    BankAccount(double initialBalance) {
        balance = initialBalance;
        transactions = new ArrayList<>();
        transactions.add("Account opened with Rs. " + initialBalance);
    }

    void checkBalance() {
        System.out.println("Available Balance: Rs. " + balance);
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount!");
            return;
        }

        balance += amount;
        transactions.add("Deposited: Rs. " + amount);
        System.out.println("Amount deposited successfully!");
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: Rs. " + amount);
            System.out.println("Please collect your amount.");
        }
    }

    void showTransactions() {
        System.out.println("\n--- Transaction History ---");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        int choice;

        System.out.println("===== WELCOME TO JAVA ATM =====");

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid choice: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        double deposit = sc.nextDouble();
                        account.deposit(deposit);
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        double withdraw = sc.nextDouble();
                        account.withdraw(withdraw);
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using Java ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

