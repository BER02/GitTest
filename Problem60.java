import java.util.ArrayList;

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
	}

}
