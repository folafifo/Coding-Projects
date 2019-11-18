import java.lang.Math;
public class Sphere extends Shape {
	private double radius;
	
	Sphere(String name, double radius){
		super(name);
		this.radius= radius;
	}

	@Override
	public double area() {
		double pi = Math.PI;
		double area = 4*pi*(radius*radius);
		return area;
	}
	@Override
	public String toString() {
		String obj = "";
		obj = obj + super.toString() + " of radius " + this.radius;
		return obj;
	}
}
