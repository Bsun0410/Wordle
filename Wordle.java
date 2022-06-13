/**Logic class for Wordle game
*
*@author Brittany Sun
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Wordle {
  private ArrayList<String> guesses;
  private Random random;
  private String word;
  private char[][] grid;
  private Scanner scan, fileg;
  private int count;
  private boolean yessir;
  private String[] board;


  /** Creates a 2D array of 6 rows and 5 columns->just like the actual game */
  public Wordle() throws IOException {
    guesses = new ArrayList<>();
    scan = new Scanner(System.in);
    fileg = new Scanner(new File("Words.csv"));
    random = new Random();
    grid = new char[6][5];
    count = 0;
    yessir = false;
    board = new String[26];
    for (int i = 0; i <= 25; i++)
      board[i] = Character.toString((char) (i + 65));
    // Gets a word from csv file as the wordle 
    while (fileg.hasNext()) {
      guesses.add(fileg.next());
    }
    word = guesses.get(random.nextInt(guesses.size())).toUpperCase();
  }
  
  /**
   * Turns the user input to all uppercase and compares to 
the wordle
   *
   * @param guess
   */
  public void guessWord(String guess) {
    for (int i = 0; i <= 4; i++)
      grid[count][i] = guess.toUpperCase().charAt(i);
    count++;
    if (guess.toUpperCase().equals(word))
      yessir = true;
  }

  // Stops the program once the user guesses the maximum amount of times
  public boolean repeat() {
    if (count >= 5)
      return false;
    else if (yessir)
      return false;
    return true;
  }

  // Displays a win/lose message depending on if the user gets the wordle
  public void endGame() {
    if (yessir) {
      Animation program = new Animation();
      try {
        program.animate();
      } catch (Exception e) {
      }
    } else
      System.out.println("Better luck next time!\nThe word was " + word);
  }

  /**
   * Prints the user's guesses and shows colors according to how accurate the guess is
   */
  public void showGuesses() {
    String temp = "";
    for (int row = 0; row <= 5; row++) {
      for (int col = 0; col <= 4; col++) {
        if (grid[row][col] == word.charAt(col)) {
          System.out.print("\u001B[32m");
          temp = board[(int) grid[row][col] - 65];
          board[(int) grid[row][col] - 65] = "\u001B[32m" + temp.substring(temp.length() - 1);
        } else if (word.contains(Character.toString(grid[row][col]))) {
          System.out.print("\u001B[33m");
          temp = board[(int) grid[row][col] - 65];
          if (temp.length() == 1 || !temp.substring(0, 3).equals("\u001B[32"))
            board[(int) grid[row][col] - 65] = "\u001B[33m" + temp.substring(temp.length() - 1);
        } else {
          System.out.print("\u001B[0m");
          if ((int) grid[row][col] != 0) {
            temp = board[(int) grid[row][col] - 65];
            board[(int) grid[row][col] - 65] = "\u001B[90m" + temp;
          }
        }
        System.out.print(grid[row][col] + " ");
      }
      System.out.println("\u001B[0m");
    }
    System.out.println();
  }

  /**
   * Gets the wordle
   * 
   * @return word
   */
  public String getWord() {
    return word;
  }
}