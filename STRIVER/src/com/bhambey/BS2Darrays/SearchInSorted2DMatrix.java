package com.bhambey.BS2Darrays;

import java.util.*;

public class SearchInSorted2DMatrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
		matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

		boolean result = BinarySearchMatrixUtil.searchInSorted2DMatrix(matrix, 17);
		System.out.println(result ? "true" : "false");
	}

}
