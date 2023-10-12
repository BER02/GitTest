import acm.graphics.*;
import acm.program.*;

public class Problem12 extends GraphicsProgram{
	
//	private static final double PI = 3.14;
	
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT = 200;
	private static final double DOOR_WIDTH = 40;
	private static final double DOOR_HEIGHT = 60;
	
	
	public void run() {
		drawCentreLine();
		drawHouse();
		
	}
	
	private void drawHouse() {
		drawWall();
		drawRoof();
		draw
		
	}

	private void drawWall() {
		GRect wall = new GRect(HOUSE_WIDTH, HOUSE_HEIGHT);
		int x = (int) (getWidth() / 2 - HOUSE_WIDTH / 2);
		double y = getHeight() - HOUSE_HEIGHT; 
		add(wall, x, y);
	
		
	}

	private void drawCentreLine() {
		double x1 = 0;
		double x2 = getWidth();
		double y1 = getHeight() / 2;
		double y2 = y1;
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}

}
