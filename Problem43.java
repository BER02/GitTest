import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem43 extends GraphicsProgram {
	
	private static final int RADIUS = 50;
	private GObject chosenObject;
	private int prevX;
	private int prevY;
	
	public void run() {
		GOval circle = new GOval( 2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle, getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS);
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		chosenObject = getElementAt(e.getX(), e.getY());
		if(chosenObject != null) {
			prevX = e.getX();
			prevY = e.getY();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(chosenObject != null) {
		chosenObject.move(e.getX() - prevX, e.getY() - prevY);
		
		prevX = e.getX();
		prevY = e.getY();
		}
		
	}
}
