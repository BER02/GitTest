import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem44 extends GraphicsProgram{
	
	private static final int RADIUS = 30;
	private static final int PAUSE = 20;
	private static final int vy = 5;
	private GOval circle;
	
	public void run() {
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		
		addMouseListeners();
		
		while(true) {
			circle.move(0, vy);
			pause(PAUSE);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		add(circle, e.getX() - RADIUS, e.getY() - RADIUS);
	}

}
