package com.bhambey.strings;

public class MaximumNestingParenthesis {

	public static void main(String[] args) {

		String s = "(1+(2*3)+((8)/4))+1";
		
		System.out.println("Maximum Nesting depth of the parenthesis is: " + StringsUtil.maximumNestingParenthesis(s));
		
	}

}
