import java.util.Random;
import java.util.Scanner;

public class  task1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 1;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 5 attempts to guess the correct number between 1 and 100.");
        
        boolean playAgain = true;
        
        while (playAgain) {
            // Generate a random number
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ":");
            
            // Attempt loop
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Guess the number (1-100): ");
                int guess = scanner.nextInt();
                
                // Validate input
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;
                
                // Compare guess with the number
                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            // Ask if the player wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
            
            rounds++;
        }

        System.out.println("Game over! Your final score is " + score + " out of " + (rounds - 1) + " round(s).");
        scanner.close();
    }
}
