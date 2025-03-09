package com.bhambey.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		arr = Arrays.asList(new Integer[] { 4, 6, 2, 5, 7, 9, 1, 3 });
		int n = arr.size();
		System.out.println("Before Using insertion Sort: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		arr = SortingUtil.quickSort(arr);
		System.out.println("After insertion sort: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();

	}

}
