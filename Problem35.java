import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem35 extends ConsoleProgram{
	private static final int NUMBER_OF_EXPERIMENTS = 100000;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run() {
		double totalFlips = 0;
		for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
			totalFlips += holdExperiment();
		}
		
		double averageNumberOfFlips = totalFlips / NUMBER_OF_EXPERIMENTS;
		println("Average number of flips is: " + averageNumberOfFlips);
	}
	
	private int holdExperiment() {
		int numberOfFlips = 0;
		while(true) {
			numberOfFlips++;
			boolean isHead = rgen.nextBoolean();
			if(isHead) break;
		}
		
		return numberOfFlips;
	}
	

}
