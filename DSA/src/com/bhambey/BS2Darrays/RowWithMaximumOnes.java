package com.bhambey.BS2Darrays;

import java.util.*;

public class RowWithMaximumOnes {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

		int n = 3, m = 3;
		System.out.println("The row number with the maximum number of 1's is: " + BinarySearchMatrixUtil.rowWithMaximumOnes(matrix, n, m));
	}

}
