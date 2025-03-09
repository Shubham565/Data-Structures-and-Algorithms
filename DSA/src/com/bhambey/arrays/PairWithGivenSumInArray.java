package com.bhambey.arrays;

public class PairWithGivenSumInArray {

	public static void main(String[] args) {

		int[] arr = {1, 2, 5, 6, 8, 7, 28};
		int target = 12;
		boolean res = ArrayUtil.twoSum(arr, target);
		System.out.println(res == true ? "YES" : "NO");
		
	}

}
