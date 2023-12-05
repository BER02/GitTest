import acm.program.ConsoleProgram;

public class Problem55 extends ConsoleProgram{ 
	public void run() {
		int n = readInt("# of numbers: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = readInt("Enter number: ");
		}
		
		if(isSorted(arr)) println("sorted");
		if(!isSorted(arr)) println("not sorted");
		
	}
	
	private boolean isSorted(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] >= arr[i+1]) return false;
		}
		
		return true;
	}

}
