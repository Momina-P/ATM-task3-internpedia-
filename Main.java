import java.util.Scanner;

class UserAccount {
    private double balance;

    public UserAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdraw failed.");
        } else {
            System.out.println("Invalid withdraw amount");
        }
    }

 

}

class ATM {
    private UserAccount userAccount;

    public ATM(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

public void showMenu () {
Scanner scanner = new Scanner(System.in);
int choice;
do {
System.out.println("ATM Menu:");
System.out.println("1. Check Balance ⚖️");
System.out.println("2. Deposit 💰");
System.out.println("3. Withdraw 💸");
System.out.println(" 4. Exit");
System.out.print("Choice a option:");

choice = scanner.nextInt();

 switch (choice) {

 case 1: 
 System.out.println("Current Balance: $" + userAccount.getBalance());
 break;

 case 2: 
 System.out.println("Enter deposit amount:");
 double depositAmount = scanner.nextDouble();
 userAccount.deposit(depositAmount);
 break;

 case 3: 
 System.out.println("Enter withdraw amount:");
 double withdrawAmount = scanner.nextDouble();
 userAccount.withdraw(withdrawAmount);
 break;


 case 4: 
 System.out.println("Exiting ATM. Have a Good Day:");
 break;

default:
System.err.println("Invalid choice. Please try again.");


}
} while (choice != 4);
scanner.close();
}
}

public class Main {
    public static void main(String[] argse) {
        UserAccount userAccount = new UserAccount (20000.00);
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}