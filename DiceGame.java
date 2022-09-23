/*
* This program is a dice guessing game.
*
* @author  Aidan Lalonde-Novales
* @version 1.0
* @since   2020-09-22
*/

import java.util.Scanner;

/**
* This is a dice guessing game.
*/
final class DiceGame {

    /**
    * Constant assigned to 1.
    */
    public static final int MIN = 1;

    /**
    * Constant assigned to 6.
    */
    public static final int MAX = 6;

    /**
    * Constant assigned to 0.
    */
    public static final int TOO_LOW = 0;

    /**
    * Constant assigned to 7.
    */
    public static final int TOO_HIGH = 7;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private DiceGame() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        int counter = 1;
        int guessedNumber = 0;

        System.out.println("Welcome to the Dice Game!");

        // Generate random number from 1 to 6
        final int randomNumber = (int) (Math.random() * MAX + MIN);

        while (true) {
            try {
                // Input
                System.out.println("");
                final Scanner guessObj = new Scanner(System.in);
                System.out.println("Guess a number from 1 to 6: ");
                guessedNumber = guessObj.nextInt();

                // Process
                if (guessedNumber == randomNumber) {
                    break;
                } else if (
                    guessedNumber < randomNumber & guessedNumber > TOO_LOW
                ) {
                    counter++;
                    System.out.println("\nIncorrect. The number is higher!");
                } else if (
                    guessedNumber > randomNumber & guessedNumber < TOO_HIGH
                ) {
                    counter++;
                    System.out.println("\nIncorrect. The number is lower!");
                } else {
                    counter++;
                    System.out.println(
                        "\nInvalid Input. "
                        + "Please make sure you are using numbers 1-6."
                    );
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println(
                    "\nInvalid Input. Please enter an Integer."
                );
            }
        }

        // Output
        System.out.println("\nYou Guessed Correctly! Tries: " + counter);

        System.out.println("\nDone.");
    }
}

