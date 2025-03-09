package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

	public static void main(String[] args) {
		int n = 4;
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		List<String> res = findPath(a, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.println(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

	private static List<String> findPath(int[][] a, int n) {

		int[][] visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = 0;
			}
		}

		List<String> res = new ArrayList<>();

		if (a[0][0] == 1)
			solve(0, 0, a, n, res, "", visited);
		return res;
	}

	private static void solve(int i, int j, int[][] a, int n, List<String> res, String move, int[][] visited) {

		if (i == n - 1 && j == n - 1) {
			res.add(move);
			return;
		}

		if (i + 1 < n && visited[i + 1][j] == 0 && a[i + 1][j] == 1) {
			visited[i][j] = 1;
			solve(i + 1, j, a, n, res, move + 'D', visited);
			visited[i][j] = 0;
		}

		if (j - 1 >= 0 && visited[i][j - 1] == 0 && a[i][j - 1] == 1) {
			visited[i][j] = 1;
			solve(i, j - 1, a, n, res, move + 'L', visited);
			visited[i][j] = 0;
		}

		if (j + 1 < n && visited[i][j + 1] == 0 && a[i][j + 1] == 1) {
			visited[i][j] = 1;
			solve(i, j + 1, a, n, res, move + 'R', visited);
			visited[i][j] = 0;
		}

		if (i - 1 >= 0 && visited[i - 1][j] == 0 && a[i - 1][j] == 1) {
			visited[i][j] = 1;
			solve(i - 1, j, a, n, res, move + 'U', visited);
			visited[i][j] = 0;
		}

	}

}
