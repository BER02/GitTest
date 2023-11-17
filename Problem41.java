import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem41 extends GraphicsProgram{
	private final static int RADIUS = 10;
	
	public void run() {
		addMouseListeners();
	}
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX() - RADIUS;
		int y = e.getY() - RADIUS;
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, x, y);
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX() - RADIUS;
		int y = e.getY() - RADIUS;
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, x, y);
	}

}
