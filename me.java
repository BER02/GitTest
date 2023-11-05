import acm.graphics.*;
import acm.program.*;

public class me extends GraphicsProgram {
	
	public void run() {
		GLabel text = new GLabel("hello");
		add(text, 100, 100);
		add( new GLine (100, 100 - text.getAscent(), getWidth(), 100 - text.getAscent()));
	}
	 
}
