

import java.util.Scanner;

public class MainClass {
	public static final int NEW_PENNIES_PER_OLD_PENNY = 67;
	public static final int OLD_SHILLING_PER_OLD_PENNY = 12;
	public static final int OLD_POUND_PER_OLD_SHILLING = 20;
	public static final int NEW_POUND_PER_NEW_PENNY = 100;

	public static void main(String[] args) {
	
		
		Scanner input = new Scanner(System.in);
		System.out.print("Number of old pounds?");
		double oldPounds = input.nextDouble();
		System.out.print("Number of old Shillings?");
		double shillings = input.nextDouble();
		System.out.print("Number of old Pennies?");
		double oldPennies = input.nextDouble();
		double a = oldPounds * OLD_POUND_PER_OLD_SHILLING;
		double b = a * OLD_SHILLING_PER_OLD_PENNY;
		double c = shillings * OLD_SHILLING_PER_OLD_PENNY;
		double totalOldPennies = b + c + oldPennies;
		double totalNewPennies = totalOldPennies * NEW_PENNIES_PER_OLD_PENNY;
		double newPounds = totalNewPennies / NEW_POUND_PER_NEW_PENNY;
		System.out.println("The modern value of your money is £" + newPounds);
		input.close();
	}

}
