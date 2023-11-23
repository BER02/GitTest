import acm.program.ConsoleProgram;

public class Problem45 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter the text: ");
		char symbol = readLine("Enter the symbol: ").charAt(0);
		
		int answer = 0;
		
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == symbol) answer++;
		}
		
		println("Number of symbol in text: " + answer);
	}

}
