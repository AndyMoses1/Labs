package oo2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Game extends Canvas {
	public static void main(String[] args) {
		new Game();
	}

	Ball[] balls = new Ball[] {
			new Ball(10, 10, 20, 20),
			new Ball(150, 50, 30, 30, 2, -1),
			new Ball(200, 200, 15, 15, -3, 2)
	};
	
	private int width = 300;
	private int height = 300;

	Game() {
		JFrame frame = new JFrame();
		this.setSize(width + 100, height + 100);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		
		Ball.setWorld(width, height);
				
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
		for (Ball ball : balls) {
			ball.move();
		}

		this.repaint();
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.blue);
		
		for (Ball ball : balls) {
			g.fillOval(ball.x,  ball.y, ball.w, ball.h);
		}		
	}
}


