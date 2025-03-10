package com.bhambey.binarySearch;

import java.util.*;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
		int n = 9, k = 1;
		int ans = BinarySearchUtil.searchInRotatedSortedArray(arr, n, k);
		if (ans == -1)
			System.out.println("Target is not present.");
		else
			System.out.println("The index is: " + ans);

	}

}
