package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AnySubsequenceForTargetSum {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1 };
		int n = arr.length;
		int target = 2;
		List<Integer> list = new ArrayList<>();
		printSubsequence(0, list, 0, target, arr, n);
	}

	private static boolean printSubsequence(int i, List<Integer> list, int sum, int target, int[] arr, int n) {

		if (i == n) {
			if (sum == target) {
				System.out.println(list);
				return true;
			} else
				return false;
		}

		list.add(arr[i]);
		sum += arr[i];
		if (printSubsequence(i + 1, list, sum, target, arr, n))
			return true;

		list.remove(list.size() - 1);
		sum -= arr[i];
		if (printSubsequence(i + 1, list, sum, target, arr, n))
			return true;

		return false;

	}

}
