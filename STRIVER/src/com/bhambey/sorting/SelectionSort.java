package com.bhambey.sorting;


// Best, Average, and Worst Case: O(n^2)
// Performance is not influenced by the initial order of elements.
// Not stable: Does not maintain the relative order of equal elements.
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 13, 46, 24, 52, 20, 9 };
		int n = arr.length;
		System.out.println("Before selection sort:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		SortingUtil.selection_sort(arr, n);
	}

}
