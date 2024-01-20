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

//public void run() {
//	String text = readLine("Enter text: ");
//	println("Frequent symbol is: " + frequentSymbol(text));
//}
//
//private char frequentSymbol(String text) {
//	int maxCharCount = 0;
//	char frequentChar = 0; // does not equal to char '0'
//	
//	for (int i = 0; i < text.length(); i++) {
//		int currCount = countSymbol(text, text.charAt(i));
//		if(currCount > maxCharCount) {
//			maxCharCount = currCount;
//			frequentChar = text.charAt(i);
//		}
//	}
//	return frequentChar;
//}
//
//private int countSymbol(String text, char symbol) {
//	int symbolCount = 0;
//	for (int i = 0; i < text.length(); i++) {
//		if (text.charAt(i) == symbol) {
//			symbolCount++; // symbolCount = symbolCount + 1;
//		}
//	}
//	return symbolCount;
//}
