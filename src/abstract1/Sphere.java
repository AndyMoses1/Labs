package abstract1;

import java.awt.Color;
import java.awt.Point;

public class Sphere extends Circle {

	public Sphere(Color colour, Point position, double radius) {
        super(colour, position, radius);
	}
	
	// Surface area of a sphere, rather than inheriting Circle's flat pi*r^2.
	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(getRadius(), 2);
	}

	public double getVolume() {
		return (4.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
		
	}

	@Override
	public String getCharacteristics() {
		return String.format("%s, volume %.2fm^3", super.getCharacteristics(), getVolume());
	}
}
