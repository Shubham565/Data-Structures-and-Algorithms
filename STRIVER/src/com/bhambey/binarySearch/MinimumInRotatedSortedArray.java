package com.bhambey.binarySearch;

public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int ans = BinarySearchUtil.minimumInRotatedSortedArray(arr);
		System.out.println("The minimum element is: " + ans);
	}

}
