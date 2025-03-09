package com.bhambey.arrays;

import java.util.*;

public class PrintPascalTriangle {

	public static void main(String[] args) {

		int n = 5;
		List<List<Integer>> ans = ArrayUtil.printPascalTriangle(n);
		for (List<Integer> it : ans) {
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}

}
