import java.util.Arrays;
import acm.program.ConsoleProgram;

public class me extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = readInt("Enter number: ");
		}
		println(Arrays.toString(arr));
		println(isSorted2(arr));
		println(isSorted(arr));
	}
	
	boolean isSorted(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	boolean isSorted2(int[] arr) {
		int[] arrCopy = Arrays.copyOf(arr, arr.length); // instead of manually copying
//		int[] arrCopy = new int[arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			arrCopy[i] = arr[i];
//		}
//		
		Arrays.sort(arrCopy);
//		Arrays.sort(arr); // bad style. ! DO NOT modify arguments if it is not specified
		return Arrays.equals(arr, arrCopy);
	}
}