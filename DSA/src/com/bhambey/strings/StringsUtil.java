package com.bhambey.strings;

import java.util.*;

public class StringsUtil {

	public static String removeOutermostParenthesis(String sample) {

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < sample.length(); i++) {
			if (sample.charAt(i) == '(') {
				if (stack.size() > 0) {
					sb.append(sample.charAt(i));
				}
				stack.push(sample.charAt(i));
			} else {
				stack.pop();
				if (stack.size() > 0) {
					sb.append(sample.charAt(i));
				}
			}
		}

		return sb.toString();
	}

	public static String reverseTheString(String s) {

		int left = 0, right = s.length() - 1;
		String temp = "", ans = "";

		while (left <= right) {
			char ch = s.charAt(left);
			if (ch != ' ') {
				temp += ch;
			} else if (ch == ' ') {
				if (!ans.equals("")) {
					ans = temp + " " + ans;
				} else {
					ans = temp;
				}
				temp = "";
			}
			left++;
		}
		if (!temp.equals("")) {
			if (!ans.equals("")) {
				ans = temp + " " + ans;
			} else {
				ans = temp;
			}
		}

		return ans;
	}

	public static String largestOddNUmberInTheString(String s) {

		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			if (Character.getNumericValue(s.charAt(i)) % 2 != 0) {
				return s.substring(0, i + 1);
			}
		}
		return "";
	}

	public static String longestCommonPrefix(String[] arr) {

		if (arr.length == 0)
			return "";

		String prefix = arr[0];
		for (int i = 1; i < arr.length; i++) {
			while (arr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}

	public static boolean rotateString(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		return (s1 + s1).contains(s2);
	}

	public static boolean anagrams(String s1, String s2) {

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] count = new int[26];

		for (char x : s1.toCharArray()) {
			count[x - 'a']++;
		}

		for (char x : s2.toCharArray()) {
			count[x - 'a']--;
		}

		for (int i : count) {
			if (i != 0)
				return false;
		}

		return true;
	}

	public static String sortCharactersByFrequency(String s) {

		// Time Complexity: O(nlogn) - Using arrays only

		int[] freq = new int[128];

		for (char c : s.toCharArray()) {
			freq[c]++;
		}

		Character[] carr = new Character[s.length()];
		int index = 0;
		for (char c = 0; c < freq.length; c++) {
			for (int i = 0; i < freq[c]; i++) {
				carr[index++] = c;
			}
		}

		Arrays.sort(carr, (a, b) -> freq[b] - freq[a]);

		StringBuilder result = new StringBuilder();
		for (char c : carr) {
			result.append(c);
		}

		return result.toString();
	}

	public static int maximumNestingParenthesis(String s) {

		int maxNesting = Integer.MIN_VALUE;
		int count = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
				maxNesting = Math.max(count, maxNesting);

			} else if (c == ')') {
				count--;
			}
		}

		return Math.max(maxNesting, count);
	}

	public static int romanToInteger(String s) {

		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		int prev = 0, total = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int curr = romanMap.get(s.charAt(i));
			if (curr < prev) {
				total -= curr;
			} else {
				total += curr;
			}
			prev = curr;
		}

		return total;
	}

	public static int atoiStringToInteger(String s) {

		int i = 0, n = s.length();
		int sign = 1, result = 0;
		int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;

		while (i < n && s.charAt(i) == ' ') {
			i++;
		}

		if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}

		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';

			if (result > (max - digit) / 10) {
				return sign == 1 ? max : min;
			}

			result = result * 10 + digit;
			i++;
		}

		return result * sign;

	}

	private static int countAtMostK(String s, int k) {
		if (k == 0)
			return 0;

		int count = 0;
		HashMap<Character, Integer> freq = new HashMap<>();
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			freq.put(c, freq.getOrDefault(c, 0) + 1);

			while (freq.size() > k) {
				char leftChar = s.charAt(left);
				freq.put(leftChar, freq.get(leftChar) - 1);
				if (freq.get(leftChar) == 0) {
					freq.remove(leftChar);
				}
				left++;
			}

			count += (right - left + 1);
		}

		return count;
	}

	public static int substringWithKDistinctChars(String s, int k) {
		return countAtMostK(s, k) - countAtMostK(s, k - 1);
	}

	
	private static int expandFromMiddle(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}

	public static String longestPalindromicSubstring(String s) {

		if (s.length() < 1 || s == null)
			return "";

		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);
			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	
	private static int getBeauty(int[] freq) {

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int f : freq) {
			if (f > 0) {
				max = Math.max(max, f);
				min = Math.min(min, f);
			}
		}

		return max - min;
	}
	
	public static int beautyOfSubstrings(String s) {

		int n = s.length();
		int totalBeauty = 0;

		for (int i = 0; i < n; i++) {
			int[] freq = new int[26];

			for (int j = i; j < n; j++) {
				freq[s.charAt(j) - 'a']++;
				totalBeauty += getBeauty(freq);
			}
		}

		return totalBeauty;
	}

	
	public static String reverseWordsInString(String s) {

		String[] wordsInOrder = s.trim().split("\\s+");
		StringBuilder result = new StringBuilder();

		for (int i = wordsInOrder.length - 1; i >= 0; i--) {
			result.append(wordsInOrder[i]);
			if (i > 0)
				result.append(" ");
		}

		return result.toString();
	}



	
	
	
}
