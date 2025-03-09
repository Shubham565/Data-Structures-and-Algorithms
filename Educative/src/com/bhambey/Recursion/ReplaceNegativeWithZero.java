package com.bhambey.Recursion;

public class ReplaceNegativeWithZero {

	public static void main(String[] args) {

		int[] arr = { -1, 4, 5, 7, 9, 3, -4, 6, 8, -1, 30, -65 };
		RecursionUtil.replaceNegativeWithZero(arr, 0);

		for (Integer i : arr) {
			System.out.print(i + " ");
		}

	}

}
