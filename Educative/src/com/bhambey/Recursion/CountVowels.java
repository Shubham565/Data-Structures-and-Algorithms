package com.bhambey.Recursion;

public class CountVowels {

	public static void main(String[] args) {
		String s = "esufibobusuteri";

		int count = RecursionUtil.countVowels(s);

		System.out.println("Number of vowels in curent String is: " + count);
	}

}
