package Codsoft_Internship;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 1000;

  public static void main(String[] args) {
    NumberGuessingGame game = new NumberGuessingGame();
    game.startGame();
  }

  public void startGame() {
    boolean isUserGuessCorrect = false;
    int numberOfGuesses = 0;
   
    int computerNumber = getNumberByComputer();

    
    while (!isUserGuessCorrect) {
      int userNumber = getUserGuessedNumber();
      if (userNumber > computerNumber) {
        System.out.println("Sorry, the number you guessed is too high");
      } else if (userNumber < computerNumber) {
        System.out.println("Sorry, the number you guessed is too low");
      } else if (userNumber == computerNumber) {
        System.out.println("Congratulations! Your guess is correct!");
        isUserGuessCorrect = true;
      }
      numberOfGuesses++;
    }
    System.out.println("You found the number in " + numberOfGuesses + " guesses");
  }

  public int getNumberByComputer() {
    return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
  }

  public int getUserGuessedNumber() {
    Scanner obj = new Scanner(System.in);
    System.out.println("Please guess the number: ");
    return obj.nextInt();
  }
}
