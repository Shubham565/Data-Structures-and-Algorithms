package com.bhambey.arrays;

public class LeftRotateByOnePosition {

	public static void main(String[] args) {

		int n = 5;

		int arr[] = { 1, 2, 3, 4, 5 };
		ArrayUtil.leftRotateByOnePosition(arr, n);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
