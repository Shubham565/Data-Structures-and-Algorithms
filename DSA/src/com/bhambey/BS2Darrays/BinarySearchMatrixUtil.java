package com.bhambey.BS2Darrays;

import java.util.ArrayList;

public class BinarySearchMatrixUtil {

	private static int lowerBoundOfOnes(ArrayList<Integer> arr, int m, int x) {

		int low = 0, high = m - 1;
		int ans = m;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr.get(mid) >= x) {
				high = mid - 1;
				ans = mid;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int rowWithMaximumOnes(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

		/*
		 * Time Complexity: O(n X logm), where n = given row number, m = given column
		 * number.
		 * 
		 * Reason: We are using a loop running for n times to traverse the rows. Then we
		 * are applying binary search on each row with m columns.
		 * 
		 * Space Complexity: O(1) as we are not using any extra space.
		 */
		
		int countMaxOnes = 0;
		int index = -1;

		for (int i = 0; i < n; i++) {
			int countOnesInGivenRow = m - lowerBoundOfOnes(matrix.get(i), m, 1);

			if (countOnesInGivenRow > countMaxOnes) {
				countMaxOnes = countOnesInGivenRow;
				index = i;
			}
		}
		return index;
	}

	
	public static boolean searchInSorted2DMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {

		/*
		 * Time Complexity: O(log(NxM)), where N = given row number, M = given column
		 * number.
		 * 
		 * Reason: We are applying binary search on the imaginary 1D array of size NxM.
		 * 
		 * Space Complexity: O(1) as we are not using any extra space.
		 */
		
		int n = matrix.size();
		int m = matrix.get(0).size();

		int low = 0, high = (n * m - 1);

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int row = mid / m, col = mid % m;

			if (matrix.get(row).get(col) == target) {
				return true;
			} else if (matrix.get(row).get(col) < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return false;
	}

	
	public static boolean searchInRowAndColumnSortedMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {

		int n = matrix.size();
		int m = matrix.get(0).size();

		int row = 0, col = m - 1;

		while (row < n && col >= 0) {
			if (matrix.get(row).get(col) == target)
				return true;
			else if (matrix.get(row).get(col) < target)
				row++;
			else
				col--;
		}

		return false;
	}

	private static int upperBound(int[] arr, int x, int n) {

		int low = 0, high = n - 1;
		int ans = n;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] > x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int countSmallEqual(int[][] matrix, int m, int n, int x) {

		int count = 0;

		for (int i = 0; i < m; i++) {
			count += upperBound(matrix[i], x, n);
		}

		return count;
	}

	public static int medianInRowWiseSortedMatrix(int[][] matrix, int m, int n) {

		/*
		 * Time Complexity: O(log(109)) X O(M(logN)), where M = number of rows in the
		 * given matrix, N = number of columns in the given matrix
		 * 
		 * Reason: Our search space lies between [0, 109] as the min(matrix) can be 0
		 * and the max(matrix) can be 109. We are applying binary search in this search
		 * space and it takes O(log(109)) time complexity. Then we call
		 * countSmallEqual() function for every ‘mid’ and this function takes O(M(logN))
		 * time complexity.
		 * 
		 * Space Complexity : O(1) as we are not using any extra space
		 */

		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

		for (int i = 0; i < m; i++) {
			low = Math.min(low, matrix[i][0]);
			high = Math.max(high, matrix[i][n - 1]);
		}

		int req = (m * n) / 2;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int smallEqual = countSmallEqual(matrix, m, n, mid);
			if (smallEqual <= req)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return low;
	}
	
	
	
}
