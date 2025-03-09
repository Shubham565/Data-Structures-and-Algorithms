package com.bhambey.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length - 1;
		System.out.println(binarySearch(arr, 0, n, 4));
	}

	private static int binarySearch(int[] arr, int start, int end, int x) {

		if (end >= start) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == x)
				return mid;

			if (arr[mid] > x)
				return binarySearch(arr, start, mid - 1, x);

			return binarySearch(arr, mid + 1, end, x);
		}

		return -1;
	}

}
