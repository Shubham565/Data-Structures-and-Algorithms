package com.bhambey.Recursion;

public class StringReverse {

	public static void main(String[] args) {
		String string1 = "Hello World";

		System.out.println("The Original String is: ");
		System.out.println(string1);

		String resultStr = RecursionUtil.reverseString(string1);

		System.out.println("String after reversal: ");
		System.out.println(resultStr);
	}

}
