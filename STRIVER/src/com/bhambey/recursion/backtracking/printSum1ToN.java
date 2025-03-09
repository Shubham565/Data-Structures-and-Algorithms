package com.bhambey.recursion.backtracking;

public class printSum1ToN {

	public static void main(String[] args) {
		System.out.println(sum1ToN(5));

	}

	private static int sum1ToN(int i) {
		if (i == 0)
			return 0;

		return i + sum1ToN(i - 1);
	}

}
