package com.bhambey.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingUtil {

	static void bubbleSort(int[] input, int size) {
		for (int i = size - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (input[j] > input[j + 1]) {
					int tmp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = tmp;
				}
			}
		}
	}

// MergeSort using auxillary array
// Time Complexity: O(nlogn) in all cases
// Space Complexity: O(n)
// Auxiliary Space Complexity: O(n)

	static void mergeSortArray(int start, int end, int[] input, int[] scratch) {

		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;

		// sort first half
		mergeSortArray(start, mid, input, scratch);

		// sort second half
		mergeSortArray(mid + 1, end, input, scratch);

		// merge the two sorted arrays
		int i = start;
		int j = mid + 1;
		int k;

		for (k = start; k <= end; k++) {
			scratch[k] = input[k];
		}

		k = start;
		while (k <= end) {

			if (i <= mid && j <= end) {
				input[k] = Math.min(scratch[i], scratch[j]);

				if (input[k] == scratch[i]) {
					i++;
				} else {
					j++;
				}
			} else if (i <= mid && j > end) {
				input[k] = scratch[i];
				i++;
			} else {
				input[k] = scratch[j];
				j++;
			}
			k++;
		}
	}

// Merge Sort using ArrayList as auxillary DS
// Time Complexity: O(nlogn) in all cases
// Space Complexity: O(n)
// Auxiliary Space Complexity: O(n)

	static void mergeSortArrayList(int start, int end, int[] input) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		mergeSortArrayList(start, mid, input);
		mergeSortArrayList(mid + 1, end, input);
		merge(input, start, mid, end);
	}

	static void merge(int[] input, int start, int mid, int end) {
		ArrayList<Integer> scratch = new ArrayList<>();
		int left = start;
		int right = mid + 1;

		while (left <= mid && right <= end) {
			if (input[left] <= input[right]) {
				scratch.add(input[left]);
				left++;
			} else {
				scratch.add(input[right]);
				right++;
			}
		}

		while (left <= mid) {
			scratch.add(input[left]);
			left++;
		}

		while (right <= end) {
			scratch.add(input[right]);
			right++;
		}

		for (int i = start; i < end; i++) {
			input[i] = scratch.get(i - start);
		}

	}

// Worst Case: O(n^2)
	static void selection_sort(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		System.out.println("After selection sort:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	// Average/Worst: O(n^2)
	public static void insertion_sort(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
		System.out.println("After Insertion Sort: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static List<Integer> quickSort(List<Integer> arr) {
		quickSortImpl(arr, 0, arr.size() - 1);
		return arr;
	}

	private static void quickSortImpl(List<Integer> arr, int low, int high) {
		if (low < high) {
			int pIndex = partition(arr, low, high);
			quickSortImpl(arr, low, pIndex - 1);
			quickSortImpl(arr, pIndex + 1, high);
		}
	}

	private static int partition(List<Integer> arr, int low, int high) {
		int pivot = arr.get(low);
		int i = low;
		int j = high;

		while (i < j) {
			while (arr.get(i) <= pivot && i <= high - 1) {
				i++;
			}
			while (arr.get(j) > pivot && j >= low + 1) {
				j--;
			}
			if (i < j) {
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		int temp = arr.get(low);
		arr.set(low, arr.get(j));
		arr.set(j, temp);
		return j;
	}

}
