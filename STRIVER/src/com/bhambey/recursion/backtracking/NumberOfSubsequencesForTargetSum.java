package com.bhambey.recursion.backtracking;

public class NumberOfSubsequencesForTargetSum {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1 };
		int n = arr.length;
		int target = 2;
		System.out.println(countSubsequences(0, 0, target, arr, n));

	}

	public static int countSubsequences(int i, int sum, int target, int[] arr, int n) {
		if (i == n) {
			if (sum == target) {
				return 1;
			} else
				return 0;
		}

		sum += arr[i];
		int l = countSubsequences(i + 1, sum, target, arr, n);
		sum -= arr[i];
		int r = countSubsequences(i + 1, sum, target, arr, n);

		return l + r;
	}

}
