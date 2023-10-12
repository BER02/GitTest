import acm.graphics.*;
import acm.program.*;

public class Problem12 extends GraphicsProgram{
	public void run() {
		drawWall();
		drawDoor();
		drawWindow();
		drawRoof();
		
	}

	private void drawWall() {
		GRect Wall = new GRect(500, 500);
		add(Wall, 200, 200);
		
	}

}
