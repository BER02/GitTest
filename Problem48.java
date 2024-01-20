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
		char ch = text.charAt(n);
		for(int i = 0; i < n; i++) {
			if(text.charAt(i) == ch) return false;
		}
		
		return true;
	}
}

//public class Problem48 extends ConsoleProgram{
//	public void run() {
//		String text = readLine("Enter the text to count statistics: ");
//		printCharStatistics(text);
//	}
//	
//	private void printCharStatistics(String text) {
//		for(int i = 0; i < text.length(); i++) {
//			char currCh = text.charAt(i);
//			if(isFirstOccurence(text, i)) {
//				int count = countSymbol(text, currCh);
//				println(currCh + ": " + count);
//			}
//		}	
//	}
//
//   //	mariami index = 4
//	private boolean isFirstOccurence(String text, int index) {
//		char ch = text.charAt(index); // 'a'
//		int firstIndex = text.indexOf(ch); // 1
//		return firstIndex == index;
//	}
//	
//   //	mariami 'a'
//   //	private boolean isFirstOccurence(String text, int index) {
//   //		for(int i = 0; i < index; i++) {
//   //			if(text.charAt(i) == text.charAt(index)) {
//   //				return false;
//   //			}
//   //		}
//   //		return true;
//   //	}
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
