package ATMMachine;
import java.sql.*;

import java.util.Scanner;

class ATM {
    float balance;
    int PIN = 1234;

    public void checkpin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nEnter your Choice: ");
            System.out.println("1. Check your Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money ");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> withdrawMoney();
                case 3 -> depositMoney();
                case 4 -> {
                    System.out.println("Thank you for using our ATM!");
                    return; // Exiting the method, effectively ending the program
                }
                default -> System.out.println("Invalid Choice");
            }
            System.out.println("Thank you for your transaction.");
            System.out.println("Would you like to go back to the menu or exit? (Menu/Exit)");
            String decision = sc.next();
            if (decision.equalsIgnoreCase("Exit")) {
                System.out.println("Thank you for using our ATM!");
                return; // Exiting the method, effectively ending the program
            }
        } while (true); // Loop until the user chooses to exit
    }

    public void checkBalance() {
        System.out.println("Your balance is: Rs : " + balance);
    }

    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw: ");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: Rs" + balance);
        }
    }

    public void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit: ");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkpin();
    }
}
