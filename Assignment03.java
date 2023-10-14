import stanford.karel.SuperKarel;

public class Assignment03 extends SuperKarel{
	public void run() {
		fillTwoRows();
	}

	private void fillTwoRows() {
		putBeeper();
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();	
			}
		}
		turnLeft();
		move();
		turnLeft();
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();	
	        }
        }
		turnRight();
		move();
		turnRight();
	}
	
}
