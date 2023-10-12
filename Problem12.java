import acm.graphics.*;
import acm.program.*;

public class Problem12 extends GraphicsProgram{
	public void run() {
		draw();
		
	}
	
	private void draw() {
		double x1 = 0;
		double x2 = getWidth();
		double y1 = getHeight() / 2;
		double y2 = y1;
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}

}
