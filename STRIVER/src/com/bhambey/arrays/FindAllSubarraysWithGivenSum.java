package com.bhambey.arrays;

public class FindAllSubarraysWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
		int k = 6;
		int cnt = ArrayUtil.findAllSubarraysWithGivenSum(arr, k);
		System.out.println("The number of subarrays is: " + cnt);
	}

}
