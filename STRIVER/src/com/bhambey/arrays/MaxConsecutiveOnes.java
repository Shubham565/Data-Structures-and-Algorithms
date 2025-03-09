package com.bhambey.arrays;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = ArrayUtil.findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
		
	}

}
