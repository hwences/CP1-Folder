import java.util.Scanner;
import java.util.Arrays;

public class Main {
  // Static variables outside main accessible in all methods
  static int userY, userX; // User or 'x' coordinates
  static int goalY, goalX; // Ending spot or '*' coordinates
  static int[] enemyYs, enemyXs; // Enemy or '#' coordinates

  public static void main(String[] args) {
    Scanner kin = new Scanner(System.in); // For user input
    String answer = "";
    int moves; // User's move counter
    int wins = 0; // User's level win counter
    int losses = 0; // User's level loss counter
    int eff; // Minimum number of moves needed to win
    boolean run = true; // If the game is still running or adding more levels
    char[][] board = new char[4][4]; // Set board and its original size
    int[] enemyYs = new int[1];
    int[] enemyXs = new int[1];

    // Welcome text
    System.out.println("Welcome to the Array Game!  Move your sprite \"x\" to the \"*\" to win.");
    System.out.println("\nInitial Board:");
    
    while (run) {
      moves = 0; // Reset move counter

      userY = 0; userX = 0; // Set original user coordinates
      goalY = 0; goalX = 0;
      while (goalY == userY && goalX == userX) { // While goal coordinates are the user coordinates to avoid win without moves
        // Set original ending spot coordinates
        goalY = (int) (Math.random() * board.length);
        goalX = (int) (Math.random() * board[0].length);
      }
      eff = goalY + goalX; // Set minimum numebr of moves needed to win
      for (int i = 0; i < enemyXs.length; i++) {
        enemyYs[i] = 0;
        enemyXs[i] = 0;

        while ((enemyYs[i] == userY && enemyXs[i] == userX) || (enemyYs[i] == goalY && enemyXs[i] == goalX)) { // While enemy coordinates are the user coordinates and goal coordinates to avoid automatic loss
          // Set original ending spot coordinates
          enemyYs[i] = (int) (Math.random() * board.length);
          enemyXs[i] = (int) (Math.random() * board[0].length);
        }
      }
  
      // Set all of board to be empty spot represented by 'O'
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          board[row][col] = 'O';
        }
      }

      board[userY][userX] = 'x'; // Adds user to position of user
      board[goalY][goalX] = '*'; // Adds goal to position of goal
      for (int i = 0; i < enemyXs.length; i++) {
        // Adds enemies to their positions
        board[enemyYs[i]][enemyXs[i]] = '#';
      }

      while (userY != goalY || userX != goalX) { // While user is not on ending spot
        moves = moves + 1; // Adds a move to counter as user moves
      
        printBoard(board); // Print current board
    
        // Ask user to enter direction
        System.out.print("\nWhat direction would you like to move (up/down/left/right)? ");
        answer = kin.nextLine();
      
        board[userY][userX] = 'O'; // Before updating user coordinates, leave empty space for what will be left behind
        checkMove(answer, board); // Interpret user input
        board[userY][userX] = 'x'; // After updating user coordinates, change visible position on screen
        
        if (userY == goalY && userX == goalX) { // If the user has won on goal's spot 
          wins = wins + 1;
        }
        for (int i = 0; i < enemyXs.length; i++) { 
          if (userY == enemyYs[i] && userX == enemyXs[i]) { // If the user has lost on an enemy's spot
            losses = losses + 1;
            break;
          }
        }
      }
      
      // Congratulations text and counting moves
      System.out.println("\nCongrats, you have won! You completed the game in " + moves + " moves.");

      if (moves == eff) {
        System.out.println ("You have completed this level in the most efficient way! The robot overlords are happy with your success."); // Positive end message
      } else {
        System.out.println ("You didn't complete this level in the most efficient way. You could've done it in " + eff + " moves."); // Negative end message
      }

      // Ask if user wants to keep playing
      System.out.print("\nYou already won " + wins + " time(s) and lost " + losses + " time(s). Do you want to play the next level? (y/n) ");
      answer = kin.nextLine();
      if (answer.equals("n")) {
        run = false;
      }
      
      for (int i = 0; i < board.length; i++) {
        // Add one element to each row to create new column 
        board[i] = Arrays.copyOf(board[i], board[i].length + 1);
      }
      board = Arrays.copyOf(board, board.length + 1); // Increases number or rows
      board[board.length - 1] = new char[board[0].length]; // Adds array in new row
    }
  }
 
  // Print board
  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        System.out.print(board[row][col] + " "); // Prints each value of board
      }
      System.out.println(); // Prints new line
    }
  }
  
  // Use the answer to user input to interpret move
  public static void checkMove(String answer, char[][] board) {
    if (answer.equals("up")) { // If player wants to move up
        if (userY == 0) { // If player is on top edge
          System.out.println("Invalid Move");
        } else {
          userY = userY - 1;
        }
    } else if (answer.equals("down")) { // If player wants to move down
      if (userY == board.length - 1) { // If player is on bottom edge
        System.out.println("Invalid Move");
      } else {
        userY = userY + 1;
      }
    } else if (answer.equals("left")) { // If player wants to move left
      if (userX == 0) { // If player is on left edge
        System.out.println("Invalid Move");
      } else {
        userX = userX - 1;
      }
    } else if (answer.equals("right")) { // If player wants to move right
      if (userX == board[0].length - 1) { // If the player is on right edge
        System.out.println("Invalid Move");
      } else {
        userX = userX + 1;
      }
    } else { // If the player says anything but up/down/left/right
        System.out.println("Invalid Input");
    }
  }
}  