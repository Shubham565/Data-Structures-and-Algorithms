package com.bhambey.sorting;


// best Case: O(n) - when the array is sorted
// Worst/Avg case: O(n^2) - when the array is random
// Maintains relative order - Stable
public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = { 13, 46, 24, 52, 20, 9 };
		int n = arr.length;
		System.out.println("Before Using insertion Sort: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		SortingUtil.insertion_sort(arr, n);

	}

}
