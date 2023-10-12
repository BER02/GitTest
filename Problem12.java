import acm.graphics.*;
import acm.program.*;

public class Problem12 extends GraphicsProgram{
	
//	private static final double PI = 3.14;
	
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT = 200;
	private static final double DOOR_WIDTH = 40;
	private static final double DOOR_HEIGHT = 60;
	private static final double ROOF_HEIGHT = 100;
	
	
	
	public void run() {
		drawCentreLine();
		drawHouse();
		
	}
	
	private void drawHouse() {
		drawWall();
		drawRoof();
//		draw
		
	}

	private void drawRoof() {
		double x1 = (int) (getWidth() / 2 - HOUSE_WIDTH / 2);
		double x2 = x1 + HOUSE_WIDTH / 2;
		double y1 = getHeight() - HOUSE_HEIGHT; 
		double y2 = y1 - ROOF_HEIGHT;
		
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				
				
			} else {
				x1 = x2;
				y1 = y2;
				x2 = x1 + HOUSE_WIDTH / 2;
				y2 = y1 + ROOF_HEIGHT /2;
					
			}
		
		GLine leftRoof = new GLine(x1, y1, x2, y2);
		add(leftRoof);
		}
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
