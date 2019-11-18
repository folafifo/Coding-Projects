
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a numerator followed by a denominator: ");
		int numeratorOne = input.nextInt();
		int denominatorOne = input.nextInt();
		System.out.print("Please enter another numerator followed by a denominator: ");
		int numeratorTwo = input.nextInt();
		int denominatorTwo = input.nextInt();
		input.close();
		Rational rationalOne;
		Rational rationalTwo;
		if (denominatorOne == 1) {
			rationalOne = new Rational(numeratorOne);
		} else {
			rationalOne = new Rational(numeratorOne, denominatorOne);
		}
		if (denominatorTwo == 1) {
			rationalTwo = new Rational(numeratorTwo);
		} else {
			rationalTwo = new Rational(numeratorTwo, denominatorTwo);
		}

		System.out.println(rationalOne.toString(rationalOne) + " + " + rationalTwo.toString(rationalTwo) + " = "
				+ rationalOne.toString(rationalOne.simplify(rationalOne.add(rationalOne, rationalTwo))) + ".");
		System.out.println(rationalOne.toString(rationalOne) + " - " + rationalTwo.toString(rationalTwo) + " = "
				+ rationalOne.toString(rationalOne.simplify(rationalOne.subtract(rationalOne, rationalTwo))) + ".");
		System.out.println(rationalOne.toString(rationalOne) + " * " + rationalTwo.toString(rationalTwo) + " = "
				+ rationalOne.toString(rationalOne.simplify(rationalOne.multiply(rationalOne, rationalTwo))) + ".");
		System.out.println(rationalOne.toString(rationalOne) + " ÷ " + rationalTwo.toString(rationalTwo) + " = "
				+ rationalOne.toString(rationalOne.simplify(rationalOne.divide(rationalOne, rationalTwo))) + ".");
		System.out.println(rationalOne.toString(rationalOne) + " = " + rationalTwo.toString(rationalTwo) + " is "
				+ rationalOne.equals(rationalOne, rationalTwo) + ".");
		System.out.println(rationalOne.toString(rationalOne) + " < " + rationalTwo.toString(rationalTwo) + " is "
				+ rationalOne.isLessThan(rationalOne, rationalTwo) + ".");
		
	}

}
