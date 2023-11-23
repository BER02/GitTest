import acm.program.ConsoleProgram;

public class Problem48 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
		charStatistics(text);
	}
	
	private void charStatistics(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(notChecked(text, i)) {
				println(text.charAt(i) + ": " + charCount(text, text.charAt(i)));
			}
		}
			
	}
	
	private int charCount(String text, char ch) {
		int answer = 0;
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ch) answer++;
		}
		
		return answer;
	}
	
	private boolean notChecked(String text, int n) {
		char currChar = text.charAt(n);
		for(int i = 0; i < n; i++) {
			if(text.charAt(i) == currChar) return false;
		}
		
		return true;
	}
	

}
