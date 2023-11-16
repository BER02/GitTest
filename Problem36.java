import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem36 extends ConsoleProgram{
	
	private static final int NUMBER_OF_EXPERIMENTS = 100000;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		double totalFlips = 0;
		
		for(int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
			totalFlips += holdExperiment();
		}
		
		double avgFlips = totalFlips / NUMBER_OF_EXPERIMENTS;
		println("Average number of flips is: " + avgFlips);
	}
	
	
	private int holdExperiment() {
		int numFlips = 0;
		int consecutiveHeads = 0;
		
		while(true) {
			numFlips++;
			boolean isHead = rgen.nextBoolean();
			if(isHead) {
				consecutiveHeads++;
				if(consecutiveHeads == 3) break; 
			} else consecutiveHeads = 0;
		}
		
		return numFlips;
	}
}
