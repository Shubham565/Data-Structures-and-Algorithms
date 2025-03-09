package com.bhambey.striverGraphs;

/*
 * Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s 
 * (horizontally or vertically) forms an island.
 * Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
 * 
 * TC: O(M x N) + O(M x N x 4) + O(log(M x N))
 * SC: O(M x N)
 * */

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslandShapes {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1 } };
		NumberOfDistinctIslandShapes ob = new NumberOfDistinctIslandShapes();
		int count = ob.numberOfDistinctIslandShapes(grid);
		System.out.println(count);
	}

	private int numberOfDistinctIslandShapes(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		HashSet<ArrayList<String>> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					ArrayList<String> list = new ArrayList<>();
					dfs(i, j, grid, visited, list, i, j);
					set.add(list);
				}
			}
		}

		return set.size();
	}

	private void dfs(int row, int col, int[][] grid, int[][] visited, ArrayList<String> list, int row0, int col0) {
		visited[row][col] = 1;
		list.add(toString(row - row0, col - col0));
		int m = grid.length;
		int n = grid[0].length;

		int[] delrow = { -1, 0, 1, 0 };
		int[] delcol = { 0, -1, 0, 1 };

		for (int i = 0; i < 4; i++) {
			int nrow = row + delrow[i];
			int ncol = col + delcol[i];

			if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
				dfs(nrow, ncol, grid, visited, list, row0, col0);
			}

		}

	}

	private String toString(int r, int c) {
		return Integer.toString(r) + " " + Integer.toString(c);
	}

}
