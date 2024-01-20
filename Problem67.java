import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Problem67 extends GraphicsProgram{
	private JTextField imageName;
	
	public void init() {
		imageName = new JTextField();
		add(imageName, SOUTH);
	
		imageName.setActionCommand("this");
		
		GImage image = new GImage("bad path");
		double x = getWidth()/ 2 - image.getWidth() / 2;
		double y = getHeight()/ 2 - image.getHeight() / 2;
		add(image, x, y);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("this")) {
			try {
				GImage image = new GImage(imageName.getText());
				double x = getWidth()/ 2 - image.getWidth() / 2;
				double y = getHeight()/ 2 - image.getHeight() / 2;
				add(image, x, y);
			} catch(Exception ex) {
				removeAll();
				add(new GLabel("Error occured"), 20, 20);
			}
			imageName.setText("");
		}
	}

}
