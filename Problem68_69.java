import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem68_69 extends GraphicsProgram{
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
			text.setText("");
		}
	}
	
	private void displayMessage(String message) {
		if(message == null || message.equals("")) return;
		GLabel messageLabel = new GLabel(message);
		allMessages.add(messageLabel, x, y);
		y += OFFSET;
		
		correctAllMessagesPosition();
	}
	
	private void correctAllMessagesPosition() {
		if(allMessages.getHeight() + OFFSET > getHeight()) {
			allMessages.setLocation(allMessages.getX(), getHeight() - allMessages.getHeight() - OFFSET);
		}	
	}
	
	public void mouseClicked(MouseEvent e) {
		prevY = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		if(allMessages.getHeight() + OFFSET <= getHeight()) return;
		allMessages.move(0, e.getY() - prevY);
		prevY = e.getY();
		
		if(allMessages.getY() > 0) {
			allMessages.setLocation(allMessages.getX(), 0);
		} else if(allMessages.getY() < getHeight() - allMessages.getHeight() - OFFSET) {
			allMessages.setLocation(allMessages.getX(), getHeight() - allMessages.getHeight() - OFFSET);
		}
	}
}
