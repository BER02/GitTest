import acm.program.*;
public class me extends ConsoleProgram {
 public void run() {
 println("This program converts integers to card ranks.");
 int n = readInt("Enter an integer between 1 and 13: ");
 switch (n) {
 case 1: println("Ace"); break;
 case 11: println("Jack"); break;
 case 12: println("Queen"); break;
 case 13: println("King"); break;
 default: println(n); break;
 }
 }
}
