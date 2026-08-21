package abstract1;

import java.awt.Color;
import java.awt.Point;

public abstract class Shape {
	private Color colour;
	private Point position;
	
	Shape(Color colour, Point position) {
		this.colour = colour;
		this.position = position;
	}
	
	public Color getColour() {
		return colour;
	}
	
	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}

	public abstract double getArea();

	public String getCharacteristics() {
		return String.format("%s: colour: %s, position (%d, %d)",
				getClass().getSimpleName(),
				colour,
				position.x,
				position.y
		);
	}
}
