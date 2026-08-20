package inheritance;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
	private double radius;

	public Circle(Color colour, Point position, double radius) {
		super(colour, position);
		this.radius = radius;
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getCircumference() {
		return Math.PI * getDiameter();
	}
	
	public double getDiameter() {
		return radius * 2;
	}

	@Override
	public String getCharacteristics() {
		return String.format("%s, radius %.2fm, diameter %.2fm, circumference %.2fm, area %.2fm^2",
				super.getCharacteristics(), radius, getDiameter(), getCircumference(), getArea());
	}
}
