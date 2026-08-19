package collections;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Game extends Canvas {
	public static void main(String[] args) {
		new Game();
	}

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	private int width = 300;
	private int height = 300;

	Game() {
		shapes.add(new Shape(ShapeType.Oval, Color.BLUE, 10, 10, 20, 20, -1, 1));
		shapes.add(new Shape(ShapeType.Rectangle, Color.CYAN, 150, 50, 30, 30, 2, -1));
		shapes.add(new Shape(ShapeType.Arc, Color.GREEN, 200, 200, 30, 45, -3, 2));
		// 12 constructor chaining
		shapes.add(new Shape(75, 25, 15));

		JFrame frame = new JFrame();
		this.setSize(width + 100, height + 100);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		
		Shape.setWorld(width, height);
				
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		@Override
		public void run() {
			draw();
		}
	};

	t.schedule(tt, 0, 50);

		
	frame.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
				t.cancel();
				tt.cancel();
			}
		});
	}

	public void draw() {
		for (Shape shape : shapes) {
			shape.move();
		}

		this.repaint();
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, width, height);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		
		for (Shape shape : shapes) {
			g.setColor(shape.getColour());
			
			switch (shape.getShapeType()) {
		     case Rectangle:
		         g.fillRect(shape.x, shape.y, shape.w, shape.h);
		         break;
		     case ThreeDRectangle:
		         g.fill3DRect(shape.x, shape.y, shape.w, shape.h, true);
		         break;
		     case RoundRectangle:
		         g.fillRoundRect(shape.x, shape.y, shape.w, shape.h, shape.w / 4, shape.h / 4);
		         break;
		     case Oval:
		         g.fillOval(shape.x, shape.y, shape.w, shape.h);
		         break;
		     case Arc:
		         g.fillArc(shape.x, shape.y, shape.w, shape.h, 0, 180);
		         break;
		     }
		}		
	}
}


