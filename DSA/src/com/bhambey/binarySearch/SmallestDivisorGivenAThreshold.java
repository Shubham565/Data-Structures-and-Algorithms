package com.bhambey.binarySearch;

public class SmallestDivisorGivenAThreshold {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = BinarySearchUtil.smallestDivisorGivenAThreshold(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
	}

}
