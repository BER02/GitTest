import acm.program.ConsoleProgram;

public class Problem45 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
		char symbol = readLine("Enter symbol: ").charAt(0);
		
		int answer = 0;
		
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == symbol) answer++;
		}
		
		println("Number of symbol in text: " + answer);
	}

}

//public class Problem45 extends ConsoleProgram{
//
//	public void run() {
//		String text = readLine("enter text: ");
//		char symbol = readLine("enter symbol: ").charAt(0);

//		println("Count: " + countSymbol(text, symbol));
//	}
//	
//	private int countSymbol(String text, char symbol) {
//		int symbolCount = 0;
//		for(int  i = 0; i < text.length(); i++) {
//			if(text.charAt(i) == symbol) {
//				symbolCount++; // symbolCount = symbolCount + 1;
//			}
//		}
//		return symbolCount;
//	}
//}
