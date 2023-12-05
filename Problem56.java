import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem56 extends ConsoleProgram{
	public void run() {
		int n = readInt("# of numbers: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = readInt("Enter number: ");
		}
		int[] sorted = arr;
		Arrays.sort(sorted);
		println(Arrays.toString(sorted));
	}

}
