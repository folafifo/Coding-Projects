

 
import java.util.Scanner;

public class AverageAndVariance {

	public static void main(String[] args) {
		int count = 1;
		double prevAverage = 0;
		double prevVariance = 0;
		double newAverage;
		double prevNumber = 0;
		double variance = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		do {

			double number = input.nextDouble();
			double firstAverage = (number + number) / 2;
			newAverage = firstAverage;
			if (count <= 1) 
			{

				prevAverage = firstAverage;
			} 
			else 
			{
				newAverage = prevAverage + (number - prevAverage) / count;

				variance = (((prevVariance * prevNumber) + (number - prevAverage)
						       * (number - newAverage))) / count;
				prevAverage = newAverage;
			}

			if (newAverage == number)
			{
				System.out.println("So far the avearge is " + firstAverage
						+ " and the variance is " + prevVariance);

			} 
			else 
			{
				System.out.println("So far the average is " + newAverage 
						+ " and the variance is " + variance);
			}
			count++;
			prevNumber = number;
			prevVariance = variance;
			System.out.print("Enter another number (or type exit): ");
		} while (input.hasNextDouble());
		input.close();
		System.out.println("Goodbye!");
	}
}
