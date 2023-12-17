import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem37 extends ConsoleProgram{
	
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		int bet = readInt("Enter number: ");
		int rouletteNumber = rgen.nextInt(MIN_VALUE, MAX_VALUE);
		println("Roulette number is: " + rouletteNumber);
		if(bet == rouletteNumber) println("YOU HAVE WON!");
		else println("YOU HAVE LOST!");
	}	
}
