package com.bhambey.Recursion;

public class InvertPositionArray {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7 };

		int i = 0;

		RecursionUtil.invertPositionArray(arr, i);

		for (Integer n : arr) {
			System.out.print(n + " ");
		}

	}

}
