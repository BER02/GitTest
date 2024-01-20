import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem68 extends GraphicsProgram{
	private static final int OFFSET = 50;
	private JTextField text;
	private JButton button;
	private GCompound allMessages;
	private int x = OFFSET;
	private int y = OFFSET;
	private int prevY;
	
	public void init() {
		text = new JTextField(40);
		add(text, SOUTH);
		
		text.addActionListener(this);
		
		button = new JButton("Enter");
		add(button, SOUTH);
		
		allMessages = new GCompound();
		add(allMessages);
		
		addActionListeners();
		addMouseListeners();	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == text || e.getSource() == button) {
			String message = text.getText();
			displayMessage(message);
		}
	}
	
	private void displayMessage(String message) {
		if(message == null || message == "") return;
		GLabel messageLabel = new GLabel(message);
		allMessages.add(messageLabel, x, y);
		y += OFFSET;
		
		correctAllMessagesPosition();
	}
	
	private void correctAllMessagesPosition() {
		if(allMessages.getHeight() + OFFSET > getHeight()) {
			allMessages.setLocation(x, getHeight() - allMessages.getHeight() - OFFSET);
		}	
	}
	
	public void mouseClicked(MouseEvent e) {
		prevY = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		if(allMessages.getHeight() + OFFSET <= getHeight()) return;
		allMessages.move(0, e.getY() - prevY);
		
		if(allMessages.getY() > 0) {
			allMessages.setLocation(x, 0);
		} else if(allMessages.getY() < getHeight() - allMessages.getHeight() - OFFSET) {
			allMessages.setLocation(x, getHeight() - allMessages.getHeight() - OFFSET);
		}
	}
}
