package com.bhambey.strings;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(StringsUtil.reverseWordsInString("the sky is blue")); // Output: "blue is sky the"
		System.out.println(StringsUtil.reverseWordsInString("  hello world  ")); // Output: "world hello"
		System.out.println(StringsUtil.reverseWordsInString("a good   example")); // Output: "example good a"
	}

}
