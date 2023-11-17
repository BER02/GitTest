import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem40 extends GraphicsProgram{
	
	private static final int BALL_RADIUS = 30;
	private static final int VEL_X = 5;
	private static final int PAUSE = 20;
	
	public void run() {
		GOval circle = createCircle();
		int vx = VEL_X;
		
		while(true) {
			if(circle.getX() < 0 || circle.getX() + 2 * BALL_RADIUS >= getWidth()) vx = -vx;
			
			circle.move(vx, 0);
			pause(PAUSE);
		}
		
	}
	
	private GOval createCircle() {
		GOval circle = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		circle.setFilled(true);
		add(circle, 0, getHeight() / 2 - BALL_RADIUS);
		return circle;
	}
}
