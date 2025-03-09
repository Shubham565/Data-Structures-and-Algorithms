package com.bhambey.binarySearch;

public class ImplementUpperBound {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 9, 15, 19 };
		int n = 6, x = 9;
		int ind = BinarySearchUtil.implementUpperBound(arr, n, x);
		System.out.println("The upper bound is the index: " + ind);
	}

}
