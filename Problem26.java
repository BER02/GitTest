import acm.program.ConsoleProgram;

public class Problem26 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: " );
		int m = readInt("Enter m: ");
		
		println(GCD(n, m));
	}

	private int GCD(int x, int y) {
		for (int i = Math.min(x, y); i >= 1; i--) {
			if(x % i == 0 && y % i == 1) return i;
		}
		return -1;
		
	}
}
