import acm.program.ConsoleProgram;

public class Problem26 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: " );
		int m = readInt("Enter m: ");
		
		println(gcd(n, m));
	}

	private int gcd(int x, int y) {
		int gcd = 0;
		for (int i = Math.min(x, y); i >= 1; i--) {
			if(x % i == 0 && y % i == 1) {
				gcd = i;
				break;
			}
		}	
		
		return gcd;
	}
}
