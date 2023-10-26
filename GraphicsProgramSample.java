/*
 * File: GraphicsHierarchy.java
 * ----------------------------
 * This program is a stub for the GraphicsHierarchy problem, which
 * draws a partial diagram of the acm.graphics hierarchy.
 */

import acm.graphics.*;
import acm.program.*;


public class GraphicsProgramSample extends GraphicsProgram {
	
	public void run() {
		GRect rect = new GRect(50, 100); // type + sizes
		add(rect, 40, 40); // placement
		add(new GOval(100, 100, 500, 500));
	}

}
