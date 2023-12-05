import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class me extends GraphicsProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run() {
		GOval circle = new GOval(100, 100);
		circle.setFilled(true);
		circle.setColor(rgen.nextColor());
		add(circle, 100, 100);
	}
}