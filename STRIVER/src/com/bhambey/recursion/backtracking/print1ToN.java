package com.bhambey.recursion.backtracking;

public class print1ToN {

	public static void main(String[] args) {
		print1ToN(5);

	}

	private static void print1ToN(int i) {

		if (i <= 0)
			return;
		System.out.println(i);
		print1ToN(i - 1);
	}

}
