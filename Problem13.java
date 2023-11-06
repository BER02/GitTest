import acm.program.*;

public class Problem13 extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		int m = readInt("Enter m: ");
		println(gcd(n, m));
	}
	
	private int gcd(int n, int m) {
		for (int i = Math.min(n, m); i >= 1; i--) {
			if (n % i == 0 && m % i == 0) {
				return i;
			}
		}
		return -1;
	}
}
