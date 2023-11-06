import acm.program.ConsoleProgram;

public class Problem27 extends ConsoleProgram {
	public void run() {
		int numEven = 0;
		
		while(true) {
			int n = readInt("? ");
			if (n == SENTINEL) break;
			
			while(n < 0) {
				println("n must be positive");
				n = readInt("? ");
			}
			if (n % 2 == 0) numEven++;
		}
		
		println("number of evens = " + numEven);
	}
	
	private static final int SENTINEL = -1;

}
