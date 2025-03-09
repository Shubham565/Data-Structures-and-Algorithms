package com.bhambey.striverGraphs;

/*Problem Statement: An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, “flood fill” the image.

To perform a “flood fill”, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting 
pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. 
Replace the colour of all of the aforementioned pixels with the newColor.*/

//TC: O(N*M) + O(N*M*4) ~ O(N*M)
//SC: O(N*M) + O(N*M) ~ O(N*M)
public class FloodFillDFS {
	public static void main(String[] args) {

		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		// sr = 1, sc = 1, newColor = 2
		FloodFillDFS obj = new FloodFillDFS();
		int[][] ans = obj.floodFillDFS(image, 1, 1, 2);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}

	}

	private int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {

		int iniColor = image[sr][sc];
		int[][] ans = image;

		int[] delRow = { +1, 0, -1, 0 };
		int[] delCol = { 0, +1, 0, -1 };

		dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);

		return ans;
	}

	private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol,
			int iniColor) {
		ans[row][col] = newColor;
		int m = image.length;
		int n = image[0].length;

		for (int i = 0; i < 4; i++) {
			int nrow = row + delRow[i];
			int ncol = col + delCol[i];

			if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == iniColor
					&& ans[nrow][ncol] != newColor) {
				dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
			}

		}

	}
}
