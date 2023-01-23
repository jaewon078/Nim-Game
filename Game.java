/*****************************************
 * A template for a Nim game
 * Jaewon Lee
 * jl6367
 * My Game Class
 ****************************************/
import java.util.Random;

public class Game {

  // My instance variables
  private int marbles;
  private Human humanPlayer;
  private Computer computerPlayer;
  private int diff;
  private int goFirst;

  // My constructor
  public Game(int difficulty) {
    // Stores difficulty
    diff = difficulty;

    // Determines who goes first
    goFirst = (int) (Math.random() * 2);
    if (goFirst == 1) {
      humanPlayer = new Human();
    } else {
      computerPlayer = new Computer(diff);
    }

    // Prints out what mode the computer is in
    if (diff == 1) {
      System.out.println("The computer is in stupid mode!");
    } else {
      System.out.println("The computer is in smart mode!");
    }
  }

  public void play() {
    // Generates the number of marbles (between 10-100) and prints it.
    // This feeds into my move methods.
    Random rand = new Random();
    marbles = rand.nextInt(100 - 10) + 10;
    System.out.println("The number of of marbles in the randomly generated pile is: " + marbles);

    // Runs when the human goes first and the computer is set to "stupid" mode
    if (goFirst == 1 && diff == 1) {

      // Human goes first here
      System.out.println("You get the first move!");
      humanPlayer.move(marbles);
      computerPlayer = new Computer(diff);

      // My while loop that continues the game so long as there is more than one
      // marble
      while (humanPlayer.getMarbLeft() > 1) {
        computerPlayer.move(humanPlayer.getMarbLeft());

        // Determines when the human loses + prints out dialouge + ends the game
        if (computerPlayer.getMarbLeft() == 1) {
          humanPlayer.move(computerPlayer.getMarbLeft());
          System.out.println("You lost! Better luck next time!");
          break;
        } else {
          humanPlayer.move(computerPlayer.getMarbLeft());

          // Determines when the human wins + prints out dialouge + ends the game
          if (humanPlayer.getMarbLeft() == 1) {
            computerPlayer.move(humanPlayer.getMarbLeft());
            System.out.println("You win! Congratulations!");
          }
        }
      }
    }

    // Runs when the human goes first and the computer is set to "smart" mode
    if (goFirst == 1 && diff == 2) {

      // Human goes first here
      System.out.println("You get the first move!");
      computerPlayer = new Computer(diff);
      humanPlayer.move(marbles);

      // My while loop that continues the game so long as there is more than one
      // marble
      while (humanPlayer.getMarbLeft() > 1) {
        computerPlayer.move(humanPlayer.getMarbLeft());

        // Determines when the human loses + prints out dialouge + ends the game
        if (computerPlayer.getMarbLeft() == 1) {
          humanPlayer.move(computerPlayer.getMarbLeft());
          System.out.println("You lost! Better luck next time!");
          break;
        } else {
          humanPlayer.move(computerPlayer.getMarbLeft());

          // Determines when the human wins + prints out dialouge + loop/game ends
          if (humanPlayer.getMarbLeft() == 1) {
            computerPlayer.move(humanPlayer.getMarbLeft());
            System.out.println("You win! Congratulations!");
          }

        }
      }
    }

    // Runs when the computer goes first and is set to "stupid" mode
    if (goFirst == 0 && diff == 1) {

      // "Stupid" computer goes first here
      System.out.println("The computer gets the first move!");
      computerPlayer.move(marbles);
      humanPlayer = new Human();

      // My while loop that continues the game so long as there is more than one
      // marble
      while (computerPlayer.getMarbLeft() > 1) {
        humanPlayer.move(computerPlayer.getMarbLeft());

        // Determines when the human wins + prints out dialouge + ends the game
        if (humanPlayer.getMarbLeft() == 1) {
          computerPlayer.move(humanPlayer.getMarbLeft());
          System.out.println("You win! Congratulations!");
          break;
        } else {
          computerPlayer.move(humanPlayer.getMarbLeft());

          // Determines when the human loses + prints out dialouge + loop/game ends
          if (computerPlayer.getMarbLeft() == 1) {
            humanPlayer.move(computerPlayer.getMarbLeft());
            System.out.println("You lost! Better luck next time!");
          }
        }
      }
    }

    // Runs when the computer goes first and is set to "smart" mode
    if (goFirst == 0 && diff == 2) {

      // "Smart" computer goes first here
      System.out.println("The computer gets the first move!");
      computerPlayer.move(marbles);
      humanPlayer = new Human();

      // My while loop that continues the game so long as there is more than one
      // marble
      while (computerPlayer.getMarbLeft() > 1) {
        humanPlayer.move(computerPlayer.getMarbLeft());

        // Determines when the human wins + prints out dialouge + ends the game
        if (humanPlayer.getMarbLeft() == 1) {
          computerPlayer.move(humanPlayer.getMarbLeft());
          System.out.println("You win! Congratulations!");
          break;
        } else {
          computerPlayer.move(humanPlayer.getMarbLeft());

          // Determines when the human loses + prints out dialouge + loop/game ends
          if (computerPlayer.getMarbLeft() == 1) {
            humanPlayer.move(computerPlayer.getMarbLeft());
            System.out.println("You lost! Better luck next time!");
          }
        }
      }
    }

  }

}