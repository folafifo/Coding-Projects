
import java.lang.Math;

public class SquareAge {
	public static final int MAX_AGE = 123;
	public static final int MIN_AGE = 0;
	public static final int MAX_YEAR = 2141;
	public static final int MIN_YEAR = 1895;
    public static final int TODAY = 2018;
	public static void main(String[] args) 
	{
		int age;
		for (age = MIN_AGE; (age <= MAX_AGE) && (age >= MIN_AGE); age++)
		{
			int squareOfAge = age * age;
			if ((squareOfAge <= MAX_YEAR) && (squareOfAge >= MIN_YEAR)) 
			{
				int lifePossibility = squareOfAge - age;
				if ((lifePossibility >= MIN_YEAR) && (lifePossibility <= TODAY))
				{
					double ageRequired = Math.sqrt(squareOfAge);
					int realAgeRequired = (int) ageRequired;
					System.out.println("A person alive today aged " + realAgeRequired + " in the year " 
					        + squareOfAge	+ " will be alive in a year" +
						        	" that is the square of their age.");
				}

			}

		}
	}

}
