package edu.lmu.cmsi.ryan.homework5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static edu.lmu.cmsi.ryan.homework5.BalancedParanthesis.*;

public class BalancedParanthesisTest {

	@Test //check balanced strings
	public void balancedTest() {
		String balanced = "()()[]([])";
		String balanced_1 = "(()[])";
		assertEquals("failure - did not check balanced string correctly", true, BalancedParanthesis.checkBalance(balanced));
		assertEquals("failure - did not check balanced string correctly", true, BalancedParanthesis.checkBalance(balanced_1));
	}

	@Test //check unbalanced strings
	public void unbalancedTest() {
		String unbalanced = "([)]";
		String unbalanced_1 = "[(])";
		assertEquals("failure - did not check unbalanced string correctly", false, BalancedParanthesis.checkBalance(unbalanced));
		assertEquals("failure - did not check unbalanced string correctly", false, BalancedParanthesis.checkBalance(unbalanced_1));
	}

}