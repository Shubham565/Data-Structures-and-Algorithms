package com.bhambey.striverGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		NumberOfIslandsDFS I = new NumberOfIslandsDFS();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

	public int countIslands(int[][] M) {

		int m = M.length;
		int n = M[0].length;
		boolean[][] visited = new boolean[m][n];
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1 && !visited[i][j]) {
					count++;
					bfs(i, j, M, visited);
				}
			}
		}
		return count;
	}

	public void bfs(int row, int col, int[][] M, boolean[][] visited) {

		Queue<Pair> q = new LinkedList<>();
		visited[row][col] = true;
		q.add(new Pair(row, col));
		int m = M.length;
		int n = M[0].length;

		while (!q.isEmpty()) {
			int qRow = q.peek()._row;
			int qCol = q.peek()._col;
			q.remove();

			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int nRow = qRow + i;
					int nCol = qCol + j;
					if (nRow < m && nRow >= 0 && nCol < n && nCol >= 0 && M[nRow][nCol] == 1
							&& visited[nRow][nCol] == false) {
						visited[nRow][nCol] = true;
						q.add(new Pair(nRow, nCol));
					}

				}
			}

		}

	}

	class Pair {
		int _row;
		int _col;

		public Pair(int row, int col) {
			_row = row;
			_col = col;
		}

	}

}
