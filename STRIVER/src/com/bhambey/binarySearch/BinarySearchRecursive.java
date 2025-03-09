package com.bhambey.binarySearch;

public class BinarySearchRecursive {

	public static void main(String[] args) {

		int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
		int target = 6;
		int ind = BinarySearchUtil.binarySearchRecursive(a, target);
		if (ind == -1)
			System.out.println("The target is not present.");
		else
			System.out.println("The target is at index: " + ind);
	}

}
