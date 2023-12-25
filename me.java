import java.util.Arrays;

import acm.util*;

import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class me extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run() {
		int[] arr = {3, -2, 3, 6, 1};
		int[] sortedArr = arr;
		Arrays.sort(sortedArr);
		println(Arrays.toString(sortedArr));
	}
}