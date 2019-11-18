
import java.util.Scanner;
import java.lang.Math;

public class DateConverter {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	public static final String ENDS_IN_TH = "th";
	public static final String ENDS_IN_ST = "st";
	public static final String ENDS_IN_RD = "rd";
	public static final String ENDS_IN_ND = "nd";
	// Function that outputs what the ending is for different dates eg. "th" ,"rd" 
	public static String numberEnding (int dayNumber) {
		String ending = "";
		if (dayNumber == 1 || dayNumber==21 || dayNumber==31)
		{
			ending = ENDS_IN_ST;
		}
		else if (dayNumber == 2 || dayNumber==22)
		{
			ending = ENDS_IN_ND;
		}
		else if (dayNumber == 3 || dayNumber==23)
		{
			ending = ENDS_IN_RD;
		}
		else
		{
			ending = ENDS_IN_TH;
		}
		return ending;
	}
	// Function to output the month name based on a month number (1-12)
	public static String monthName(int monthNumber) {

		String month = "";
		switch (monthNumber)
		{
		case 1:
			month = "January";
			break;
		case 2: 
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
		}
		return (month);
	}
	// Function to output the day of week based on on date using gaussian algorithm 
	public static String dayOfTheWeek(int day, int month, int year) {
		String dayName = "";
		if (month ==1 || month ==2)
		{
			year = year -1;
		}
		int numberOfDigits =2;
		int firstTwoDigits = Integer.parseInt((""+year).substring(0, numberOfDigits));
		int lastTwoDigits = year % 100;
		double dayOfWeek = (day + Math.floor(2.6*(((month + 9)%12)+1)-0.2)+lastTwoDigits+
				Math.floor(lastTwoDigits/4)+ Math.floor(firstTwoDigits/4) - (firstTwoDigits*2))%7;
		if (dayOfWeek < 0)
		{
			dayOfWeek = dayOfWeek + 7;
		}
		int dayNumber = (int)dayOfWeek;
		switch (dayNumber)
		{
		case 0:
			dayName = "Sunday";
			break;
		case 1:
			dayName = "Monday";
			break;
		case 2:
			dayName = "Tuesday";
			break;
		case 3:
			dayName = "Wednesday";
			break;
		case 4:
			dayName = "Thursday";
			break;
		case 5:
			dayName = "Friday";
			break;
		case 6:
			dayName = "Saturday";
			break;
		default:
		}
		return (dayName);
	}
	// Function to check whether a date is valid or not. Credit to 
	// validDate function from blackboard imperative programming 
	public static boolean validDate( int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	// Function to return the amount of days in particular months including leap years
	//Credit to daysInMonth function from blackboard imperative programming 
	public static int daysInMonth( int month, int year )
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	// Function to check whether a given year is a leap year
	// Credit to isLeapYear function from blackboard imperative programming 
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a date in the format (day/month/year): ");
		String input =scanner.next();
		scanner.close();
		scanner = new Scanner(input);
		scanner.useDelimiter("/");	
		int day = scanner.nextInt();
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		scanner.close();
		boolean validDate = validDate(day,month,year);
		if (validDate)
		{
			String numberEnding = numberEnding(day);
			String monthName = monthName(month);
			String dayOfWeek = dayOfTheWeek(day, month, year);
			System.out.println(dayOfWeek + ", " + day + numberEnding +" "+ monthName + " " + year);
		}
		else 
		{
			System.out.println("Sorry that date is not valid.");
		}
	}

}

