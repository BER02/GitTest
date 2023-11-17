import java.awt.event.MouseEvent;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Problem42 extends GraphicsProgram{
	public void run() {
		addMouseListeners();
		line = new GLine(0,0,0,0);
	}
	
	public void mousePressed(MouseEvent e) {
		line = new GLine(e.getX(), e.getY(),e.getX(), e.getY());
		add(line);
	}
	 
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
	}
	
	GLine line;
}