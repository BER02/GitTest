import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Problemsth extends GraphicsProgram {
	private static final int RADIUS = 20;

	public void run() {
		GRect rect = new GRect(10, 10);
		rect.setFilled(true);
		add(rect, 100, 100);
		rect.move(10.0 , 10.0);
		pause(20);
	}


	
}