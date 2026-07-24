import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";
        int round = 1;
        while (playAgain.equalsIgnoreCase("yes")) {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempt = 0;
            boolean guessed = false;
            System.out.println("\n===== Round " + round + " =====");
            System.out.println("Guess the number between 1 and 100");
            while (attempt < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempt++;
                if (guess > number) {
                    System.out.println("Too High!");
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempt + " attempts.");
                    guessed = true;
                    break;
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempt));
            }

            if (!guessed) {
                System.out.println("You Lost!");
                System.out.println("Correct Number was: " + number);
            }

            System.out.println("Round " + round + " Summary:");
            if (guessed) {
                System.out.println("Guessed in " + attempt + " attempts.");
            } else {
                System.out.println("Failed to guess.");
            }

            System.out.print("\nPlay Again? (yes/no): ");
            playAgain = sc.next();

            round++;
        }

        System.out.println("Thanks for Playing!");
        sc.close();
    }
}