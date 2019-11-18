
import java.util.Scanner;
import java.util.Random;

public class HiLo {
	public static final int MAX = 13;
	public static final int MIN = 1;
	public static final int MAX_NUMBER_OF_TURNS = 4;

	public static void main(String[] args) {
		int count = 0;
		Random number = new Random();
		int card = MIN + number.nextInt(MAX);
		boolean finished = false;
		boolean end = false;
		while (count < MAX_NUMBER_OF_TURNS && !finished && !end) {
			Scanner input = new Scanner(System.in);
			int prevCard = card;
			if ((card < 2) || (card > 10)) {
				if (card == 1) {
					System.out.println("The card is an Ace ");
				} else if (card == 11) {
					System.out.println("The card is a Jack ");
				} else if (card == 12) {
					System.out.println("The card is a Queen ");
				} else if (card == 13) {
					System.out.println("The card is a King ");
				}
			} else {
				System.out.println("The card is a " + card);
			}
			System.out.print("Do you think the next card"
					+ " will be higher, lower or equal? ");
			if ((!input.hasNext("lower")) && (!input.hasNext("higher"))
					&& (!input.hasNext("equal"))) {
				System.out.println("Sorry, Invalid input.");
				end = true;
				finished = true;
			}
			if (input.hasNext("lower")) {
				card = MIN + number.nextInt(MAX);
				if (card < prevCard) {
					finished = false;
				} else {
					finished = true;
				}
			} else if (input.hasNext("higher")) {
				card = MIN + number.nextInt(MAX);
				if (card > prevCard) {
					finished = false;
				} else {
					finished = true;
				}

			} else if (input.hasNext("equal")) {
				card = MIN + number.nextInt(MAX);
				if (card == prevCard) {
					finished = false;
				} else {
					finished = true;
				}

			}
			count++;
		}
		if (!end) {
			if (count < MAX_NUMBER_OF_TURNS) {
				System.out.println("Sorry, that's incorrect. \rBetter luck next time!");
			} else {
				System.out.println("Congratulations. You got them all correct.");
			}

		}
		
	}
}
