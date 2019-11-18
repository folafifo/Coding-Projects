import java.util.Scanner;
public class Hours {
public static final int MINUTES_PER_HOUR = 60;
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
     System.out.print("What is your hourly pay in euros per hour: ");
     double hourlyPay = input.nextDouble();
     System.out.print("Enter the amount of hours worked: ");
     double hoursWorked =input.nextDouble();
     System.out.print("Enter the amount of minutes worked on top of hours: ");
     double minutesWorked = input.nextDouble();
     double totalTimeWorked = (minutesWorked / MINUTES_PER_HOUR) + hoursWorked;
     double grossPay = totalTimeWorked*hourlyPay;
      input.close();
     System.out.println("You are entitled to be paid €" + grossPay);
	}

}
