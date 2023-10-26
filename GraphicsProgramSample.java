/*
 * File: GraphicsHierarchy.java
 * ----------------------------
 * This program is a stub for the GraphicsHierarchy problem, which
 * draws a partial diagram of the acm.graphics hierarchy.
 */

import java.awt.*;
import acm.graphics.*;
import acm.program.*;


public class GraphicsProgramSample extends GraphicsProgram {
	
	public void run() {
		GRect rect = new GRect(50, 100); // type + sizes
		add(rect, 40, 40); // placement
		add(new GOval(100, 100, 500, 500)); // adds new figure (type, x, y, width, height)
		add(new GLabel("BERO" , 40, 4)); // adds new text x, y
		GOval oval = new GOval(100, 15, 100, 200); // x, y, width, height
		add(oval);
		rect.setFilled(true); // fills figure
		rect.setColor(Color.RED); // gives color
		oval.setFilled(false);
		oval.setColor(Color.BLUE);
		GRect rect1 = new GRect(15, 15, 35, 35);
		rect1.setFillColor(Color.GREEN);
		add(rect1);
	}

}
