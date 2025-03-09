package com.bhambey.arrays;

import java.util.*;

public class FourSum {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target = 9;
		List<List<Integer>> ans = ArrayUtil.fourSum(nums, target);
		System.out.println("The quadruplets are: ");
		for (List<Integer> it : ans) {
			System.out.print("[");
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.print("] ");
		}
		System.out.println();
	}

}
