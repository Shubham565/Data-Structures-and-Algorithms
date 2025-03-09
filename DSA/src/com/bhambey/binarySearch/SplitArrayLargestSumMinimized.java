package com.bhambey.binarySearch;

public class SplitArrayLargestSumMinimized {

	public static void main(String[] args) {

		int[] a = { 10, 20, 30, 40 };
		int k = 2;
		int ans = BinarySearchUtil.splitArrayLargestSumMinimized(a, k);
		System.out.println("The answer is: " + ans);

	}

}
