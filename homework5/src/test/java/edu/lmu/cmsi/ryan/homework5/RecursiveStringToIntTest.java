package edu.lmu.cmsi.ryan.homework5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static edu.lmu.cmsi.ryan.homework5.RecursiveStringToInt.*;

public class RecursiveStringToIntTest {

	@Test  //convert big string to int
	public void bigStringToIntTest() {
		String bigString = "89753";
		assertEquals("failure - did not convert big string to integer", 89753, RecursiveStringToInt.StringToInt(bigString));
	}

	@Test   //convert small string to int. Also tests if string is empty
	public void smallStringToIntTest() {
		String smallString = "123";
		String emptyString = "";
		assertEquals("failure - did not convert small string to integer", 123, RecursiveStringToInt.StringToInt(smallString));
		assertEquals("failure - did not convert empty string to 0", 0, RecursiveStringToInt.StringToInt(emptyString));
	}


}