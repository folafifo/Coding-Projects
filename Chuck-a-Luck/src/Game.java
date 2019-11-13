/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7].
Comment:  correct definition
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: correct implementation
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5 ].
Comment:uses function to check
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: program does this properly
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:  program does this properly
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: method implements correctly

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: object properly defined
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 0]
Comment: error stops program from completing more than once see line:119
I ask the user to enter any of the four bet types or quit [Mark out of 5: 2].
Comment: quit not specified
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: calls function for each type
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 0]
Comment: program fails

 Total Mark out of 100 (Add all the previous marks): 88
*/

import java.util.Scanner;

public class Game {
	public static  boolean finished = false;
	public static final String FIELD = "field";
	public static final String TRIPLE = "triple";
	public static final String LOW = "low";
	public static final String HIGH = "high";
	public static final char L = 'l';
	public static final char T = 't';
	public static final char H = 'h';
	public static final char F = 'f';

	public static void resolveBet(String betType, Wallet purse) {
		boolean field = false;
		boolean high = false;
		boolean low = false;
		boolean triple = false;
		System.out.println("Current value of the wallet = €" + purse.check());
		Scanner insert = new Scanner(System.in);
		System.out.print("Please enter the value you would like to bet: ");
		if (insert.hasNextDouble()) {
			double betValue = 0.0;

			betValue = insert.nextDouble();
			finished = purse.negative(betValue);
			if (purse.get(betValue)) {
				Dice dice1 = new Dice(6);
				Dice dice2 = new Dice(6);
				Dice dice3 = new Dice(6);
				int topFace1 = dice1.roll();
				int topFace2 = dice2.roll();
				int topFace3 = dice3.roll();
				int total = topFace1 + topFace2 + topFace3;
				if ((topFace1 == topFace2) && (topFace3 == topFace2) && (topFace1 != 1) && (topFace1 != 6)) {
					triple = true;
				}
				if ((total < 8) || (total > 12)) {
					field = true;
				}
				if ((total > 10) && (!((topFace1 == topFace2) && (topFace3 == topFace2)))) {
					high = true;
				}
				if ((total < 11) && (!((topFace1 == topFace2) && (topFace3 == topFace2)))) {
					low = true;
				}
				if ((betType == TRIPLE) && (triple)) {
					betValue = betValue * 30;
					purse.put(betValue);
					System.out.println("Congrats you win!");
				} else if ((betType == FIELD) && (field)) {
					betValue = betValue * 2;
					purse.put(betValue);
					System.out.println("Congrats you win!");
				} else if ((betType == LOW) && (low)) {
					betValue = betValue * 2;
					purse.put(betValue);
					System.out.println("Congrats you win!");
				} else if ((betType == HIGH) && (high)) {
					betValue = betValue * 2;
					purse.put(betValue);
					System.out.println("Congrats you win!");
				} else {
					System.out.println("You lose!");
				}

			}

		} else {
			System.out.println("please");
		}
		insert.close();
	}

	public static void main(String[] args) {
		Wallet wallet = new Wallet();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the amount" + " of money you have to play: ");
		double startingCash = input.nextDouble();
		wallet.put(startingCash);
		String betType = " ";
		String bet = null;
		while (!finished) {
			System.out.println("Please enter your bet type: 'f'=field," + " 't'= triple, 'l'=low and 'h'=high ");
			bet = input.next();
			if (bet.equals("f")) {
				betType = FIELD;
			} else if (bet.equals("h")) {
				betType = HIGH;
			} else if (bet.equals("l")) {
				betType = LOW;
			} else if (bet.equals("t")) {
				betType = TRIPLE;
			}
			resolveBet(betType, wallet);

		}
		input.close();
	}

}
