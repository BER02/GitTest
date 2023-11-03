import acm.graphics.*;
import acm.program.*;

public class me extends GraphicsProgram {
 public void run() {
 GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
 square.setFilled(true);
 add(square);
 double dx = (getWidth() - SQUARE_SIZE) / N_STEPS;
 double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
 for (int i = 0; i < N_STEPS; i++) {
 square.move(dx, dy);
 pause(PAUSE_TIME);
 }
 }
/* Private constants */
 private static final int N_STEPS = 100;
 private static final int PAUSE_TIME = 1000;
 private static final double SQUARE_SIZE = 50;
}
