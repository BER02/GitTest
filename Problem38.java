import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem38 extends ConsoleProgram{
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;

	public void run() {
		int balance = 1000;
		while(balance > 0) {
			int bet = readInt("Enter your bet: ");
			int betNumber = readInt("Enter number:" );
			int rouletteNumber = rgen.nextInt(MIN_VALUE, MAX_VALUE);
			if(betNumber == rouletteNumber) {
				balance += bet;
				println("Roulette number is: " + rouletteNumber);
				println("You have won: " + bet);
				println("Balance: " + balance);
			} else {
				balance -= bet;
				println("Roulette number is: " + rouletteNumber);
				println("You have lost: " + bet);
				println("Balance: " + balance);
			}
		}
		
		println("GAME OVER!");
	}
}
