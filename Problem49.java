import acm.program.ConsoleProgram;

public class Problem49 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter number text: ");
		println(stringToInteger(text));
	}
	
	private int stringToInteger(String text) {
		int answer = 0;
		for(int i = 0; i < text.length(); i++) {
		  
			answer = answer * 10 + charToInteger(text.charAt(i));
		}
		
		return answer;
	}

	private int charToInteger(char ch) {
		return (int) ch - '0';
	}
}
