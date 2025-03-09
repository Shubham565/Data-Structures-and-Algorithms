package com.bhambey.arrays;

import java.util.*;

public class SetMatricZeroes {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

		int n = matrix.size();
		int m = matrix.get(0).size();

		ArrayList<ArrayList<Integer>> ans = ArrayUtil.zeroMatrix(matrix, n, m);

		System.out.println("The Final matrix is: ");
		for (ArrayList<Integer> row : ans) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}

}
