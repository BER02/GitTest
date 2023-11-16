import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class me extends GraphicsProgram {
	
	public void run() {
		winMessage();
	}
	private void winMessage() {
		GLabel winMessage = new GLabel("YOU HAVE WON!");
		winMessage.setColor(Color.RED);
		add(winMessage, (getWidth() - winMessage.getWidth()) / 2, (getHeight() - winMessage.getAscent()) / 2);
	}
	 
}
