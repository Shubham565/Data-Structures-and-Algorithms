package com.bhambey.arrays;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
		int k = ArrayUtil.removeDuplicatesSortedArray(arr);
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
