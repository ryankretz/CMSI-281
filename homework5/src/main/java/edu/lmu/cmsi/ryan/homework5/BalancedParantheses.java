package edu.lmu.cmsi.ryan.homework5;

import java.util.Stack;

public class BalancedParantheses {
	private static final char LEFT_PAREN = '(';
	private static final char RIGHT_PAREN = ')';
	private static final char LEFT_BRACK = '[';
	private static final char RIGHT_BRACK = ']';

	public static boolean checkBalance(String s) {
		if ((s.length() % 2) != 0) {
			return false;
		} else {
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if(curr == LEFT_PAREN) { //if opening bracket, push it ontot the stack
					stack.push(curr);
				} else if(curr == LEFT_BRACK) { 
					stack.push(curr);
				} else if(curr == RIGHT_PAREN) { //if closing parenthesis
					
					if(stack.empty()) { //and stack is empty, return false
						return false;
					} 
					
					if(stack.pop() != LEFT_PAREN) { //and what is at the top of the stack
						return false;				//is not equal to a LEFT_PAREN, return false
					} 
				} else if(curr == RIGHT_BRACK) { //if closing bracket
					
					if(stack.empty()) { //and stack is empty, return false
						return false;
					} 
					
					if(stack.pop() != LEFT_BRACK) { //and what is at the top of the stack
						return false;				//is not equal to a LEFT_BRACK, return false
					}
				}
			}
			return stack.empty(); 
		}
	}
}