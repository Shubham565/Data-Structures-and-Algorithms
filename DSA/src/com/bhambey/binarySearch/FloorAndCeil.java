package com.bhambey.binarySearch;

public class FloorAndCeil {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 4, 7, 8, 10 };
		int n = 6, x = 5;
		int[] ans = BinarySearchUtil.getFloorAndCeil(arr, n, x);
		System.out.println("The floor and ceil are: " + ans[0] + " " + ans[1]);
	}

}
