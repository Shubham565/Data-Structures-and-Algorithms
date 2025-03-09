package com.bhambey.basicMath;

public class CountMaxAndMin {

	public static void main(String[] args) {

		int arr[] = { 10, 5, 10, 15, 10, 5 };
		int n = arr.length;
		countFreq(arr, n);

	}

	private static void countFreq(int[] arr, int n) {
		boolean visited[] = new boolean[n];
		int maxFreq = 0, minFreq = n;
		int maxEle = 0, minEle = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] == true)
				continue;

			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					visited[j] = true;
					count += 1;
				}
			}

			if (count > maxFreq) {
				maxFreq = count;
				maxEle = arr[i];
			}

			if (count < minFreq) {
				minEle = arr[i];
				minFreq = count;
			}
		}
		System.out.println("Maximum Frequency element: " + maxEle);
		System.out.println("Minimum Frequency Element: " + minEle);
	}

}
