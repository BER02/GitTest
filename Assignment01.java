import stanford.karel.SuperKarel;

public class Assignment01 extends SuperKarel {
	public void run() {
		moveToMagazine();
		pickMagazine();
		returnToInitialPosition();
	}

	private void returnToInitialPosition() {
		turnAround();
		for( int i = 0; i < 3; i++) {
			move();
		}
		turnRight();
		move();
		turnRight();
		
	}

	private void pickMagazine() {
		pickBeeper();
		
	}

	private void moveToMagazine() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		
	}

}
