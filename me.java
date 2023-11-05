import acm.graphics.*;
import acm.program.*;

public class me extends GraphicsProgram {
 public void run() {
 double sqSize = getHeight() / N_ROWS;
 for (int i = 0; i < N_ROWS; i++) {
 for (int j = 0; j < N_COLUMNS; j++) {
 double x = j * sqSize;
 double y = i * sqSize;
 GRect sq = new GRect(x, y, sqSize, sqSize);
 sq.setFilled((i + j) % 2 != 0);
 add(sq);
 }
 }
 }
/* Private constants */
 private static final int N_ROWS = 8;
 private static final int N_COLUMNS = 8;
}
