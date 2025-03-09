package com.bhambey.striverGraphs;

/*
 * Problem Statement: Given a matrix mat of size M x N where every element is either ‘O’ or ‘X’.
 * Replace all ‘O’ with ‘X’ that is surrounded by ‘X’.
 * An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below,
 * just above just left, and just right of it.
 * 
 * TC: O(N) + O(M) + O(NxMx4) ~ O(N x M)
 * SC: ~ O(N x M)
 * */
public class SurroundedRegions {

	public static void main(String[] args) {

		char mat[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'O', 'X', 'X' },
				{ 'X', 'X', 'O', 'O' } };

		// n = 5, m = 4
		SurroundedRegions ob = new SurroundedRegions();
		int m = mat.length;
		int n = mat[0].length;
		char[][] ans = ob.fill(m, n, mat);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	private char[][] fill(int m, int n, char[][] mat) {

		int[] delrow = { -1, 0, 1, 0 };
		int[] delcol = { 0, 1, 0, -1 };

		int[][] visited = new int[m][n];

		for (int j = 0; j < n; j++) {
			if (visited[0][j] == 0 && mat[0][j] == 'O') {
				dfs(0, j, visited, mat, delrow, delcol);
			}
			if (visited[m - 1][j] == 0 && mat[m - 1][j] == 'O') {
				dfs(m - 1, j, visited, mat, delrow, delcol);
			}
		}

		for (int i = 0; i < m; i++) {
			if (visited[i][0] == 0 && mat[i][0] == 'O') {
				dfs(i, 0, visited, mat, delrow, delcol);
			}
			if (visited[i][n - 1] == 0 && mat[i][n - 1] == 'O') {
				dfs(i, n - 1, visited, mat, delrow, delcol);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0 && mat[i][j] == 'O') {
					mat[i][j] = 'X';
				}
			}
		}

		return mat;
	}

	private void dfs(int row, int col, int[][] visited, char[][] mat, int[] delrow, int[] delcol) {
		visited[row][col] = 1;
		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < 4; i++) {
			int nrow = row + delrow[i];
			int ncol = col + delcol[i];

			if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
				dfs(nrow, ncol, visited, mat, delrow, delcol);
			}
		}

	}

}
