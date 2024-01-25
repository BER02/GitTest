import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Problem70 extends GraphicsProgram implements ComponentListener{ 
	private static final int GRID_NUM = 10;
	
	public void init() {
		addComponentListener(this);
		draw();	
	}
	
	private void draw() {
		removeAll();
		double width = (double) getWidth() / GRID_NUM;
		double height = (double) getHeight() / GRID_NUM;
		
		for(int i = 0; i <= GRID_NUM; i++) {
			add(new GLine(0, i * height, getWidth(), i * height));
			add(new GLine(i * width, 0, i * width, getHeight()));
 		}
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		draw();
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
