package com.bhambey.binarySearch;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7 };
		int x = 6;
		int ind = BinarySearchUtil.searchInsertPosition(arr, x);
		System.out.println("The index is: " + ind);
	}

}
