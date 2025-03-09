package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequencesForTargetSum {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1 };
		int n = arr.length;
		int target = 2;
		List<Integer> list = new ArrayList<>();
		printSubsequence(0, list, 0, target, arr, n);
	}

	private static void printSubsequence(int ind, List<Integer> list, int sum, int target, int[] arr, int n) {

		if (ind == n) {
			if (sum == target) {
				System.out.println(list);
			}
			return;
		}

		list.add(arr[ind]);
		sum += arr[ind];
		printSubsequence(ind + 1, list, sum, target, arr, n);
		sum -= arr[ind];
		list.remove(list.size() - 1);
		printSubsequence(ind + 1, list, sum, target, arr, n);
		return;

	}

}
