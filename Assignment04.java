import stanford.karel.SuperKarel;

public class Assignment04 extends SuperKarel {
	public void run() {
		fillTheLine();
		returnToStart();
		moveAllBeepersToStart();
	}

	private void returnToStart() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnAround();
		
	}

	private void moveBeeperToStart() {
		pickBeeper();
		turnAround();
		while(frontIsClear()) {
			move();
		}
		putBeeper();
		turnAround();
	}

	
	
	private void moveAllBeepersToStart() {
		while(frontIsClear()) {
			move();
			if(beepersPresent()) {
				moveBeeperToStart();
			}
		}
		
	}

	private void fillTheLine() {
		while(frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
	}
	

}
