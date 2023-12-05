import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

public class Problem50 extends ConsoleProgram{
	public void run() {
		int numOfWords = 0;
		String text = readLine("Enter text: ");
		StringTokenizer tokenizer = new StringTokenizer(text);
		while(tokenizer.hasMoreTokens()) {
			tokenizer.nextToken();
			numOfWords++;
		}
		println("Number of words: " + numOfWords);
	}

}
