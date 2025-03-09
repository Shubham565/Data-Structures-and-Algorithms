package com.bhambey.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

	public static ArrayDeque<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>();
		Deque<Integer> window = new ArrayDeque<Integer>();
		// Return 0 if nums is empty
		if (nums.size() == 0)
			return result;
		// If window_size is greater than the array size,
		// set the window_size to the array size
		if (windowSize > nums.size())
			windowSize = nums.size();

		// this variable is for the sole purpose of printing
		boolean check = false;
		// Find out the maximum in the first window
		System.out.println("Traversing to find maximum in the first window:");
		for (int i = 0; i < windowSize; i++) {
			// For every element, remove the previous smaller elements from window
			while ((!window.isEmpty()) && nums.get(i) >= nums.get(window.peekLast())) {
				check = true;
				System.out.println("\t\tnums[" + i + "] = " + nums.get(i)
						+ " is greater than or equal to nums[window[-1]] = " + nums.get(window.peekLast()));
				window.removeLast();
				System.out.println("\t\tWindow after popping:" + window);
			}
			// this is only for the purpose of printing
			if (!check) {
				if (!window.isEmpty())
					System.out.println("\t\tnums[" + i + "] = " + nums.get(i) + " is less than nums[window[-1]] = "
							+ nums.get(window.peekLast()));
				else
					System.out.println("\t\tThe window is empty.");
			}

			check = false;
			// Add current element at the back of the queue
			window.addLast(i);

		}
		// Appending the largest element in the window to the result
		result.add(nums.get(window.peek()));
		System.out.println("Traversing to find maximum in remaining windows:");
		for (int i = windowSize; i < nums.size(); i++) {
			// remove all numbers that are smaller than current number
			// from the tail of list
			while ((!window.isEmpty()) && nums.get(i) >= nums.get(window.peekLast())) {
				check = true;
				System.out.println("\t\tnums[" + i + "] = " + nums.get(i)
						+ " is greater than or equal to nums[window[-1]] = " + nums.get(window.peekLast()));
				window.removeLast();
				System.out.println("\t\tWindow after popping:" + window);
			}
			// this is only for the purpose of printing
			if (!check) {
				if (!window.isEmpty())
					System.out.println("\t\tnums[" + i + "] = " + nums.get(i) + " is less than nums[window[-1]] = "
							+ nums.get(window.peekLast()));
				else
					System.out.println("\t\tThe window is empty.");
			}

			check = false;
			// Remove first index from the window deque if
			// it doesn't fall in the current window anymore
			if ((!window.isEmpty()) && window.peek() <= (i - windowSize))
				window.removeFirst();
			// Add current element at the back of the queue
			window.addLast(i);
			result.add(nums.get(window.peek()));
		}
		return result;
	}

	public static void main(String args[]) {
		List<Integer> targetList = Arrays.asList(3, 3, 3, 3, 2, 4, 3, 2, 3, 18);
		List<List<Integer>> numLists = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
				Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
				Arrays.asList(1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26,
						26, 28, 29, 30),
				Arrays.asList(10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67),
				Arrays.asList(4, 5, 6, 1, 2, 3), Arrays.asList(9, 5, 3, 1, 6, 3),
				Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16), Arrays.asList(-1, -1, -2, -4, -6, -7),
				Arrays.asList(4, 4, 4, 4, 4, 4));
		for (int i = 0; i < numLists.size(); i++) {
			System.out.println(i + 1 + ". Original array:\t" + numLists.get(i));
			System.out.println("Window size:\t\t" + targetList.get(i));
			System.out.println("\n Max:\t\t" + findMaxSlidingWindow(numLists.get(i), targetList.get(i)));
			System.out.println("------------------------------------------------------------------------");
		}
	}

}
