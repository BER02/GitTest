
import stanford.karel.SuperKarel;

public class Problem08 extends SuperKarel{
	public void run() {
		move();
		move();
		while(beepersPresent()) {
			removeOneBeeperFromBothPiles();
		}
		turnAround();
		move();
		turnAround();
		moveBeepersToDestination();
		restoreBeepers();
		move();
		restoreBeepers();
		move();
		fullyRestoreFirstPile();
		
		
	}

	private void fullyRestoreFirstPile() {
		while(beepersPresent()) {
			backupBeeper();
			turnAround();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();			
		}
		restoreBeepers();
		
		
	}

	private void restoreBeepers() {
		turnLeft();
		move();
		while(beepersPresent()) {
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();			
		}
		turnAround();
		move();
		turnLeft();
		
	}

	private void moveBeepersToDestination() {
		while(beepersPresent()) {
			pickBeeper();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();
			turnAround();			
		}
		
	}

	private void removeOneBeeperFromBothPiles() {
		while(beepersPresent()) {
			backupBeeper();
			turnAround();
			move();
			turnAround();
			backupBeeper();
			move();
		}
		
	}

	private void backupBeeper() {
		pickBeeper();
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();	
	}

}
