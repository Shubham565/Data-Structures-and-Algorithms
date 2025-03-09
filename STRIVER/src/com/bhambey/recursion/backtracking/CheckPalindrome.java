package com.bhambey.recursion.backtracking;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s = "ABCBA";
		boolean res = checkPalindrome(s);
		if (res == true)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

	private static boolean checkPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char l = s.charAt(left), r = s.charAt(right);
			if (!Character.isLetterOrDigit(l))
				left++;
			else if (!Character.isLetterOrDigit(r))
				right--;
			else if (Character.isLowerCase(l) != Character.isLowerCase(r))
				return false;
			else {
				left++;
				right--;
			}
		}
		return true;
	}

}
