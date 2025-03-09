package com.bhambey.arrays;

import java.util.*;

public class MajorityElementNThreeTimes {

	public static void main(String[] args) {

		int[] arr = { 11, 33, 12, 11, 21, 11 };
		List<Integer> ans = ArrayUtil.majorityElementNThreeTimes(arr);
		System.out.print("The majority elements are: ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();

	}

}
