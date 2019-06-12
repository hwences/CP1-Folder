import java.util.Scanner; // import Scanner class for user input

public class CashRegister {
  public static void main(String[] args) {

    // How to get Remainder Money: 
    // Input: System.out.println(5.50 % 2.00); 
    // Output: 0.50

    // How to Divide Money and Round it Down:
    // System.out.println((int) (5.50 / 2.00)); 
    // Output: 2

    Scanner kin = new Scanner(System.in); // new Scanner object for main user input

    System.out.println("Welcome to Change Generator");

    // Ask for and find amount of bill
    System.out.print("\nPlease Enter the amount of a Bill \nBill: $");
    double bill = kin.nextDouble();

    // Ask for and find amount of money paid
    System.out.print("\nPlease Enter the amount Paid \nPaid: $");
    double amountPaid = kin.nextDouble();

    // Calculate change
    double change = amountPaid - bill;
    System.out.println("\nChange: $" + change);
    
    // determines amount of 20 bills needed
    int twenties = (int) (change / 20);
    // finds remaining change after 20 bills taken out
    change = change % 20;
    
    // It repeats for tens to pennies:

    // 10 bills
    int tens = (int) (change / 10);
    change = change % 10;

    // 5 bills
    int fives = (int) (change / 5);
    change = change % 5;

    // 1 bills
    int ones = (int) (change / 1);
    change = change % 1;
    
    // quarters (25 cents)
    int quarters = (int) (change / 0.25);
    change = change % 0.25;
    
    // dimes (10 cents)
    int dimes = (int) (change / 0.10);
    change = change % 0.10;

    // nickels (5 cents)
    int nickels = (int) (change / 0.05);
    change = change % 0.05;

    // pennies (1 cent)
    int pennies = (int) (change / 0.01);
    change = change % 0.01;

    // Displays all coinage and billage
    System.out.println("$20: " + twenties);
    System.out.println("$10: " + tens);
    System.out.println("$5: " + fives);
    System.out.println("$1: " + ones);
    System.out.println("$.25: " + quarters);
    System.out.println("$.1: " + dimes);
    System.out.println("$.05: " + nickels);
    System.out.println("$.01: " + pennies); // Roundoff makes it 1 off sometimes
  }
}
