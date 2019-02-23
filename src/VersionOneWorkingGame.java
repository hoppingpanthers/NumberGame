import java.util.Scanner;
import java.util.Random;

/**
 * Game for 1-3 players with numbers.
 * 
 * @author Sam
 * @version 20190127
 *
 */
public class VersionOneWorkingGame {

	public static void main(String[] args) {

		// Creates a string and an int for user input, then makes a Scanner
		// This is outside of the while loop so that the user input is not added to a
		// new string each loop
		String usrStr = "";
		int usrInt;
		Scanner usrInpt = new Scanner(System.in);

		// Prompts user
		System.out.print("Hi would you like to play a game? ");
		usrStr = usrInpt.next();

		// Creates an if statement wherein the code will decide whether to run the game
		if (usrStr.equalsIgnoreCase("yes")) {
			System.out.println("Great!");

			// Creates a while statement that will run the code inside of it and makes a GUI
			while (!usrStr.equalsIgnoreCase("exit")) {
				System.out.println(
						"\nWelcome to Sam's Number Challenge! Please select how many friends you have to play with: "
								+ "\n1) None, it's just me" + "\n2) One friend" + "\n3) Two friends!" + "\n4) Exit");
				usrStr = usrInpt.next();
				usrInt = Integer.parseInt(usrStr);
				switch (usrInt) {

				// Single player game
				case 1:
					String usrStrCase1 = null;
					// While loop within single player game decides whether to play game, see
					// instructions or go back to main menu
					while (!usrStr.equalsIgnoreCase("go to main")) {
						System.out.println();
						System.out.println("You have selected a single player game. Your game will begin now.");
						System.out.println("Please select an option" + "\n1) See Instructions" + "\n2) Play Game"
								+ "\n3) Return to Main Menu");
						usrStrCase1 = usrInpt.next();

						usrInt = Integer.parseInt(usrStrCase1);
						switch (usrInt) {
						// See Instructions
						case 1:
							// Displays instructions
							while (!usrStr.equalsIgnoreCase("back")) {
								System.out.println();
								System.out.println("You will be playing against the computer."
										+ "\nYou will be asked to input several digits."
										+ "\nDepending on the number's relation to the computer's number, you will gain or lose points.");
								System.out.println("Here are the rules:"
										+ "\n1) Three rounds will occur. The player who ends the game with the highest number of points wins"
										+ "\n2) Each round, you will enter a number between 0-100"// Done
										+ "\n3) The player with the larger number will get 5 points" // Done
										+ "\n4) The player with the smaller number will lose 1 point"
										+ "\n5) If the bigger number is 20 larger than the smaller number, the person with the bigger number loses 3 points and gains no points" // Done
										+ "\n6) If the smaller number is five or less smaller than the bigger number, the player with the smaller number gets 6 points"
										+ "\n7) If the bigger number is exactly 69 points larger than the smaller number, the person with the bigger number gets 30 points"
										+ "\n8) If the numbers are the same, both players lose 1 point" // Done
										+ "\n Type \"Back\" to return to main menu");
								usrStr = usrInpt.next();
							}
							break;
						// Contains single player game
						case 2:
							// Creates arrays for usrScores and compScores
							int[] usrScores = new int[3];
							int[] compScores = new int[3];

							while ((usrScores[0] >= 0 && usrScores[0] <= 100)
									&& (usrScores[1] >= 0 && usrScores[1] <= 100)
									&& (usrScores[2] >= 0 && usrScores[2] <= 100)) {
								System.out.println("Game creation in progress, please be patient");
								System.out.println();
								// Random created, and the computer's numbers are all created
								// Seed can be entered for testing purposes **REMOVE AFTER TESTING**
								System.out.println("Please enter a seed if you are a tester"); // FIXME: REMOVE AFTER
																								// TESTING
								int testSeed = usrInpt.nextInt();
								Random compNum = new Random(testSeed); // FIXME: take out (testSeed) when game is done
																		// testing
								int firstNum = compNum.nextInt(101);
								int secNum = compNum.nextInt(101);
								int thirdNum = compNum.nextInt(101);

								// The computer numbers are printed for testing purposes
								System.out.println(firstNum);
								System.out.println(secNum);
								System.out.println(thirdNum);// FIXME get rid of this after testing

								// User and computer scores created at zero (no points earned yet)
								int usrScore = 0;
								int compScore = 0;

								// User prompted for their First Number, it is stored
								System.out.println("Please enter your first number (Between 0-100)");
								usrScores[0] = usrInpt.nextInt();

								// Ensures that the number is between 0 and 100

								if ((usrScores[0] <= 100) && (usrScores[0] >= 0)) {

									// User's number is compared to computers first number, points are assigned

									// Picks out the bigger number
									int bigger = Math.max(firstNum, usrScores[0]);
									int smaller = Math.min(firstNum, usrScores[0]);
									System.out.println(bigger); // FIXME maybe delete this as well afterwards

									// Takes away one point from each if the numbers are the same
									if (usrScores[0] == firstNum) {
										usrScore = usrScore - 1;
										compScore = compScore - 1;
									}

									// Gives five points to bigger number
									// Doesn't give those points if the bigger number is exactly 69 greater
									// Doesn't give those points if the numbers are the same
									if ((bigger == usrScores[0]) && !((usrScores[0] - firstNum) == 69)
											&& (usrScores[0] != firstNum)) {
										usrScore = usrScore + 5;
									} else if ((bigger == firstNum) && !((usrScores[0] - firstNum) == 69)
											&& (usrScores[0] != firstNum)) {
										compScore = compScore + 5;
									}

									// Takes away points from higher number person if lower number is within 20
									// points of higher number
									if ((usrScores[0] == bigger) && (usrScores[0] - firstNum) <= 20) {
										usrScore = usrScore - 8;
									} else if ((usrScores[0] == smaller) && (firstNum) <= 20) {
										compScore = compScore - 8;
									}

									// Takes 1 point from smaller number
									if (usrScores[0] == smaller && (firstNum - usrScores[0]) != 5) {
										usrScore = usrScore - 1;
									} else if (compScore == smaller && (usrScores[0] - firstNum) != 5) {
										compScore = compScore - 1;

										// If smaller number is five or less smaller than the large number, the player
										// with the small number gets 6 points
										if (usrScores[0] == bigger && (usrScores[0] - firstNum) == 5) {
											compScore = compScore + 6;
										} else if (firstNum == bigger && (firstNum - usrScores[0]) == 5) {
											usrScore = usrScore + 6;
										}

										// FIXME Add in the rest of the rules for the game

										// FIXME print computer's number
										System.out.println(usrScore + " " + compScore);
									} else {
										System.out.println();
										System.out.println("Please try again. Enter a number between 0 and 100");

									}
								}
							}
							break;
						// Takes the player to the main menu
						case 3:
							usrStr = "go to main";
							break;
						}
					}

					// Two player game
					// FIXME : two player game finish
				case 2:

					// While loop within two player game decides whether to play game, see
					// instructions or go back to main menu
					while (!usrStr.equalsIgnoreCase("go to main")) {
						System.out.println("You have selected a two player game. Your game will begin now.");
						System.out.println("Please select an option" + "\n1) See Instructions" + "\n2) Play Game"
								+ "\n3) Return to Main Menu");

					}
					break;

				// Three player game
				// FIXME : Three player game finish
				case 3:
					System.out.println("You have selected a three player game. Your game will begin now.");
					System.out.println("Please select an option" + "\n1) See Instructions" + "\n2) Play Game"
							+ "\n3) Return to Main Menu");
					// While loop within three player game decides whether to play game, see
					// instructions or go back to main menu
					while (!usrStr.equalsIgnoreCase("go to main")) {

					}
					break;
				// Exit game
				case 4:
					usrStr = "exit";
				default:
					System.out.print("\nNot an option!");
				}
			}
		} else {
			System.out.println("You did not say yes. Goodbye.");
		}
		usrInpt.close();
	}
}
