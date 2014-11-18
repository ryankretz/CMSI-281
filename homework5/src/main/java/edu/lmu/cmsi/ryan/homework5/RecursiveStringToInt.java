package edu.lmu.cmsi.ryan.homework5;

/*public class RecursiveStringToInt {

	public static int StringToInt(String s) {
		if (s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return Integer.parseInt(s);
		} else {
			return (StringToInt(s.substring(0,s.length() - 2)) * 10) + Integer.parseInt(s.substring(s.length() - 1, s.length()));
		}
	}
}*/

public class RecursiveStringToInt {

	public static int StringToInt(String s) {
		int num = s.length();
		if (s.isEmpty()) {
			return 0; //if string is empty, return 0
		} else if(s.length() == 1) {
			return Integer.parseInt(s); //convert single character to number
		} else {
			return StringToInt(s.substring(num - 1, num)) + StringToInt(s.substring(0, num - 1)) * 10;
		}
	}
}