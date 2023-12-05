import acm.program.ConsoleProgram;

public class Problem51 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
		String result = "";
		for(int i = 0; i < text.length(); i++) {
			if(result.indexOf(text.charAt(i)) != -1) result += text.charAt(i);
		}
		println(result);
	}

}
