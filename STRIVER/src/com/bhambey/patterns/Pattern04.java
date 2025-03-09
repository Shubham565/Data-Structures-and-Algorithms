package com.bhambey.patterns;

/*

Input: N = 3

Result: 
1
2 2 
3 3 3

*/

public class Pattern04 {
	public static void main(String[] args) {

		printPattern(5);

	}

	private static void printPattern(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}
