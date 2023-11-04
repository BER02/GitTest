import acm.graphics.*;
import acm.program.*;

public class Problem13 extends GraphicsProgram{
	public void run() {
		drawMidLine();
		drawCircle(5,5);
	}

	private void drawCircle(int i, int j) {
		add(new GOval(10, 10, 10000, 100));
		
	}

	private void drawMidLine() {
		double x1 = 0;
		double y1 = (int) (getHeight() / 2 + 10.5);
		double x2 = (int) (getWidth());
		double y2 = y1;
		GLine midLine = new GLine(x1, y1, x2, y2);
		add(midLine);
		
		double y3 = (double) getHeight() / 2;
		//add(new GLine(x1, y3, x2, y3));
	}
	

}
