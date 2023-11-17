import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem40 extends GraphicsProgram{
	
	private final static int BALL_RADIUS = 30;
	private final static int VEL_X = 5;
	private final static int PAUSE = 20;
	
	public void run() {
		addCircle();
		circleMovement();
	}
	
	private void addCircle() {
		circle.setSize(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		circle.setFilled(true);
		add(circle, 0, getHeight() / 2 - BALL_RADIUS);
	}
	
	private void circleMovement() {
		int vx = VEL_X;
		while(true) {
			if(circle.getX() + 2 * BALL_RADIUS >= getWidth() || circle.getX() <= 0) vx = -vx;
			circle.move(VEL_X, 0);
			pause(PAUSE);
		}

	}
	
	private GOval circle;

}
