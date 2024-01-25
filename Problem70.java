import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GRect;
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
		for(int i = 0; i < GRID_NUM; i++) {
			for(int j = 0; j < GRID_NUM; j++) {
				GRect rect = new GRect(width, height);
				add(rect, i * width, j * height);
			}
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
