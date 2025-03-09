package com.bhambey.arrays;

import java.util.*;

public class NextGreaterPermutation {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 2, 1, 5, 4, 3, 0, 0 });
		List<Integer> ans = ArrayUtil.nextGreaterPermutation(A);

		System.out.print("The next permutation is: [");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println("]");

	}

}
