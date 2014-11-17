package edu.lmu.cmsi.ryan.homework5;

public class RecursiveMultiply {

	public static int Multiply(int first, int second) {
		if (first == 0 || second == 0) { //if one of the numbers is 0, return 0
			return 0;
		} else { //recursive method to multiply two numbers
			return first + Multiply(first, second - 1);
		}
	}
}