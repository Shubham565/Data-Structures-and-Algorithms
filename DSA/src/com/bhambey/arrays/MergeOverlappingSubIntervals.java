package com.bhambey.arrays;

import java.util.*;

public class MergeOverlappingSubIntervals {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		List<List<Integer>> ans = ArrayUtil.mergeOverlappingSubIntervals(arr);
		System.out.print("The merged intervals are: \n");
		for (List<Integer> it : ans) {
			System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
		}
		System.out.println();

	}

}
