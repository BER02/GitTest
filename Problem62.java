import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class Problem62 extends ConsoleProgram{
	private static final String SENTINEL = "";
	
	public void run() {
		Map<String, Integer> nameCount = new HashMap<String, Integer>();
		while(true) {
			String name = readLine("Enter name: ");
			if(name.equals(SENTINEL)) break;
			
			if(nameCount.get(name) == null) {
				nameCount.put(name, 0);
			}
			
			int currCount = nameCount.get(name);
			nameCount.put(name, currCount + 1);
			
		}
		
		println(nameCount);
	}
}
