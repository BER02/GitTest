import java.util.Arrays;
import acm.program.ConsoleProgram;

public class me extends ConsoleProgram{	
	public void run() {
		int[] arr = {3, -2, 3, 6, 1};
		int[] sortedArr = arr;
		Arrays.sort(sortedArr);
		println(Arrays.toString(sortedArr));
	}
}