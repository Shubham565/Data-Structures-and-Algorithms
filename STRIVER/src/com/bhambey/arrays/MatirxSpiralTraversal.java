package com.bhambey.arrays;

import java.util.*;

public class MatirxSpiralTraversal {

	public static void main(String[] args) {

		// Matrix initialization.
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		List<Integer> ans = ArrayUtil.printSpiral(mat);

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

		System.out.println();

	}

}
