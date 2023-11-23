import acm.program.ConsoleProgram;

public class Problem47 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
		println(reverse(text));
	}
	
	private String reverse(String text) {
		String reversedText = "";
		for(int i = text.length() - 1; i >= 0; i--) {
			reversedText += text.charAt(i);
		}
		
		return reversedText;
	}

}
