package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumGoogle {

	public static void main(String[] args) {

		int[] arr = { 12, 1, 61, 5, 9, 2 };
		int k = 24;

		subsetRecursiveGoogle(0, 0, arr, k, new ArrayList<>());

	}

	private static void subsetRecursiveGoogle(int i, int sum, int[] arr, int k, List<Integer> list) {

		if (i == arr.length) {

			if (sum == k) {
				System.out.print(list);
			}
			return;
		}

		list.add(arr[i]);
		sum += arr[i];
		subsetRecursiveGoogle(i + 1, sum, arr, k, list);
		list.remove(list.size() - 1);
		sum -= arr[i];
		subsetRecursiveGoogle(i + 1, sum, arr, k, list);
	}

}
