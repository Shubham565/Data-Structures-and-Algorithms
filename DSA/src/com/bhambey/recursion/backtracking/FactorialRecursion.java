package com.bhambey.recursion.backtracking;

public class FactorialRecursion {

	public static void main(String[] args) {
		System.out.println(sum1ToN(6));

	}

	private static int sum1ToN(int i) {
		if (i == 0)
			return 1;

		return i * sum1ToN(i - 1);
	}

}
