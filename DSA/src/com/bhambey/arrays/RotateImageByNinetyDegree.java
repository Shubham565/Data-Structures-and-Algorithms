package com.bhambey.arrays;

public class RotateImageByNinetyDegree {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayUtil.rotateImageByNinetyDegree(arr);
		System.out.println("Rotated Image");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
