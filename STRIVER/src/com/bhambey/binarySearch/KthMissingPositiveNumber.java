package com.bhambey.binarySearch;

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        int ans = BinarySearchUtil.kthMissingPositiveNumber(vec, n, k);
        System.out.println("The missing number is: " + ans);
	}

}
