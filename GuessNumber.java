package com.numbersgame;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		System.out.println("=== Welcome to Guess The Number Game ===");
		System.out.println("I have selected a number between 1 and 25.");
		System.out.println("You have 5 chances to guess it. Good luck!\n");

		//Taking computer Output
		int numberToGuess = random.nextInt(0,25);
		int attempts = 0;
		boolean hasWon = false;

		while (attempts < 5) {
			System.out.print("Enter your guess: ");
			//Taking User Input
			int userGuess = sc.nextInt();
			attempts++;

			if (userGuess == numberToGuess) {
				hasWon = true;
				break;
			} else if (userGuess < numberToGuess) {
				System.out.println("Too low! Try a higher number.\n");
			} else {
				System.out.println("Too high! Try a smaller number.\n");
			}
		}

		if (hasWon) {
			System.out.println("\n🎉 Congratulations! You guessed it in " + attempts + " attempts.");
		} else {
			System.out.println("\n❌ Sorry, you lost! The correct number was " + numberToGuess + ".");
		}

		System.out.println("Thanks for playing! See you next time.");
		sc.close();
	}
}
