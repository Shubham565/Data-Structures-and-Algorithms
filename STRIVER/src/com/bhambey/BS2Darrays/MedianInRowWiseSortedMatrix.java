package com.bhambey.BS2Darrays;

public class MedianInRowWiseSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 8, 9, 11, 12, 13 }, { 21, 23, 25, 27, 29 } };
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = BinarySearchMatrixUtil.medianInRowWiseSortedMatrix(matrix, m, n);
		System.out.println("The median element is: " + ans);
	}

}
