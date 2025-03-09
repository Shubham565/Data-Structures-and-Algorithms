package com.bhambey.graphs;

import java.util.LinkedList;
import java.util.Queue;

// TC:  O(NxM + NxMx4) ~ O(N x M)
// SC: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
public class DistanceOfNearestCellHavingOne {

	public static void main(String[] args) {

		int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };

		DistanceOfNearestCellHavingOne obj = new DistanceOfNearestCellHavingOne();
		int[][] ans = obj.nearest(grid);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	private int[][] nearest(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		int[][] dist = new int[m][n];
		Queue<Cell> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					q.add(new Cell(i, j, 0));
					visited[i][j] = 1;
				} else {
					visited[i][j] = 0;
				}
			}
		}

		int[] delrow = { 1, 0, -1, 0 };
		int[] delcol = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			Cell curr = q.remove();

			int row = curr.row;
			int col = curr.col;
			int distance = curr.distance;

			dist[row][col] = distance;

			for (int i = 0; i < 4; i++) {
				int nrow = row + delrow[i];
				int ncol = col + delcol[i];

				if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0) {
					q.add(new Cell(nrow, ncol, distance + 1));
					visited[nrow][ncol] = 1;
				}

			}

		}

		return dist;
	}

	class Cell {
		int row;
		int col;
		int distance;

		public Cell(int _row, int _col, int _distance) {
			row = _row;
			col = _col;
			distance = _distance;
		}

	}

}
