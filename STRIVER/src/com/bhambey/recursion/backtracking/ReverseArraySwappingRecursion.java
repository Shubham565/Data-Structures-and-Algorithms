package com.bhambey.recursion.backtracking;

public class ReverseArraySwappingRecursion {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 4, 7, 6, 8, 9 };
		reverseArray(0, arr.length, arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void reverseArray(int l, int n, int[] arr) {

		if (l >= n / 2)
			return;

		int temp = arr[l];
		arr[l] = arr[n - l - 1];
		arr[n - l - 1] = temp;

		reverseArray(l + 1, n, arr);
	}

}
