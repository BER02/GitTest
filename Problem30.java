import acm.program.ConsoleProgram;

public class Problem30 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter number: ");
		println(reverse(n));
	}

	private int reverse(int n) {
		
		int reverse = -1;
		int lastDigit = 0;
		
		while( n != 0 ) {
			lastDigit = n % 10;
			n = n / 10;
			reverse = reverse * 10 + lastDigit;
		}
		
		return reverse;
	}
}
