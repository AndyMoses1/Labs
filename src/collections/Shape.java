package collections;

import java.awt.Color;

public class Shape {
	public int x, y, w, h;
	private int dirX, dirY;
	private Color colour;

	// static, so there is one world shared by every Ball rather than each
	// ball carrying its own copy.
	private static int worldW;
	private static int worldH;
	
	private ShapeType shapeType;

	Shape(ShapeType shapeType, Color colour, int x, int y, int w, int h, int dirX, int dirY) {
		this.shapeType = shapeType;
		this.colour = colour;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.dirX = dirX;
		this.dirY = dirY;
	}

	Shape(ShapeType shapeType, int x, int y, int w, int h) {
		this(shapeType, Color.blue, x, y, w, h, 1, 1);
	}
	

	Shape(int x, int y, int w) {
		this(ShapeType.Oval, Color.BLACK, x, y, w, w, -1, 2);
	}

	public static void setWorld(int w, int h) {
		worldW = w;
		worldH = h;
	}

	public void move() {
		x += dirX;
		y += dirY;

		// Left edge.
		if (x < 0) {
			x = 0;
			dirX = -dirX;
		} else if (x + w > worldW) { //right edge
			x = worldW - w;
			dirX = -dirX;
		}

		// Top edge.
		if (y < 0) {
			y = 0;
			dirY = -dirY;
		} else if (y + h > worldH) { //bottom edge
			y = worldH - h;
			dirY = -dirY;
		}
	}
	
	public ShapeType getShapeType() {
		return shapeType;
	}
	
	public Color getColour() {
		return colour;
	}
}
