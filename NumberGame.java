
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int highScore = 0;
        char playAgain;

        System.out.println("==================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("==================================");
        System.out.println("Guess the secret number!");
        System.out.println("Choose your difficulty level.");

        do {

            System.out.println("\n1. Easy (10 attempts)");
            System.out.println("2. Medium (5 attempts)");
            System.out.println("3. Hard (3 attempts)");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            int attempts;

            if (choice == 1) {
                attempts = 10;
            } else if (choice == 2) {
                attempts = 5;
            } else if (choice == 3) {
                attempts = 3;
            } else {
                System.out.println("Invalid choice! Medium selected.");
                attempts = 5;
            }

            int secretNumber = random.nextInt(100) + 1;
            int guess = 0;
            boolean won = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts.");

            for (int i = 1; i <= attempts; i++) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                    i--;
                    continue;
                }

                guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100!");
                    i--;
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.println("\nCongratulations! You won!");

                    int points = (attempts - i + 1) * 10;
                    score += points;

                    System.out.println("Points earned: " + points);
                    won = true;

                    if (i <= 2) {
                        System.out.println("Excellent guessing!");
                    } else if (i <= 4) {
                        System.out.println("Great job!");
                    } else {
                        System.out.println("Well played!");
                    }

                    break;

                } else if (guess > secretNumber) {
                    System.out.println("Too High! Try smaller.");
                } else {
                    System.out.println("Too Low! Try bigger.");
                }

                System.out.println("Attempts remaining: " + (attempts - i));
            }

            if (!won) {
                System.out.println("\nGame Over!");
                System.out.println("Correct number was: " + secretNumber);
            }

            if (score > highScore) {
                highScore = score;
            }

            System.out.println("\nCurrent Score: " + score);
            System.out.println("Highest Score: " + highScore);

            System.out.print("\nPlay again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n==================================");
        System.out.println("          GAME SUMMARY");
        System.out.println("==================================");
        System.out.println("Final Score: " + score);
        System.out.println("Highest Score: " + highScore);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
