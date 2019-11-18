import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int divisor = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a positive whole number: ");
		if (input.hasNextInt())
		{
			int number = input.nextInt();
			input.close();
			System.out.print("The factors of " + number + " are ");
			for (int count = 1; (count < number); count++) {

				if (number % count == 0) {
					 divisor = count;
					int divisor2 = number / count;
					if (divisor <= divisor2) {
						System.out.print(divisor + "x" + divisor2 + ", ");
					}
                    
				}
			}
			if (divisor==1)
			{
				System.out.println( "\r" +number +" is a prime number.");
			}
		}
		else 
		{
			System.out.println("Invalid input.");
		}
	}
}