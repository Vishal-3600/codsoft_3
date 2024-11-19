import java.util.Scanner;

class  UserBankAccount{
    private int pin = 7777;
    private float balance = 0.0f;

    void options() {
        System.out.println("\nEnter your choice:");
        System.out.println("1: CHECK BALANCE");
        System.out.println("2: WITHDRAW");
        System.out.println("3: DEPOSIT");
        System.out.println("4: EXIT");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.close();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                return; 
            default:
                System.out.println("Invalid choice. Try again.");
                options();
        }
       
    }

    void checkPin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            options();
        } else {
            System.out.println("Invalid PIN.");
            System.out.println("Enter 1 to try again, or any other key to exit:");
            int retry = sc.nextInt();
            if (retry == 1) {
                checkPin();
            } else {
                System.out.println("Exiting...");
            }
        }
        sc.close();
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
        options();
    }

    void withdraw() {
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
        }
        options();
        sc.close();
    }

    void deposit() {
        System.out.println("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
        options();
        sc.close();
    }
    
}

public class Atm{
    public static void main(String[] args) {
        UserBankAccount atm = new UserBankAccount();
        atm.checkPin();
    }
}
