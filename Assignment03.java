import stanford.karel.SuperKarel;

public class Assignment03 extends SuperKarel{
	public void run() {
		fillOddRow();
		turnRight();
		move();
		turnRight();
		fillEvenRow();
	}

	private void fillEvenRow() {
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();
			}
		}
		returnToStartOfRow();
		
	}

	private void returnToStartOfRow() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		
	}

	private void fillOddRow() {
		putBeeper();
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();
			}
		}
		returnToStartOfRow();
	}
	
}

