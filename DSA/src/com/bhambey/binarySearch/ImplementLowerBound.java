package com.bhambey.binarySearch;

public class ImplementLowerBound {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 15, 19 };
		int n = 5, x = 9;
		int ind = BinarySearchUtil.implementLowerBound(arr, n, x);
		System.out.println("The lower bound is the index: " + ind);
	}

}
