import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class guka extends GraphicsProgram {
	public void run() {
		 add(new GLabel("Hello, world, from guka!", 100,75));
		 add(new GRect(98, 60, 134,  23));
	}
	
}
