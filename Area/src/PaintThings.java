
public class PaintThings {

	public static void main(String[] args) {
		Shape deck = new Rectangle("Rectangle", 20, 35);
		Shape bigBall = new Sphere("Sphere", 15);
		Shape tank = new Cylinder("Cylinder",10,30);
		Paint paint = new Paint(350);
		System.out.print("Computing amount for ");
		double amount = paint.amount(deck);
		System.out.println("Amount of paint required is " + amount);
		System.out.print("Computing amount for ");
		amount = paint.amount(bigBall);
		System.out.println("Amount of paint required is " + amount);
		System.out.print("Computing amount for ");
		amount = paint.amount(tank);
		System.out.println("Amount of paint required is " + amount);
	}

}
