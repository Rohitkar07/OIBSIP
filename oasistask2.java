import java.util.Random;
import java.util.Scanner;

public class oasistask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minRange = 1; // Minimum value 
        int maxRange = 100; // Maximum value 
        int maxAttempts = 5; // Maximum number of attempts allowed
        int score = 0; // Player's score

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        boolean isGuessed = false;
        int attempt = 0;

        while (!isGuessed && attempt < maxAttempts)
	{
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ": ");
            int guess = scanner.nextInt();
            attempt = attempt + 1;

            if (guess == randomNumber) {
                isGuessed = true;
                score += (maxAttempts - attempt + 1) * 10; 
                System.out.println("Congratulations!!!");
		System.out.println("You guessed the correct number in " + attempt + " attempt/attempts.");
                System.out.println("Your score is : " + score);
            } else if (guess < randomNumber) 
	    {
                System.out.println("OH NO!!! Wrong guess, The number is higher. Attempts remaining: " + (maxAttempts - attempt));
            }
	      else
	    {
                System.out.println("OH NO!!! Wrong guess, The number is lower. Attempts remaining: " + (maxAttempts - attempt));
            }
        }

        if (!isGuessed)
	{
            System.out.println("Game over! You are done with all your chances");
            System.out.println("The number was: " + randomNumber);
	    System.out.println(" BETTER LUCK NEXT TIME :) ");
        }

        scanner.close();
    }
}
