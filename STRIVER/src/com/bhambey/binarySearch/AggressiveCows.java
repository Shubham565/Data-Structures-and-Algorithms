package com.bhambey.binarySearch;

public class AggressiveCows {

	public static void main(String[] args) {
		int[] stalls = { 0, 3, 4, 7, 10, 9 };
		int k = 4;
		int ans = BinarySearchUtil.aggressiveCows(stalls, k);
		System.out.println("The maximum possible minimum distance is: " + ans);
	}

}
