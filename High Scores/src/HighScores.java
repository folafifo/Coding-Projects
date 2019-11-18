
import java.util.Scanner;

public class HighScores {
	public static int[] insertScore(int[] scores, int newScore) {
		boolean scoreChanged = false;
		int index = 0;
		for (index = 0; (index < scores.length) && (!scoreChanged); index++) {
			if (newScore > scores[index]) {
				for (int index2 = index; index2 < scores.length - 1; index2++) {
					
					if (scores[index2] != 0) {
						int temp = scores[index2];
						scores[index + 1] = temp;
					}

					scores[index] = newScore;
					scoreChanged = true;
				}
			}
		}
		return scores;
	}

	public static boolean higherThan(int[] scores, int newScore) {
		int index = 0;
		boolean isHigher = false;
		for (index = 0; index < scores.length; index++) {
			if (newScore > scores[index]) {
				isHigher = true;
			}
		}
		return (isHigher);
	}

	public static void printHighScores(int[] scores) {
		System.out.print("The high scores are ");
		for (int index = 0; index < scores.length; index++) {
			System.out.print(scores[index] + ", ");
		}
	}

	public static int[] initialiseHighScores(int[] scores) {
		int index = 0;
		for (index = 0; index < scores.length; index++) {
			scores[index] = 0;
		}
		return scores;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of high scores you would like to keep: ");
		int numberOfHighScores = input.nextInt();
		int[] scores = new int[numberOfHighScores];
		scores = initialiseHighScores(scores);
		System.out.print("Please enter the first score: ");
		do {

			int newScore = input.nextInt();
			boolean higherThan = higherThan(scores, newScore);
			if (higherThan) {
				scores = insertScore(scores, newScore);
			}
			printHighScores(scores);
			System.out.print("\rPlease enter the next score: ");

		} while (input.hasNextInt());
		input.close();
	}

}
