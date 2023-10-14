import stanford.karel.SuperKarel;

public class Assignment03 extends SuperKarel{
	public void run() {
		fillOddRow();
		while(frontIsClear()) {
			fillEvenRow();
			if(frontIsClear()) {
				move();
				turnRight();
				fillOddRow();
			}
		}
	}

	private void fillEvenRow() {
		while(frontIsClear()) {
			move();
			putBeeper();
			if(frontIsClear()) {
				move();
			}
		}
		returnToStartOfRow();
		
	}

	private void returnToStartOfRow() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnRight();
		
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

