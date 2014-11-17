package edu.lmu.cmsi.ryan.homework5;

public class RecursiveFibonacci {

	public static long Fibonacci(long n) {
		if (n == 0) { //first fib number is just 0
			return 0;
		} else if (n <= 2) { //second and third fib numbers are just 1
			return 1;
		} else { //formula to calculate a fib number
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
}