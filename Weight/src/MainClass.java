import java.util.Scanner;

public class MainClass {
	public static final double KG_PER_OUNCE = 0.02834952;
	public static final int OUNCES_PER_POUND = 16;
	public static final int POUNDS_PER_STONE = 14;

	public static double convertToKilograms(int stones, int pounds, int ounces) {
		int totalPounds = stones * POUNDS_PER_STONE;
		totalPounds = totalPounds + pounds;
		int totalOunces = totalPounds * OUNCES_PER_POUND;
		totalOunces = totalOunces + ounces;
		double weightInKg = totalOunces * KG_PER_OUNCE;
		return (weightInKg);
	}

	public static String getFormattedWeightString(int stones, int pounds, int ounces) {
		double weightInKg = convertToKilograms(stones, pounds, ounces);
		String weight = "";
		if (stones == 1) {
			weight = "1 stone, ";
		} else {
			weight = stones + " stones,";
		}
		if (pounds == 1) {
			weight = weight + "1 pound, ";
		} else {
			weight = weight + pounds + " pounds, ";
		}
		if (ounces == 1) {
			weight = weight + "1 ounce, ";
		} else {
			weight = weight + ounces + " ounces, ";
		}
		weight = weight + " is equal to " + weightInKg + "kg.";
		return (weight);
	}

	public static void main(String[] args) {
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Stones, Pounds and " + "Ounces separeted by spaces (or enter quit): ");
		while ((input.hasNextInt()) || (input.hasNext("quit")) && (!finished)) {
			if (input.hasNextInt()) {
				int stones = input.nextInt();
				int pounds = input.nextInt();
				int ounces = input.nextInt();
				String weightFormatted = getFormattedWeightString(stones, pounds, ounces);
				System.out.println(weightFormatted);
				System.out.print(
						"Enter the number of Stones, Pounds and " + "Ounces separeted by spaces (or enter quit): ");
			} else if (input.hasNext("quit")) {
				System.out.println("Goodbye!");
				finished = true;
			}

		}
		if ((!input.hasNextInt()) && (!input.hasNext("quit"))) {
			System.out.println("Invalid input.");
		}
		input.close();
	}

}
