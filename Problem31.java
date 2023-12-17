import acm.program.ConsoleProgram;

public class Problem31 extends ConsoleProgram{
	public void run() {
		for (int i = 1; i <= MAX; i++) {
			if(isPrime(i)) println(i);
		}
	}

	private boolean isPrime(int n) {
		
		if (n == 1) return false;
		
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	private static final int MAX = 1000;
}
