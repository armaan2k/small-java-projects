	import java.util.Scanner;
	import java.util.Random;
public class Pig_Game {

	// Name: Armaan Merchant   Student Number: 20047267  Net ID: 16AM122
	


//main runs the while loop for the gaming winning parameters and holds the final score variables
	public static void main(String[] args) {

		int PlayerTotal = 0;
		int CompTotal = 0;
		int RoundNumber = 0;

		System.out.println("welcome to the Game of Pig!");
		System.out.println();

		while (PlayerTotal <= 100 || CompTotal <= 100) {
			System.out.println("-----------------------------------------------------------------------------------------------------");
			RoundNumber += 1;
			System.out.println("ROUND " + RoundNumber);
			System.out.println();

			PlayerTotal = PlayerTurn(PlayerTotal);
			System.out.println();

			CompTotal = CompTurn(CompTotal);
			System.out.println();
			System.out.println("Player score is " + PlayerTotal + ", Computers Score is " + CompTotal);
			System.out.println();
		}


	}



	// method to generate number from 1 to 6. Returns said number
	public static int RanGen() {

		Random rand = new Random();			//created a variable rand to call Random
		int Num1 = rand.nextInt(6)+1;		//created a variable to store the number
		return Num1;
	}


	//Pig method simulates the dice roll for both die and calculates the the subsequent score
	public static int Pig() {

		int dice1 = RanGen();
		int dice2 = RanGen();

		System.out.println("Dice Rolled: " + NumToWord(dice1) + " + "  + NumToWord(dice2));


		if((dice1 == 6 || dice2 == 6) && (dice1 != dice2)) {
			return 0;

		} else if (dice1 == 6 && dice2 ==6) {
			return -1;

		} else if (dice1 == dice2) {
			return (dice1 + dice2)*2;

		} else {
			return (dice1 + dice2);
		}

	}



		/*
		 * player turn is a method for running 1 whole turn for a player including
		 * losing conditions and the option to continue playing the turn
		 */
	public static int PlayerTurn (int PlayerScore) {
		int PlayerResult = 3;

		String Continue = "y";
		Scanner input = new Scanner(System.in);

		System.out.println("Players turn:");

		while (Continue.equals("y") && PlayerResult != 0 && PlayerResult != -1 && PlayerScore <= 100) {

			PlayerResult = Pig();
			if (PlayerResult == -1) {
				PlayerScore = 0;
				System.out.println("Ouch, double sixes ");
			} else {
				PlayerScore = PlayerScore + PlayerResult;
				System.out.println("Turn Score: " + PlayerScore);
			}
			if (PlayerResult > 0) {
				System.out.println("Do you want to keep going? Enter 'y' or 'n' ");
				Continue = input.nextLine();
			}

		}

		return PlayerScore;
	}



	/*
	 * CompTurn Simulates one turn for the computer including the losing conditions and the condition
	 * to stop when the computer accumulates 30 or more points
	 */
	public static int CompTurn (int CompScore) {

		int CompResult = 3;
		int CompTurnScore = 0;

		System.out.println("Computers turn:");

		while (CompTurnScore < 30 && CompResult != 0 && CompResult != -1) {

			CompResult = Pig();
			if (CompResult == -1) {
				CompTurnScore = 0;
				System.out.println("Ouch, double sixes ");
			} else {
				CompTurnScore = CompTurnScore + CompResult;
				System.out.println("Current score = " + CompTurnScore);
			}

		}
		System.out.println("End of Computers Turn");
		CompScore = CompScore + CompTurnScore;
		return CompScore;
	}


	//a method to turn the numbers 1 to 6 into the equivalent word
		public static String NumToWord(int n) {

			int[] numArray = {1,2,3,4,5,6};
				String[] wordArray = {"one","two","three","four","five","six"};

				for (int i = 0; i < 7; i++) {
					if (n == i) {
						return wordArray[i-1];
					}
				}
				String error= "error";
				return error;
	}

}
