package com.bhambey.Recursion;

public class StringPalindrome {

	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = "dadad";
		boolean answer1 = RecursionUtil.isPalindrome(s1);
		boolean answer2 = RecursionUtil.isPalindrome(s2);
		System.out.println("Is " + s1 + " a Palindrome? = " + answer1);
		System.out.println("Is " + s2 + " a Palindrome? = " + answer2);

	}

}
