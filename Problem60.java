import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem60 extends ConsoleProgram{ 
	private static final int SENTINEL = -1;
	public void run() {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while(true) {
			int n = readInt("Enter number: ");
			if(n == SENTINEL) break;
			numList.add(n);
		}
		for(int i = 1; i <= numList.size(); i ++) {
			println(numList.get(numList.size() - i));
		}
		println(numList);
		int[] arr = new int[4];
		String str = Arrays.toString(arr);
		println(str);
		int[] arr2 = {1, 5, -1, 14, 0};
		Arrays.sort(arr2);
		println(Arrays.toString(arr2));
	}

}
