package com.bhambey.binarySearch;

public class MinimumDaysToMakeMBouquets {

	public static void main(String[] args) {
		int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
		int k = 3;
		int m = 2;
		int ans = BinarySearchUtil.minimumDaysToMakeMBouquets(arr, k, m);
		if (ans == -1)
			System.out.println("We cannot make m bouquets.");
		else
			System.out.println("We can make bouquets on day " + ans);
	}

}
