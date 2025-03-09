package com.bhambey.strings;

public class SubstringWithKDistinctChars {

    public static void main(String[] args) {
        System.out.println(StringsUtil.substringWithKDistinctChars("aba", 2)); // Output: 3
        System.out.println(StringsUtil.substringWithKDistinctChars("abaaca", 1)); // Output: 7
        System.out.println(StringsUtil.substringWithKDistinctChars("cdad", 4)); // Output: 0
    }

}
