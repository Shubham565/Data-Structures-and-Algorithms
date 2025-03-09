package com.bhambey.interviews;

public class Gartner {

	public static int[] distributeCandies(int candies, int num_people) {
		int[] people = new int[num_people];
		int p = 0;
		int cnt = 1;
		while (candies > 0) {
			if (candies < cnt) {
				people[p++ % num_people] += candies;
				candies = 0;
			} else {
				candies -= cnt;
				people[p++ % num_people] += cnt++;
			}
		}
		return people;
	}

	public static void main(String[] args) {

		int[] res = distributeCandies(7, 4);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}
}
