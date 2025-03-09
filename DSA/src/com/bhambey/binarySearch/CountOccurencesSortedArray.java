package com.bhambey.binarySearch;

public class CountOccurencesSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
		int n = 8, x = 8;
		int ans = BinarySearchUtil.countOccurencesSortedArray(arr, n, x);
		System.out.println("The number of occurrences is: " + ans);
	}

}
