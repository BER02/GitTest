import acm.program.ConsoleProgram;

public class Problem54 extends ConsoleProgram{
	public void run() {
		int n = readInt("# of numbers: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = readInt("Enter number: ");
		}
		
		int biggest1 = arr[0];
		int biggest2 = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > biggest1) {
				biggest2 = biggest1;
				biggest1 = arr[i];
			} else if(arr[i] > biggest2) {
				biggest2 = arr[i];
			}
		}
		
		println(biggest1);
		println(biggest2);
		
	}

}
