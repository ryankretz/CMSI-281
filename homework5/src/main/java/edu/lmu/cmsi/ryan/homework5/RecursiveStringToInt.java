package edu.lmu.cmsi.ryan.homework5;

public class RecursiveStringToInt {
	static int num = 0;
	static int index  = 0;

	public static int StringToInt(String s) {
		if (s.length() == 1) {
			return (num * 10) + Integer.parseInt(s.substring(0,1));
		} else {
			num = (num * 10) + Integer.parseInt(s.substring(0,1));
			return StringToInt(s.substring(1, s.length()));
		}
	}
}