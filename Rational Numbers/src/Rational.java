

public class Rational {
	private int numerator;
	private int denominator;

	Rational(int numer, int denom) {
		numerator = numer;
		if (denom!=0) {
		denominator = denom;
		}
		else {
			throw new ArithmeticException("denominator == 0");
		}
		
	}

	Rational(int numer) {
		numerator = numer;
		denominator = 1;
	}

	public Rational add(Rational a, Rational b) {
		int newDenominator = a.denominator * b.denominator;
		int newNumerator = (a.denominator * b.numerator) + (b.denominator * a.numerator);
		if (newNumerator % newDenominator == 0) {
			newNumerator = newNumerator / newDenominator;
			newDenominator = 1;
		}
		Rational answer = new Rational(newNumerator, newDenominator);
		return answer;
	}

	public Rational subtract(Rational a, Rational b) {
		int newDenominator = a.denominator * b.denominator;
		int newNumerator = (b.denominator * a.numerator) - (a.denominator * b.numerator);
		if (newNumerator % newDenominator == 0) {
			newNumerator = newNumerator / newDenominator;
			newDenominator = 1;
		}
		Rational answer = new Rational(newNumerator, newDenominator);
		return answer;
	}

	public Rational multiply(Rational a, Rational b) {
		int newDenominator = a.denominator * b.denominator;
		int newNumerator = a.numerator * b.numerator;
		if (newNumerator % newDenominator == 0) {
			newNumerator = newNumerator / newDenominator;
			newDenominator = 1;
		}
		Rational answer = new Rational(newNumerator, newDenominator);
		return answer;
	}

	public Rational divide(Rational a, Rational b) {
		int newDenominator = a.denominator * b.numerator;
		int newNumerator = a.numerator * b.denominator;
		if (newNumerator % newDenominator == 0) {
			newNumerator = newNumerator / newDenominator;
			newDenominator = 1;
		}
		Rational answer = new Rational(newNumerator, newDenominator);
		return answer;
	}

	public boolean equals(Rational a, Rational b) {
		double decValueOne = (double)a.numerator /(double) a.denominator;
		double decValueTwo = (double)b.numerator / (double)b.denominator;
		if (decValueOne == decValueTwo) {
			return true;
		}
		return false;
	}

	public boolean isLessThan(Rational a, Rational b) {
		double decValueOne = (double)a.numerator /(double) a.denominator;
		double decValueTwo = (double)b.numerator /(double) b.denominator;
		if (decValueOne < decValueTwo) {
			return true;
		}
		return false;
	}

	public Rational simplify(Rational a) {
		int gcd = getGreatestCommonDivisor(a.numerator, a.denominator);
		int newNumerator = a.numerator / gcd;
		int newDenominator = a.denominator / gcd;
		if (newDenominator < 0) {
			newDenominator = Math.abs(newDenominator);
			newNumerator = -newNumerator;
		}
		Rational answer = new Rational(newNumerator, newDenominator);
		return answer;
	}

	public String toString(Rational a) {
		
		String Rational = "";
		if (a.denominator==1) {
			Rational = a.numerator + "";
		}
		else if (a.numerator==a.denominator) {
			Rational = "1";
		}
		else if (a.numerator==0) {
			Rational= "0";
		}
		else {
		    Rational = a.numerator + "/" + a.denominator;
		}
		return Rational;
	}

	// Credit to Michaelmas term imperative programming from blackboard
	public int getNextDivisor(int lastDivisor, int number) {
		if ((lastDivisor > 0) && (lastDivisor < Math.abs(number)) && (number % lastDivisor == 0)) {
			int divisor = lastDivisor;
			do {
				divisor++;
			} while ((divisor < Math.abs(number)) && (number % divisor != 0));
			if (number % divisor == 0) {
				return divisor;
			}
		}
		return -1;
	}

	// Credit to Michaelmas term imperative programming from blackboard
	public int getGreatestCommonDivisor(int number1, int number2) {
		int gcd = 1;
		int divisor = 1;
		while ((divisor != -1) && (divisor < Math.abs(number2))) {
			if (Math.abs(number2) % divisor == 0) {
				gcd = divisor;
			}
			divisor = getNextDivisor(divisor, number1);
		}
		return gcd;
	}

}
