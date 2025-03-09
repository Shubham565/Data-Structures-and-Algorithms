package com.bhambey.recursion.backtracking;

public class CheckStringPalindrome {

	public static void main(String[] args) {

		String s = "MADAMs";
		char[] c = s.toLowerCase().toCharArray();

		boolean b = checkPalindrome(c, 0, c.length);

		System.out.println(b);
	}

	private static boolean checkPalindrome(char[] c, int l, int n) {

		if (l >= n / 2)
			return true;

		if (c[l] != c[n - l - 1])
			return false;

		return checkPalindrome(c, l + 1, n);

	}

}
