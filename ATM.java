import java.util.Scanner;

class ATM {
    private static final String USER_ID = "Rohit";
    private static final String USER_PIN = "8486";
    private double bal; // balance
    private boolean hasTrans = false; // checking if having previous any transactions 

    public ATM() {
        bal = 0.0;
        hasTrans = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM Virtual machine!!");
    
        if (!authenticateUser(scanner)) {
            System.out.println("Authentication failed. Exiting the program");
            return;
    }
    
        int choice;
        do {
            Menu();
            System.out.println("Enter your choice");
            choice = scanner.nextInt();  // selecting the choice from the user
        
            switch(choice) {
                case 1:
                    showtrans();
                    break;
            
                case 2:
                    System.out.println("Enter the amount to withdraw");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                
                case 3:
                    System.out.println("Enter the amount to be deposited");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                
                case 4:
                    System.out.println("Enter the amount to transfer");
                    double transferAmount = scanner.nextDouble();
                    System.out.println("Enter the recipient's account number");
                    int recipientAccount = scanner.nextInt();
                    transfer(transferAmount,recipientAccount);
                    break;
                
                case 5:
                    System.out.println("Thank You for using the ATM!");
                    break;
                
                default:
                    System.out.println("Invalid Choice. TRY AGAIN !! ");
                
            }
        }
        while (choice != 5);
    }

    private boolean authenticateUser(Scanner scanner) {
        System.out.println("Enter the User ID");
        String userID = scanner.next();
        System.out.println("Enter the User PIN");
        String userPIN = scanner.next();
    
        if (userID.equals(USER_ID) && userPIN.equals(USER_PIN)) {
            System.out.println("AUTHENTICATION SUCCESSFULL");
            return true;
        }
        return false;
    }

    private void Menu() {
        System.out.println("\n CHOOSE WHAT YOU WANT TO DO: ");
        System.out.println("1. Transaction History ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit ");
        System.out.println("4. Transfer ");
        System.out.println("5. QUIT ");
    }
    
    private void showtrans() {
        System.out.println("\n Transaction History:");
        if (hasTrans == false) {
            System.out.println("No transaction done yet from this account");
        }
        else {
            System.out.println("Transaction Done");
        }
    }
    
    private void withdraw(double amount) {
        if (amount>bal){
            System.out.println("Insufficient Balance");
        }
        else{
            bal= bal - amount;
            System.out.println("withdrawal of rs" + amount + "successful");
            System.out.println("current balance: rs" + bal);
            hasTrans = true;
        }
    }
    
    private void deposit(double amount)
    {
        bal = bal + amount;
        System.out.println("deposit of rs." + amount + "successful");
        System.out.println("current balance" + bal);
    }
    
    private void transfer(double amount, int recipientAccount)
    {
        System.out.println("Transfer of Rs." + amount + "to account " + recipientAccount +"successful");
        bal= bal - amount;
        System.out.println("Current Balance: Rs" + bal);
        hasTrans = true;
    }
}
public class Main{
    public static void main (String[] args){
        ATM atm = new ATM();
        atm.start();
    }
}