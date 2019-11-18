import java.util.Scanner;
public class Frequency {
	public static int[] initialiseFrequencies(int[]frequencies) {
		int index = 0;
		for (index = 0; index < frequencies.length; index++) {
			frequencies[index] = 0;
		}
		return frequencies;
	}
	public static void countDigitFrequencies(int number,int[]frequencies) {
		int digit=0;
		while (number!=0) {
			digit = number %10;
			number = number / 10;
			switch (digit) {
			case 0:
				frequencies[0] += 1;
				break;
			case 1:
				frequencies[1] += 1;
				break;
			case 2:
				frequencies[2] += 1;
				break;
			case 3:
				frequencies[3] += 1;
				break;
			case 4:
				frequencies[4] += 1;
				break;
			case 5:	
				frequencies[5] += 1;
				break;
			case 6:	
				frequencies[6] += 1;
				break;
			case 7:	
				frequencies[7] += 1;
				break;
			case 8:	
				frequencies[8] += 1;
				break;
			case 9:	
				frequencies[9] += 1;
				break;
			default:	
			}
		}
	}
	public static void printDigitFrequencies(int[]frequencies) {
		System.out.print("Digit frquencies: ");
		for (int index = 0; index < frequencies.length; index++) {
			if (frequencies[index] != 0) {
			System.out.print(index + "("+frequencies[index] + ") ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int []frequencies = new int[10];
		frequencies = initialiseFrequencies(frequencies);
		System.out.print("Enter a positive number: ");
		boolean finished = false;
		while ((input.hasNext("quit")||(input.hasNextInt()))&&(!finished)) {
			if (input.hasNextInt()) {
			int number = input.nextInt();
			countDigitFrequencies(number, frequencies);
			printDigitFrequencies(frequencies);
			System.out.print("\rEnter a positive number (or type 'quit'): ");
			}
			else if(input.hasNext("quit")) {
				System.out.println("Goodbye!");
				finished = true;
			}
		}
		if (!input.hasNext("quit")&&(!input.hasNextInt())) {
			System.out.println("Sorry Invalid input.");
		}
		input.close();
	}

}
