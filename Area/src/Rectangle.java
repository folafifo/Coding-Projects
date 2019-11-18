
public class Rectangle extends Shape {
	private double length;
	private double width;
	public Rectangle(String name, double length , double width) {
		super(name);
		this.length= length;
		this.width= width;
	}

	@Override
	public double area() {
		return length*width;
	}
	@Override
	public String toString() {
		String obj = "";
		obj = obj + super.toString() + " of length " + this.length +" and width " + this.width;
		return obj;
	}

}
