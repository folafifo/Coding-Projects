
public class Paint {
	private double coverage;
	Paint(double coverage){
		this.coverage=coverage;
	}
	public double amount(Shape shape) {
		System.out.println(shape.toString());
		double area = shape.area();
		double amount = area / this.coverage;
		return amount;
	}
}
