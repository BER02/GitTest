/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {

	public void run() {
		println("This program adds two integers."); // prints line
		int n1 = readInt("Enter n1: "); // reads ints + text
		int n2 = readInt("Enter n2: ");
		int total = n1 + n2; // sum of two int 
		println("The total is " + total + "."); // prints sum + text
		int n3 = readInt();
		int total1 = n1 + n2 + n3;
		println(total1);
		double n4 = readDouble();
		double total2 = n1 + n2 + n3 + n4;
		println(total2);
		println(n1 * n2); 
		println(CENTIMETERS_PER_INCH);
		/*
		 * multiply = *
		 * sum = +
		 * difference = -
		 * division = / 
		 * 
		 */
	}
	private static final int CENTIMETERS_PER_INCH = 2; // creates constant
}
