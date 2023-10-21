import java.awt.Color;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class guka extends GraphicsProgram {
	public void run() {
		 GLabel guka = new GLabel("Hello, world, from guka!", 100, 75);
		 guka.setColor(Color.CYAN);
		 add(guka);
		 add(new GRect(98, 60, 134,  23));
	}
	
}
