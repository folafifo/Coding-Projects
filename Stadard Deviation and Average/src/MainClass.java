import java.util.Scanner;
import java.lang.Math;
public class MainClass {

	public static void main(String[] args) {
         Scanner input = new Scanner( System.in );
         System.out.print("Whats is the number a ?");
         double a = input.nextDouble();
         System.out.print("What is the number b ?");
         double b = input.nextDouble();
         System.out.print("What is the number c ?");
         double c = input.nextDouble();
         double d = 3;
         double average = (a + b +c) /d;
         System.out.println("The average of the three numbers is " + average);
         
         double standardDeviation = Math.sqrt((((a + b + c) - average)
        		                                      *((a + b + c) - average)) / d );
         
         System.out.println("The Standard Deviation is " + standardDeviation);
         input.close();
	}

}
