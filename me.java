import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

public class me extends GraphicsProgram{
	private GPoint prevPoint;
	private GLine line;
	public void run(){
		addMouseListeners();
		prevPoint = new GPoint(0, 0);
	}
	
	public void mousePressed(MouseEvent e){
		line = new GLine(prevPoint.getX(), prevPoint.getY(),
				e.getX(), e.getY());
		add(line);
		prevPoint = new GPoint(e.getX(), e.getY());
	}
	
	public void mouseDragged(MouseEvent e){
		line.setEndPoint(e.getX(), e.getY());
		prevPoint = new GPoint(e.getX(), e.getY());
	}
}