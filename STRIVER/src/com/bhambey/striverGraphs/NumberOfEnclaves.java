package com.bhambey.striverGraphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Statement: You are given an N x M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Find the number of land cells in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 * 
 * TC: O(NxMx4) ~ O(N x M), For the worst case, assuming all the pieces as land, 
 * 		the BFS function will be called for (N x M) nodes and for every node, 
 * 		we are traversing for 4 neighbors, so it will take O(N x M x 4) time. 
 * SC:  O(N x M), O(N x M) for the visited array, and queue space takes up N x M locations at max. 
 * 
 * */

public class NumberOfEnclaves {

	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };

		NumberOfEnclaves ob = new NumberOfEnclaves();
		int ans = ob.numberOfEnclaves(grid);
		System.out.println(ans);
	}

	private int numberOfEnclaves(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		Queue<Pair> q = new LinkedList<>();
		int[][] visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
					if (grid[i][j] == 1) {
						q.add(new Pair(i, j));
						visited[i][j] = 1;
					}
				}
			}
		}

		int[] delrow = { 0, 1, 0, -1 };
		int[] delcol = { 1, 0, -1, 0 };

		while (!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.peek().col;
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nrow = row + delrow[i];
				int ncol = col + delcol[i];

				if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0
						&& grid[nrow][ncol] == 1) {
					q.add(new Pair(nrow, ncol));
					visited[nrow][ncol] = 1;
				}
			}

		}

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && visited[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

	class Pair {
		int row;
		int col;

		public Pair(int _row, int _col) {
			row = _row;
			col = _col;
		}
	}

}
