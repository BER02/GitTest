import java.awt.event.MouseEvent;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Problem41B extends GraphicsProgram{
	private static final int RADIUS = 20;
	private GOval circle;
	public void run() {
		circle = new GOval(2 * RADIUS, 2 * RADIUS);
		addMouseListeners(); 
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		paintCircle(e.getX(), e.getY());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		paintCircle(e.getX(), e.getY());
	}
	
	private void paintCircle(int centerX, int centerY) {
		circle.setFilled(true);
		int x = centerX - RADIUS;
		int y = centerY - RADIUS;
		add(circle, x, y);
	}
}
