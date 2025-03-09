package com.bhambey.binarySearch;

public class SearchInRotatedArrayDuplicates {

	public static void main(String[] args) {
		int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
		int k = 9;
		boolean ans = BinarySearchUtil.searchInRotatedArrayDuplicates(arr, k);
		if (ans == false)
			System.out.println("Target is not present.");
		else
			System.out.println("Target is present in the array.");
	}

}
