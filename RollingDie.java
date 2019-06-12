import java.util.Scanner;

class RollingDie {
  public static void main(String[] args) {
    Scanner kin = new Scanner(System.in);
    int die1 = (int)(Math.random() * 6 + 1);
    int die2 = (int)(Math.random() * 6 + 1);
    int sum = die1 + die2;
    System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", sum of two dice: " + sum);
    System.out.println("Would you like to roll again? (y/n)");
    String response = kin.nextLine();
    while (response.equals("y")) {
      die1 = (int)(Math.random() * 6 + 1);
      die2 = (int)(Math.random() * 6 + 1);
      sum = die1 + die2;
      System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", sum of two dice: " + sum);
      System.out.println("Would you like to roll again? (y/n) ");
      response = kin.nextLine();
    }
  }
}