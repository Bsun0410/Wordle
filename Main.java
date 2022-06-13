/**
* Main runner class
*
* @author Brittany Sun
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Welcomes the user to the wordle and starts program.
 */

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    Wordle start = new Wordle();
    String guess;
    String[] fun = {"\nQuote of the day: The sky is the limit", "\nQuote of the day: Words can't describe how awesoome you are", "\nQuote of the day: You're wordleful", "\nQuote of the day: Have a nice day!"};
    int lengthFun = fun.length;
    int randomNum = (int)Math.random()*lengthFun;
    System.out.println(fun[randomNum]);

    System.out.println("\n\nWelcome to Wordle!\n\nYou have five tries to guess the seccret word. Green means the letter of your guess is in the correct spot. Yellow means the letter is in the secret word but not at the right spot. Otherwise, the color remains unchanged.\n\nGood Luck!!\n\n\n ");

    while (start.repeat()) {
      System.out.print("Enter your guess: ");
      guess = scan.next();
      if (guess.length() < start.getWord().length() || guess.length() > start.getWord().length()) {
        System.out.println("Please enter a 5-letter word");
        System.out.print("Enter your guess: ");
        guess = scan.next();
      }
      start.guessWord(guess);
      start.showGuesses();
      start.showGuesses();
    }
    start.endGame();
  }
}
