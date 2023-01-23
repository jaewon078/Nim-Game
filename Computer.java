/*****************************************
 * A template for a computer Nim player
 * Jaewon Lee
 * jl6367
 * My Computer Class
 ****************************************/
import java.util.Random;

public class Computer {

  private int mode;
  private int choice;
  private double wantedPile;
  private int intWantedPile;
  private int nthPower;
  private int marbLeft;

  public Computer(int m) {
    mode = m;
    choice = -1;
  }

  // The method used whenever the computer makes a move
  public void move(int marbles) {
    marbLeft = marbles;

    // For the cases where the computer is bound to lose with one marble left in the
    // pile
    if (marbLeft == 1) {
      System.out.println("The computer must pick the last marble!");
      System.out.println("Amount picked by the computer: 1");
      System.out.println("Marble(s) left: 0");
      marbLeft = 0;
      return;
    }

    // For "stupid" mode
    if (mode == 1) {

      // Creates the random, "stupid" choice and prints it
      Random rand = new Random();
      choice = rand.nextInt(marbLeft / 2) + 1;
      System.out.println("Amount picked by the computer: " + choice);

      // Finds out how many marbles are left and prints it
      marbLeft = marbLeft - choice;
      System.out.println("Marble(s) left: " + marbLeft);
    }

    if (mode == 2) {

      // Establishes the logic behind the "smart" choice
      nthPower = (int) (Math.log(marbLeft) / Math.log(2));
      wantedPile = Math.pow(2, nthPower) - 1;
      intWantedPile = (int) Math.round(wantedPile);

      // In case the size of the pile is 3, 7, 15, 31, or 63
      // Essentially a failsafe, a copy of "stupid" mode
      if (marbLeft == (intWantedPile * 2) + 1) {

        // Creates the random, "stupid" choice and prints it
        Random rand = new Random();
        choice = rand.nextInt(marbLeft / 2) + 1;
        System.out.println("Amount picked by the computer: " + choice);

        // Finds out how many marbles are left and prints it
        marbLeft = marbLeft - choice;
        System.out.println("Marble(s) left: " + marbLeft);
        return;
      }

      // Determines the "smart" choice and prints it
      if (!(marbLeft == intWantedPile) && intWantedPile <= 100) {
        choice = marbLeft - intWantedPile;
        System.out.println("The computer chooses to take out " + choice + " marble(s)");

        // Determines the amount of marbles left in the pile and prints it
        marbLeft = marbLeft - choice;
        System.out.println("Marble(s) left: " + marbLeft);
      }
    }
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