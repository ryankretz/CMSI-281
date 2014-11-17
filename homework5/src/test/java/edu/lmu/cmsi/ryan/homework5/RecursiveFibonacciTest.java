package edu.lmu.cmsi.ryan.homework5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static edu.lmu.cmsi.ryan.homework5.RecursiveFibonacci.*;

public class RecursiveFibonacciTest {

	@Test //check to see if Fibonacci method returns the correct small fib number
	public void testSmallFib() {
		long first = RecursiveFibonacci.Fibonacci(0);
		assertEquals("failure - did not calculate first correctly", 0, first);
		long second = RecursiveFibonacci.Fibonacci(1);
		assertEquals("failure - did not calculate first correctly", 1, second);
	}

	@Test //check to see if Fibonacci method returns the correct big fib number
	public void testBigFib() {
		long thirtieth = RecursiveFibonacci.Fibonacci(30);
		assertEquals("failure - did not calculate first correctly", 832040, thirtieth);
		long twentieth = RecursiveFibonacci.Fibonacci(20);
		assertEquals("failure - did not calculate first correctly", 6765, twentieth);
	}


}