package com.bhambey.binarySearch;

public class FindKRotation {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int ans = BinarySearchUtil.findKRotation(arr);
		System.out.println("The array is rotated " + ans + " times.");

	}

}
