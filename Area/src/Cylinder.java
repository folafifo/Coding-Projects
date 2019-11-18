import java.lang.Math;
public class Cylinder extends Shape {
	private double radius;
	private double height;
	public Cylinder(String name,double radius,double height) {
		super(name);
		this.radius= radius;
		this.height = height;
	}

	@Override
	public double area() {
		double pi = Math.PI;
		double area  = pi*(radius*radius)*height;
		return area;
	}
	@Override
	public String toString() {
		String obj = "";
		obj = obj + super.toString() + " of radius " + this.radius +" and height " + this.height;
		return obj;
	}
}
