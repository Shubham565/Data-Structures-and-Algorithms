package com.bhambey.Recursion;

public class RecursionUtil {

	static int gcd(int num1, int num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);

		if (num1 == 0) {
			return num2;
		} else if (num2 == 0) {
			return num1;
		}

		if (num1 > num2) {
			return gcd(num1 % num2, num2);
		} else {
			return gcd(num1, num2 % num1);
		}

	}

	public static int decimalToBinary(int n) {

		if (n == 0) {
			return 0;
		}

		return (n % 2 + 10 * decimalToBinary(n / 2));
	}

	public static long power(int num, int pow) {

		if (pow == 0) {
			return 1;
		}

		return (num * power(num, pow - 1));
	}

	public static int sumAll(int n) {

		if (n == 1) {
			return n;
		}

		return n + sumAll(n - 1);
	}

	public static int mod(int dividend, int divisor) {

		if (divisor == 0) {
			System.out.println("Divisor cannot be zero");
			return -1;
		}

		if (dividend < divisor) {
			return dividend;
		}

		return mod(dividend - divisor, divisor);
	}

	public static int fibonacci(int n) {

		if (n <= 1) {
			return n;
		}

		return (fibonacci(n - 1) + fibonacci(n - 2));

	}

	public static boolean isPrime(int n, int i) {

		if (n < 2) {
			return false;
		}

		if (i == 1) {
			return true;
		}

		if (n % i == 0) {
			return false;
		} else {
			return isPrime(n, i - 1);
		}

	}

	public static String reverseString(String s) {

		if (s.isEmpty()) {
			return s;
		}

		return reverseString(s.substring(1) + s.charAt(0));
	}

	public static String remDuplicates(String s) {

		if (s.length() == 1) {
			return s;
		}

		if (s.substring(0, 1).equals(s.substring(1, 2))) {
			return remDuplicates(s.substring(1));
		} else {
			return s.substring(0, 1) + remDuplicates(s.substring(1));
		}

	}

	public static String alphabeticMerge(String one, String two) {

		if (one == null || one == "") {
			return two == null ? one : two;
		}

		if (two == null || two == "") {
			return one;
		}

		if (two.charAt(0) > one.charAt(0)) {
			return one.charAt(0) + alphabeticMerge(one.substring(1), two);
		}

		return two.charAt(0) + alphabeticMerge(one, two.substring(1));

	}

	public static int countVowels(String s) {

		int count = 0;

		if (s.length() == 0) {
			return 0;
		}

		char c = Character.toUpperCase(s.charAt(0));

		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			count++;
		}

		return count + countVowels(s.substring(1));

	}

	public static void stringPermutations(char[] carr, int len) {

		if (len == 1) {
			System.out.println(carr);
			return;
		}

		for (int i = 0; i < len; i++) {
			swap(carr, i, len - 1);
			stringPermutations(carr, len - 1);
			swap(carr, i, len - 1);
		}

	}

	private static void swap(char[] carr, int i, int j) {
		char c;
		c = carr[i];
		carr[i] = carr[j];
		carr[j] = c;
	}

	public static boolean isPalindrome(String s) {

		if (s.length() <= 1) {
			return true;
		}

		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		}

		return false;
	}

	public static int firstOccurrence(int[] array, int num, int i) {

		if (i == array.length) {
			return -1;
		} else if (num == array[i]) {
			return i;
		}

		return firstOccurrence(array, num, i + 1);
	}

	public static int numberOfOccurenceArray(int[] arr, int n, int i) {

		if (arr.length == i) {
			return 0;
		}

		if (arr[i] == n) {
			return 1 + numberOfOccurenceArray(arr, n, i + 1);
		}

		return numberOfOccurenceArray(arr, n, i + 1);

	}

	public static void replaceNegativeWithZero(int[] arr, int i) {

		if (arr.length == i) {
			return;
		}

		if (arr[i] < 0) {
			arr[i] = 0;
			replaceNegativeWithZero(arr, i + 1);
		}

		replaceNegativeWithZero(arr, i + 1);

	}

	public static void invertPositionArray(int[] arr, int i) {

		if (i < arr.length / 2) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;

			invertPositionArray(arr, i + 1);
		}

	}

	public static boolean palindromeArray(int[] arr, int i, int j) {

		if (arr[i] != arr[j]) {
			return false;
		} else if (arr[i] == arr[j] && i < j) {
			palindromeArray(arr, i + 1, j - 1);
		}

		return true;

	}

}
