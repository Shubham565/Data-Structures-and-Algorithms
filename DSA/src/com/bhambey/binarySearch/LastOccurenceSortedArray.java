package com.bhambey.binarySearch;

public class LastOccurenceSortedArray {

	public static void main(String[] args) {
		int n = 7;
		int target = 13;
		int[] arr = { 3, 4, 13, 13, 13, 20, 40 };

		// returning the last occurrence index if the element is present otherwise -1
		System.out.println(BinarySearchUtil.lastOccurenceSortedArray(arr, target, n));
	}

}
