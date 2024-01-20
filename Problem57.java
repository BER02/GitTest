import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem57 extends ConsoleProgram{
	public void run() {
		String word1 = readLine("Enter first word: ");
		String word2 = readLine("Enter second word: ");
		println(isAnagram(word1, word2));
	}
	
	private boolean isAnagram(String str1, String str2) {
		int[] arrayOfStr1 = numOfLetters(str1);
		int[] arrayOfStr2 =numOfLetters(str2);
		if(Arrays.equals(arrayOfStr1, arrayOfStr2)) return true;
		return false;
	}
	
	private int[] numOfLetters(String str) {
		int[] numOfLetters = new int[26];
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int locationOfChar = ch - 'a';
			numOfLetters[locationOfChar]++;
		}
		
		return numOfLetters;	
	}

}
