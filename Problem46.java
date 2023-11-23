import acm.program.ConsoleProgram;

public class Problem46 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
		
		int count = 0;
		char answer = ' ';
		for(int i = 0; i < text.length(); i++) {
			int number = 0;
			for(int j = 0; j < text.length(); j++) {
				if(text.charAt(j) == text.charAt(i)) number++;
			}
			
			if(number >= count) {
				count = number;
				answer = text.charAt(i);
			}
		}
		
		println(answer);
	}

}
