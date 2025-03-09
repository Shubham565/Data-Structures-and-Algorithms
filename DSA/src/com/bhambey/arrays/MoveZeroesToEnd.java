package com.bhambey.arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
		int n = 10;
		int[] ans = ArrayUtil.moveZerosToEnd(n, arr);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println("");

	}

}
