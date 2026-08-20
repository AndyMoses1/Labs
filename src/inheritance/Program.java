package inheritance;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(new Rectangle(Color.BLUE, new Point(5, 5), 3, 4));
		shapes.add(new Circle(Color.RED, new Point(10, 20), 2.0));		
		shapes.add(new Sphere(Color.GREEN, new Point(0, 0), 3.0));

		for (Shape shape : shapes) {
			System.out.println(shape.getCharacteristics());
		}
	}

}
