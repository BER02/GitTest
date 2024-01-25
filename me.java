import java.util.*;

import acm.program.ConsoleProgram;

public class me extends ConsoleProgram{	
	public void run() {
		int[] arr = {3, -2, 3, 6, 1};
		int[] sortedArr = arr;
		Arrays.sort(sortedArr);
		println(Arrays.toString(sortedArr));
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		String tornike = "tornike";
		map.put(tornike, new ArrayList<String>());
		map.get(tornike).add("lizi");
		println(map.get(tornike));
	}
}