import java.util.Scanner;
public class Numbers {

	public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a list of numbers seperated by spaces and type exit once complete:");
    int maxNumber = Integer.MIN_VALUE;
    int minNumber = Integer.MAX_VALUE;
    while (input.hasNextInt())
    {
    	int number = input.nextInt();
    	 
    	if (number > maxNumber)
    	{
    		 maxNumber = number;
    	}
    	if (number < minNumber)
    	{
    		 minNumber = number;
    	}
    	
    }
    System.out.println( "The Greatest number is " + maxNumber);
    System.out.println( "The Smallest number is " + minNumber);
    input.close();
	}

}
