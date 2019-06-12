//Mirza Mehmedagic
//Horeb Wences

import java.util.Scanner;

public class Craps {
  public static int RollDice() {
    int die1 = (int)(Math.random() * 6 + 1);
    int die2 = (int)(Math.random() * 6 + 1);
    int sum = die1 + die2;
    return sum;
  }
  
  public static void main(String[] args) {
    Scanner kin = new Scanner(System.in);

    System.out.println("Let's play craps\n");

    int point = RollDice();
    System.out.println("First roll: " + point);
    int repoint = 0;

    if (point == 7 || point == 11) {
      System.out.println("You win!");
    } else if (point == 2 || point == 3 || point == 12) {
      System.out.println("You lose");
    } else {
      while (point != repoint && repoint != 7) {
        System.out.println("Roll again\n");
        repoint = RollDice();
        System.out.println("Next roll: " + repoint);
        if (repoint == point) {
          System.out.println("You win!");
        } else if (repoint == 7) {
          System.out.println("You lose");
        }
      }
    }
  }
}