package abstract1;

import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
	int sideA, sideB;

	public Rectangle(Color colour, Point position, int sideA, int sideB) {
		super(colour, position);
		this.sideA = sideA;
		this.sideB = sideB;		
	}

	@Override
	public double getArea() {
		return this.sideA * this.sideB;
	}

	@Override
	public String getCharacteristics() {
		return String.format("%s, sideA %d, sideB %d, area %.2fm^2",
				super.getCharacteristics(), sideA, sideB, getArea());
	}
}
