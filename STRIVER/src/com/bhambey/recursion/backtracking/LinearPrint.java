package com.bhambey.recursion.backtracking;

public class LinearPrint {

	public static void main(String[] args) {
		int n = 5;
		printLinearly(1, n);

	}

	public static void printLinearly(int i, int n) {

		if (i > n)
			return;

		System.out.print(i + " ");
		printLinearly(i + 1, n);
	}

}
