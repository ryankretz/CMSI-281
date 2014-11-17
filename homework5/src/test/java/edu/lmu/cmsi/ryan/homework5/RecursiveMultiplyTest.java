package edu.lmu.cmsi.ryan.homework5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static edu.lmu.cmsi.ryan.homework5.RecursiveMultiply.*;

public class RecursiveMultiplyTest {
	
	@Test //test inputs with 0
	public void zeroInputsTest() {
		assertEquals("failure - did not multiply with zero correctly",0, RecursiveMultiply.Multiply(0,5));
		assertEquals("failure - did not multiply with zero correctly",0, RecursiveMultiply.Multiply(5,0));
		assertEquals("failure - did not multiply with zero correctly",0, RecursiveMultiply.Multiply(0,0));
	}

	@Test //test inputs with 0
	public void otherInputTest() {
		assertEquals("failure - did not multiply with zero correctly",25, RecursiveMultiply.Multiply(5,5));
		assertEquals("failure - did not multiply with zero correctly",5920, RecursiveMultiply.Multiply(80,74));
		assertEquals("failure - did not multiply with zero correctly", 26915, RecursiveMultiply.Multiply(35,769));
	}
}