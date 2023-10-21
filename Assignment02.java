import stanford.karel.SuperKarel;

public class Assignment02 extends SuperKarel{
	public void run() {
		fillTheColumn();
		while(frontIsClear()) {
			moveToTheNextColumn();
			fillTheColumn();
		}
		
	}

	private void moveToTheNextColumn() {
		if(frontIsClear()) {
			for( int i = 0; i < 4; i ++) {
				move();
			}
		}
		
	}

	private void fillTheColumn() {
		turnLeft();
		while(frontIsClear()) {
			if(noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if(noBeepersPresent()) {
			putBeeper();
		}
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnLeft();	
	}

}
