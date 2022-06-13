/**Celebration screen for getting the Wordle
*
*@author Brittany Sun
*/ 

public class Animation {
  private final String BLUE = "\u001B[36m";
  private final String WHITE = "\u001B[37m";
    private final String RED = "\u001B[31m";

  public String name;

  public Animation() {
  }
/** Displays celebration*/
  public void animate() throws InterruptedException {
    System.out.println("You guessed the wordle!");
    Thread.sleep(1000);
    clearScreen();

    
    clearScreen();
    System.out.print(WHITE);
    System.out.println("\n/(o-o)/");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(RED);
    System.out.println("\n|(o_o)|");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(BLUE);
    System.out.println("\n-(o-o)-");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(RED);
    System.out.println("\n|(o_o)|");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(WHITE);
    System.out.println("\n/(o-o)/");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(RED);
    System.out.println("\n|(o_o)|");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(BLUE);
    System.out.println("\n-(o-o)-");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(RED);
    System.out.println("\n|(o_o)|");
    Thread.sleep(500);
    clearScreen();

    clearScreen();
    System.out.print(WHITE);
    System.out.println("\n/(o-o)/");
    Thread.sleep(500);

  }
/** Clears screen*/
  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}