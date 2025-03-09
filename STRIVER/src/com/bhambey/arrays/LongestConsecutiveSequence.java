package com.bhambey.arrays;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] a = { 100, 200, 1, 2, 3, 4 };
		int ans = ArrayUtil.longestConsecutiveSequence(a);
		System.out.println("The longest consecutive sequence is " + ans);
	}

}
