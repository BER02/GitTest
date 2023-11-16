import acm.program.ConsoleProgram;

public class Problem29 extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		println(fib(n));
	}
	
	// 0 1 2 3 4 5 6
	// 0 1 1 2 3 5 8
	
	private int fib(int n) {
		if( n == 0 || n == 1) return n;
		
		int prev2 = 0;
		int prev1 = 1;
		
		int curr = -1;
		for(int i = 2; i <= n; i++) {
			curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		
		return curr;
	}
	

}
