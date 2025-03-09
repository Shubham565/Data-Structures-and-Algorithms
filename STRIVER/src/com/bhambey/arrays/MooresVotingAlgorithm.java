package com.bhambey.arrays;

public class MooresVotingAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2, 1, 1, 1 };
		int ans = ArrayUtil.majorityElement(arr);
		System.out.println("The majority element is: " + ans);

	}

}
