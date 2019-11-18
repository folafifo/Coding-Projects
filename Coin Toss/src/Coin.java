import java.util.Random;

public class Coin {
	public static final int NUMBER_OF_TOSSES = 10000;
	public static final int VALUE_OF_HEADS = 1;
	public static final int VALUE_OF_TAILS = 0;

	public static void main(String[] args) {
		int count;
		int numberOfHeads = 0;
		int numberOfTails = 0;
		int heads = 0;
		for (count = 0; (count < NUMBER_OF_TOSSES); count++) {
			Random generator = new Random();
			heads = generator.nextInt(2);
			if (heads == VALUE_OF_HEADS) {
				numberOfHeads++;
			} else {
				numberOfTails++;
			}

		}
		System.out.println("The number of heads is " + numberOfHeads);
		System.out.println("The number of tails is " + numberOfTails);
		if (heads == 1) {
			System.out.println("The last toss was Heads.");
		} else {
			System.out.println("The last toss was Tails.");
		}
	}

}
