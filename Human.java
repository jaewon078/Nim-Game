/*****************************************
 * A template for a Human Nim player
 * Jaewon Lee
 * jl6367
 * My Human Class
 ****************************************/
import java.util.Scanner;

public class Human {

  private int choice;
  private Scanner input;
  private int marbLeft;

  public Human() {
    input = new Scanner(System.in);
    choice = -1;
  }

  // A method for the first move by a human
  public void move(int marbles) {
    marbLeft = marbles;

    // For the cases where the player is bound to lose with one marble left in the
    // pile
    if (marbLeft == 1) {
      System.out.println("You must pick the last marble!");
      choice = input.nextInt();
      while (choice != 1) {
        System.out.println("There's no getting out of this! You must pick the last marble!");
        choice = input.nextInt();
      }
      System.out.println("Marble(s) left: 0");
      return;
    }

    // Asks player to pick out an amount of marbles
    System.out.println("State a valid number of marbles to take out of the pile:");
    choice = input.nextInt();

    // Checks if the user input is valid
    while (choice < 1 || choice > marbLeft / 2) {
      System.out.println("You've inputted an invalid number. Please re-enter a valid number:");
      choice = input.nextInt();
    }

    // Prints out the amount of marbles marbles left
    marbLeft = marbLeft - choice;
    System.out.println("Marble(s) left: " + marbLeft);
  }

  // The method that returns the choice
  public int getChoice() {
    return choice;
  }

  // The method that returns the amount of marbles left
  public int getMarbLeft() {
    return marbLeft;
  }

}
