import acm.program.ConsoleProgram;

public class Problem61 extends ConsoleProgram{
	public void run() {
		boolean exists = false;
		int m = readInt("Enter m: ");
		int n = readInt("Enter n: ");
		int[] nNumbers = new int[n];
		for(int i = 0; i < n; i++) {
			nNumbers[i] = readInt("Enter number: ");
		}
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(nNumbers[i] + nNumbers[j] == m) {
					num1 = nNumbers[i];
					num2 = nNumbers[j];
					exists = true;
					break;
				}
			}
		}
		if(exists) println("Numbers are " + num1 + " and " + num2);
		else println("There is no such numbers");
	}

}
