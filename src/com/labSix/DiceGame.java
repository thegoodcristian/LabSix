package com.labSix;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	//I create a method called roll
	//This determined a random number within the range of 1 <= numOfSides input by the user
	
	public static int roll(int numOfSides) {

		//I import the random class to utilize its pseudo-random functionality
		//I initialize a result variable and set the range to exclude 0 from each roll
		
		Random generator = new Random();
		int result = (generator.nextInt(numOfSides - 1 + 1) + 1);
		return result;
	}

	//I create a method called win
	//This determines the statement printed to the console based on each random number generated
	
	public static void win(int dieOne, int dieTwo) {

		if ((dieOne + dieTwo == 2) || (dieOne + dieTwo == 3)) {
			System.out.println("Craps :(");
		} else if ((dieOne + dieTwo) == 12) {
			System.out.println("Craps and boxcars :( Time to catch the train out of here!");
		} else if (((dieOne + dieTwo) == 4) || ((dieOne + dieTwo) == 5) || ((dieOne + dieTwo) == 6)
					|| ((dieOne + dieTwo) == 7) || ((dieOne + dieTwo) == 8) || ((dieOne + dieTwo) == 9)
					|| ((dieOne + dieTwo) == 10) || ((dieOne + dieTwo) == 11)){
			System.out.println("You're a winner, baby!");
		}

	}

	//In my main method, I create a scanner object and set the code in a while loop so the user can decide whether or not to continue.
	//I prompt the user to enter a number of sides for their dice and call the roll method to determine pseudo-random numbers based on that input.
	//After printing those pseudo-random numbers to the screen, I call the win method.
	//I then print those results to the screen as well.
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String cont = "yes";

		while (cont.equalsIgnoreCase("yes")) {

			System.out.println("Howdy partner! Welcome to the Casino of Many Faces!" + "\n~Where players come to win~"
					+ "\n\nHere are the rules for our craps game using 6-sided dice:"
					+ "\n1. Roll a 12, 2, or 3, and that's craps. Too bad for you."
					+ "\n2. Roll any other number and you're a winner! The odds are in your favor." 
					+ "\n\nHere you can choose however many sides you'd like your dice to have if 6 doesn't suit you."
					+ "\nIf you dare, choose a number of sides:");
			int numberOfSides = scnr.nextInt();

			int dieOne = roll(numberOfSides);
			int dieTwo = roll(numberOfSides);

			System.out.println("\nRoll one:\n" + dieOne);
			System.out.println(dieTwo);

			win(dieOne, dieTwo);

			// I ask if the user if they would like to continue, if "yes", while loop will
			// begin again.

			System.out.println("\nDo you want to continue? (yes/no)");
			cont = scnr.next();

		}

		// Otherwise, I bed farewell to the user. I close the scanner to avoid resource
		// leak.

		System.out.println("Goodbye!");
		scnr.close();
	}

}
