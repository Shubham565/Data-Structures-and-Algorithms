package com.bhambey.arrays;

public class RotateArrayKElements {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		int k = 3;
		ArrayUtil.RotateKRight(arr, n, k);
		System.out.println("After Rotating the elements to right ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
