package com.bhambey.Recursion;

public class StringPermutations {

	public static void main(String[] args) {

		String s = "abc";
		char[] carr = s.toCharArray();
		int len = carr.length;
		System.out.println("String Permutations for given string: ");
		RecursionUtil.stringPermutations(carr, len);

	}

}
