package com.bhambey.Recursion;

public class MergeStringsLexicalOrder {

	public static void main(String[] args) {
		String one = "adz";
		String two = "bfx";
		String answer = RecursionUtil.alphabeticMerge(one, two);
		System.out.println(answer);
	}

}
