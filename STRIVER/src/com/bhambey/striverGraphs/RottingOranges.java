package com.bhambey.striverGraphs;

import java.util.LinkedList;
import java.util.Queue;

// TC: O(N*M) + O(N*M*4) ~ O(N*M)
// SC: O(N*M)
public class RottingOranges {

	public static void main(String[] args) {

		int[][] grid = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };

		RottingOranges obj = new RottingOranges();
		int ans = obj.orangesRotting(grid);
		System.out.println(ans);

	}

	private int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		Queue<Pair> q = new LinkedList<>();

		int[][] visited = new int[m][n];

		int countFresh = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pair(i, j, 0));
					visited[i][j] = 2;
				} else {
					visited[i][j] = 0;
				}

				if (grid[i][j] == 1)
					countFresh++;
			}
		}

		int tm = 0;
		int[] delRow = { -1, 0, 1, 0 };
		int[] delCol = { 0, 1, 0, -1 };
		int cnt = 0;

		while (!q.isEmpty()) {
			Pair p = q.remove();

			int r = p.row;
			int c = p.col;
			int t = p.tm;

			tm = Math.max(tm, t);

			for (int i = 0; i < 4; i++) {
				int nrow = r + delRow[i];
				int ncol = c + delCol[i];

				if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0
						&& grid[nrow][ncol] == 1) {
					q.add(new Pair(nrow, ncol, t + 1));
					visited[nrow][ncol] = 2;
					cnt++;
				}

			}
		}
		if (cnt != countFresh)
			return -1;
		return tm;
	}

}

class Pair {
	int row;
	int col;
	int tm;

	public Pair(int row, int col, int tm) {
		this.row = row;
		this.col = col;
		this.tm = tm;
	}
}
