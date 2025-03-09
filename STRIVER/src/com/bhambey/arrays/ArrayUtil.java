package com.bhambey.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayUtil {

	public static int largestElement(int[] arr) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}

		return max;

	}

	public static int SecondLargest(int[] arr) {

		if (arr.length < 2) {
			return -1;
		}

		int large = Integer.MIN_VALUE;
		int second_large = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > large) {
				second_large = large;
				large = arr[i];
			} else if (arr[i] > second_large && arr[i] != large) {
				second_large = arr[i];
			}
		}

		return second_large;
	}

	public static int secondSmallestElement(int[] arr) {

		if (arr.length < 2) {
			return -1;
		}

		int small = Integer.MAX_VALUE;
		int second_small = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < small) {
				second_small = small;
				small = arr[i];
			}

			else if (arr[i] < second_small && arr[i] != small) {
				second_small = arr[i];
			}

		}

		return second_small;
	}

	public static boolean checkSortedArray(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int removeDuplicatesSortedArray(int[] arr) {

		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}

		return i + 1;
	}

	public static void leftRotateByOnePosition(int[] arr, int n) {

		int temp = arr[0];

		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}

		arr[arr.length - 1] = temp;

	}

	public static void RotateKRight(int[] arr, int n, int k) {

		int[] narr = new int[k];
		for (int i = 0; i < k; i++) {
			narr[i] = arr[i];
		}

		for (int i = 0; i <= n - k - 1; i++) {
			arr[i] = arr[i + 1];
		}

		int x = 0;

		for (int i = k; i > 0; i--) {
			arr[n - i] = narr[x];
			x++;
		}

	}

	public static int[] moveZerosToEnd(int n, int[] arr) {

		int j = -1;
		// place the pointer j:
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				j = i;
				break;
			}
		}

		// no non-zero elements:
		if (j == -1)
			return arr;

		// Move the pointers i and j
		// and swap accordingly:
		for (int i = j + 1; i < n; i++) {
			if (arr[i] != 0) {
				// swap a[i] & a[j]:
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				j++;
			}
		}

		return arr;

	}

	public static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {

		int i = 0, j = 0;
		ArrayList<Integer> union = new ArrayList<>();

		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);
					i++;
				}
			} else {
				if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
					union.add(arr2[j]);
					j++;
				}
			}
		}

		while (i < n) {
			if (union.get(union.size() - 1) != arr1[i]) {
				union.add(arr1[i]);
				i++;
			}

		}

		while (j < m) {
			if (union.get(union.size() - 1) != arr2[j]) {
				union.add(arr2[j]);
				j++;
			}

		}

		return union;
	}

	public static int missingNumber(int[] arr, int N) {

		int sum = ((N * (N + 1)) / 2);

		int s = 0;

		for (int i = 0; i < N - 1; i++) {
			s += arr[i];
		}

		return sum - s;

	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		int max = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}

			max = Math.max(max, count);
		}

		return max;
	}

	public static int getSingleElement(int[] arr) {

		int xorr = 0;

		for (int i = 0; i < arr.length; i++) {
			xorr = xorr ^ arr[i];
		}

		return xorr;
	}

	public static int getLongestSubarrayForGivenSum(int[] a, long k) {
// Using nested for loops
		/*
		 * int n = a.length; int len = 0; for(int i=0; i<n; i++) { int s = 0; for(int
		 * j=i; j<n; j++) { s += a[j];
		 * 
		 * if(s == k) { len = Math.max(len, j-i+1); } } } return len;
		 */

		// Using Hashing
		/*
		 * int n = a.length;
		 * 
		 * Map<Long, Integer> preSumMap = new HashMap<>(); long sum = 0; int maxLen = 0;
		 * for (int i = 0; i < n; i++) { sum += a[i];
		 * 
		 * if (sum == k) { maxLen = Math.max(maxLen, i + 1); }
		 * 
		 * long rem = sum - k;
		 * 
		 * if (preSumMap.containsKey(rem)) { int len = i - preSumMap.get(rem); maxLen =
		 * Math.max(maxLen, len); }
		 * 
		 * if (!preSumMap.containsKey(sum)) { preSumMap.put(sum, i); } }
		 * 
		 * return maxLen;
		 */

		// Using two pointers

		int n = a.length;
		int left = 0, right = 0;
		long sum = a[0];
		int maxLen = 0;

		while (right < n) {

			while (left <= right && sum > k) {
				sum -= a[left];
				left++;
			}

			if (sum == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}

			right++;
			if (right < n)
				sum += a[right];

		}
		return maxLen;

	}

	public static boolean twoSum(int[] arr, int target) {

		int left = 0, right = arr.length - 1;

		Arrays.sort(arr);

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				return true;
			} else if (sum < target)
				left++;
			else
				right--;
		}
		return false;
	}

	public static void dutchNationalFlag(int[] arr) {

		// Time Comp: O(n)
		// Space Comp: O(1)
		int low = 0, mid = 0, high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;

				mid++;
				low++;
			}

			else if (arr[mid] == 1) {
				mid++;
			}

			else {

				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;

				high--;

			}

		}

	}

	public static int majorityElement(int[] arr) {

		int limit = arr.length;
		int count = 0;
		int el = 0;

		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				count = 1;
				el = arr[i];
			} else if (el == arr[i]) {
				count++;
			} else {
				count--;
			}
		}

		int t = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == el) {
				t++;
			}
		}

		if (t > arr.length / 2) {
			return el;
		}

		return -1;
	}

	public static long maxSubarraySum(int[] arr, int n) {

		// int maxSum = arr[0];
		// int currentSum = arr[0];

		long max = Long.MIN_VALUE;
		long sum = 0;

		int start = 0, end = 0, tempStart = 0;

//		for(int i=1; i<arr.length; i++)
//		{
//			if(arr[i] > currentSum + arr[i])
//			{
//				tempStart = i;
//				currentSum = arr[i];
//			}
//			else
//			{
//				currentSum += arr[i];
//			}
//			
//			if(currentSum > maxSum)
//			{
//				maxSum = currentSum;
//				start = tempStart;
//				end = i;
//			}
//			
//		}

		for (int i = 0; i < arr.length; i++) {

			if (sum == 0)
				tempStart = i;

			sum += arr[i];

			if (sum > max) {
				max = sum;

				start = tempStart;
				end = i;
			}

			if (sum < 0)
				sum = 0;

		}

		System.out.println("Maximum Sum: " + max);
		System.out.println(
				"Subarray with the maximum sum: " + Arrays.toString(Arrays.copyOfRange(arr, tempStart, end + 1)));

		return max;

	}

	public static int stockBuyAndSell(int[] arr) {

		// Time: O(n)
		// space: O(1) {7,1,5,3,6,4}

		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			minPrice = Math.min(minPrice, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i] - minPrice);
		}
		return maxProfit;
	}

	public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
		// Define 2 ArrayLists, one for storing positive
		// and other for negative elements of the array.
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();

		// Segregate the array into positives and negatives.
		for (int i = 0; i < n; i++) {
			if (A.get(i) > 0)
				pos.add(A.get(i));
			else
				neg.add(A.get(i));
		}

		// If positives are lesser than the negatives.
		if (pos.size() < neg.size()) {

			// First, fill array alternatively till the point
			// where positives and negatives are equal in number.
			for (int i = 0; i < pos.size(); i++) {
				A.set(2 * i, pos.get(i));
				A.set(2 * i + 1, neg.get(i));
			}

			// Fill the remaining negatives at the end of the array.
			int index = pos.size() * 2;
			for (int i = pos.size(); i < neg.size(); i++) {
				A.set(index, neg.get(i));
				index++;
			}
		}

		// If negatives are lesser than the positives.
		else {
			// First, fill array alternatively till the point
			// where positives and negatives are equal in number.
			for (int i = 0; i < neg.size(); i++) {
				A.set(2 * i, pos.get(i));
				A.set(2 * i + 1, neg.get(i));
			}

			// Fill the remaining positives at the end of the array.
			int index = neg.size() * 2;
			for (int i = neg.size(); i < pos.size(); i++) {
				A.set(index, pos.get(i));
				index++;
			}
		}
		return A;
	}

	public static List<Integer> nextGreaterPermutation(List<Integer> A) {

		int n = A.size();

		int ind = -1;

		for (int i = n - 2; i >= 0; i--) {
			if (A.get(i) < A.get(i + 1)) {
				ind = i;
				break;
			}
		}
		if (ind == -1) {
			Collections.reverse(A);
			return A;
		}

		for (int i = n - 1; i > ind; i--) {
			if (A.get(i) > A.get(ind)) {
				int temp = A.get(i);
				A.set(i, A.get(ind));
				A.set(ind, temp);
			}
		}

		List<Integer> sublist = A.subList(ind + 1, n);
		Collections.reverse(sublist);

		return A;
	}

	public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {

		int lead = arr[n - 1];
		ArrayList<Integer> leaders = new ArrayList<>();
		leaders.add(lead);

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > lead) {
				leaders.add(arr[i]);
				lead = arr[i];
			}
		}

		return leaders;
	}

	public static int longestConsecutiveSequence(int[] arr) {

		int n = arr.length;
		if (n == 0) {
			return 0;
		}

		int longest = 0;

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		for (int i : set) {
			if (!set.contains(i - 1)) {
				int count = 1;
				int x = i;
				while (set.contains(x + 1)) {
					x++;
					count++;
				}
				longest = Math.max(count, longest);
			}
		}

		return longest;
	}

	public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

		int col0 = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix.get(i).get(j) == 0) {
					matrix.get(i).set(0, 0);

					if (j != 0) {
						matrix.get(0).set(j, 0);
					} else {
						col0 = 0;
					}
				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
					matrix.get(i).set(j, 0);
				}
			}
		}

		if (matrix.get(0).get(0) == 0) {
			for (int j = 1; j < m; j++) {
				matrix.get(0).set(j, 0);
			}
		}

		if (col0 == 0) {
			for (int i = 0; i < n; i++) {
				matrix.get(i).set(0, 0);
			}
		}

		return matrix;
	}

	public static void rotateImageByNinetyDegree(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = 0;
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr.length - 1 - j];
				arr[i][arr.length - 1 - j] = temp;
			}
		}

	}

	public static int findAllSubarraysWithGivenSum(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int prefix = 0;
		int n = arr.length;

		map.put(0, 1);

		for (int i = 0; i < n; i++) {
			prefix += arr[i];

			int remove = prefix - k;

			count += map.getOrDefault(remove, 0);

			map.put(prefix, map.getOrDefault(prefix, 0) + 1);

		}

		return count;
	}

	public static List<Integer> printSpiral(int[][] mat) {

		List<Integer> ans = new ArrayList<>();

		int n = mat.length;
		int m = mat[0].length;

		int top = 0;
		int right = m - 1;
		int left = 0;
		int bottom = n - 1;

		while (top <= bottom && left <= right) {

			for (int i = left; i <= right; i++)
				ans.add(mat[top][i]);

			top++;

			for (int i = top; i <= bottom; i++)
				ans.add(mat[i][right]);

			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--)
					ans.add(mat[bottom][i]);

				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--)
					ans.add(mat[i][left]);

				left++;
			}

		}

		return ans;
	}

	private static int nCr(int n, int r) {

		int res = 1;

		for (int i = 0; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}

		return res;
	}

	public static int pascalTrianglePositionElement(int r, int c) {

		int element = (int) nCr(r - 1, c - 1);
		return element;
	}

	public static void pascalTrianglePrintRow(int n) {

		long ans = 1;
		System.out.print(ans + " ");

		for (int i = 1; i < n; i++) {
			ans = ans * (n - i);
			ans /= i;

			System.out.print(ans + " ");
		}
		System.out.println();
	}

	private static List<Integer> generateRow(int row) {

		long ans = 1;
		List<Integer> ansRow = new ArrayList<>();
		ansRow.add(1);

		for (int col = 1; col < row; col++) {
			ans *= (row - col);
			ans /= col;
			ansRow.add((int) ans);
		}

		return ansRow;
	}

	public static List<List<Integer>> printPascalTriangle(int n) {

		List<List<Integer>> ans = new ArrayList<>();

		for (int row = 1; row <= n; row++) {
			ans.add(generateRow(row));
		}

		return ans;
	}

	public static List<Integer> majorityElementNThreeTimes(int[] arr) {

		// Time Comp: O(n) + O(n) = O(n)
		// Space Comp: O(1)

		int n = arr.length;

		int count1 = 0, count2 = 0;
		int element1 = 0, element2 = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (count1 == 0 && element2 != arr[i]) {
				count1 = 1;
				element1 = arr[i];
			}

			else if (count2 == 0 && element1 != arr[i]) {
				count2 = 1;
				element2 = arr[i];
			}

			else if (arr[i] == element1) {
				count1++;
			}

			else if (arr[i] == element2) {
				count2++;
			}

			else {
				count1--;
				count2--;
			}
		}

		List<Integer> result = new ArrayList<>();

		int cnt1 = 0, cnt2 = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == element1)
				cnt1++;
			if (arr[i] == element2)
				cnt2++;
		}

		int lim = (int) n / 3;
		if (cnt1 >= lim)
			result.add(element1);
		if (cnt2 >= lim)
			result.add(element2);

		return result;
	}

	public static List<List<Integer>> threeSum(int n, int[] arr) {

//		Set<List<Integer>> st = new HashSet<>();
//
//		for (int i = 0; i < arr.length; i++) {
//			Set<Integer> thirdSet = new HashSet<>();
//			for (int j = i + 1; j < arr.length; j++) {
//				int third = -(arr[i] + arr[j]);
//				if (thirdSet.contains(third)) {
//					List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
//					temp.sort(null);
//					st.add(temp);
//				}
//				thirdSet.add(arr[j]);
//			}
//
//		}
//
//		List<List<Integer>> ans = new ArrayList<>(st);
//		return ans;

		// Time Complexity: O(NlogN)+O(N2), where N = size of the array.
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (i != 0 && arr[i] == arr[i - 1])
				continue;

			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];

				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> res = Arrays.asList(arr[i], arr[j], arr[k]);
					ans.add(res);
					j++;
					k--;

					if (j < k && arr[j] == arr[j - 1])
						j++;
					if (j < k && arr[k] == arr[k + 1])
						k--;
				}

			}

		}
		return ans;
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		// Time Complexity: O(N3), where N = size of the array.

		int n = nums.length; // size of the array
		List<List<Integer>> ans = new ArrayList<>();

		// sort the given array:
		Arrays.sort(nums);

		// calculating the quadruplets:
		for (int i = 0; i < n; i++) {
			// avoid the duplicates while moving i:
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				// avoid the duplicates while moving j:
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				// 2 pointers:
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					long sum = nums[i];
					sum += nums[j];
					sum += nums[k];
					sum += nums[l];
					if (sum == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						ans.add(temp);
						k++;
						l--;

						// skip the duplicates:
						while (k < l && nums[k] == nums[k - 1])
							k++;
						while (k < l && nums[l] == nums[l + 1])
							l--;
					} else if (sum < target)
						k++;
					else
						l--;
				}
			}
		}

		return ans;
	}

	public static int longestSubarrayZeroSumLength(int[] arr) {

		// We used the technique of prefix sum here
		// Time Complexity: O(N), as we are traversing the array only once
		// Space Complexity: O(N), in the worst case we would insert all array elements
		// prefix sum into our hashmap
		Map<Integer, Integer> map = new HashMap<>();

		int n = arr.length;
		int sum = 0, maxLen = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum == 0) {
				maxLen = i + 1;
			} else {
				if (map.get(sum) != null) {
					maxLen = Math.max(maxLen, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}
		}

		return maxLen;
	}

	public static int subarrayForGivenXor(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		int n = arr.length;
		int xr = 0;
		map.put(0, 1);
		int count = 0;

		for (int i = 0; i < n; i++) {
			xr ^= arr[i];

			int x = xr ^ k;

			if (map.containsKey(x)) {
				count += map.get(x);
			}

			map.put(xr, map.getOrDefault(xr, 0) + 1);
		}

		return count;
	}

	public static List<List<Integer>> mergeOverlappingSubIntervals(int[][] arr) {

		List<List<Integer>> ans = new ArrayList<>();

		int n = arr.length;

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

//		for (int i = 0; i < n; i++) {
//			int start = arr[i][0];
//			int end = arr[i][1];
//
//			if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1))
//				continue;
//
//			for (int j = i + 1; j < n; j++) {
//				if (arr[j][0] <= end) {
//					end = Math.max(end, arr[j][1]);
//				} else
//					break;
//			}
//
//			ans.add(Arrays.asList(start, end));
//
//		}

		/*
		 * Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
		 * Reason: Sorting the given array takes O(N*logN) time complexity. Now, after
		 * that, we are just using a single loop that runs for N times. So, the time
		 * complexity will be O(N). Space Complexity: O(N), as we are using an answer
		 * list to store the merged intervals. Except for the answer array, we are not
		 * using any extra space.
		 */

		for (int i = 0; i < n; i++) {
			if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			} else {
				ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
			}
		}

		return ans;
	}

	public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
		if (arr1[ind1] > arr2[ind2]) {
			long temp = arr1[ind1];
			arr1[ind1] = arr2[ind2];
			arr2[ind2] = temp;
		}
	}

	public static void mergeTwoSortedArraysNoExtraSpace(long[] arr1, long[] arr2, int n, int m) {

		/* This is the element swap technique */

//		int left = n - 1;
//		int right = 0;
//
//		while (left >= 0 && right < m) {
//			if (arr1[left] > arr2[right]) {
//				long temp = arr1[left];
//				arr1[left] = arr2[right];
//				arr2[right] = temp;
//				left--;
//				right++;
//			} else {
//				break;
//			}
//
//		}
//
//		Arrays.sort(arr1);
//		Arrays.sort(arr1);

		/*
		 * This is the gap method
		 * 
		 * Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given
		 * arrays.
		 * 
		 * Reason: The gap is ranging from n+m to 1 and every time the gap gets divided
		 * by 2. So, the time complexity of the outer loop will be O(log(n+m)). Now, for
		 * each value of the gap, the inner loop can at most run for (n+m) times. So,
		 * the time complexity of the inner loop will be O(n+m). So, the overall time
		 * complexity will be O((n+m)*log(n+m)).
		 * 
		 * Space Complexity: O(1) as we are not using any extra space.
		 */

		int len = n + m;
		int gap = (len / 2) + (len % 2);

		while (gap > 0) {
			int left = 0;
			int right = left + gap;

			while (right < len) {
				if (left < n && right >= n) {
					swapIfGreater(arr1, arr2, left, right - n);
				} else if (left >= n) {
					swapIfGreater(arr2, arr2, left - n, right - n);
				} else {
					swapIfGreater(arr1, arr1, left, right);
				}
				left++;
				right++;
			}

			if (gap == 1)
				break;

			gap = (gap / 2) + (gap % 2);
		}

	}

	public static int[] findMissingAndRepeatingNumbers(int[] arr) {

		/*
		 * Time Complexity: O(N), where N = the size of the given array. Reason: We are
		 * using only one loop running for N times. So, the time complexity will be
		 * O(N).
		 * 
		 * Space Complexity: O(1) as we are not using any extra space to solve this
		 * problem.
		 */

		int n = arr.length;
		int S = n * (n + 1) / 2;
		int S2 = (n * (n + 1) * (2 * n + 1)) / 6;

		long sarr = 0, sarrSquare = 0;

		for (int i = 0; i < n; i++) {
			sarr += arr[i];
			sarrSquare += (long) arr[i] * (long) arr[i];
		}

		// X - Y
		long val1 = S - sarr;

		// X2 - Y2
		long val2 = S2 - sarrSquare;

		// (X2 - Y2)/(X - Y)
		val2 = val2 / val1;

		// ((X + Y) + (X - Y)) / 2
		long X = (val2 + val1) / 2;

		// X - (X - Y)
		long Y = X - val1;

		int[] result = { (int) X, (int) Y };

		return result;
	}

	private static int mergeIC(int[] arr, int low, int mid, int high) {

		int count = 0;
		int left = low;
		int right = mid + 1;
		List<Integer> temp = new ArrayList<>();

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				count += (mid - left + 1);
				right++;
			}
		}

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

//		for (int i = low; i <= high; i++) {
//			arr[i] = temp.get(i - low);
//		}

		return count;
	}

	private static int mergeSortForInversionCount(int[] arr, int low, int high) {
		int count = 0;
		if (low >= high)
			return count;
		int mid = (high + low) / 2;
		count += mergeSortForInversionCount(arr, low, mid);
		count += mergeSortForInversionCount(arr, mid + 1, high);
		count += mergeIC(arr, low, mid, high);
		return count;
	}

	public static int numberOfInversions(int[] arr, int n) {
		return mergeSortForInversionCount(arr, 0, n - 1);
	}

	private static void mergeRevPairs(int[] arr, int low, int mid, int high) {

		List<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid + 1;

		while (left <= mid && right <= high) {
			if (arr[left] < arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}

	}

	private static int countReversePairs(int[] arr, int low, int mid, int high) {

		int right = mid + 1;
		int count = 0;

		for (int i = low; i <= mid; i++) {
			while (right <= high && arr[i] > 2 * arr[right])
				right++;
			count += (right - (mid + 1));
		}
 
		return count;
	}

	private static int mergeSortRevPairs(int[] arr, int low, int high) {

		int count = 0;
		if (low >= high)
			return count;
		int mid = (high + low) / 2;
		count += mergeSortRevPairs(arr, low, mid);
		count += mergeSortRevPairs(arr, mid + 1, high);
		count += countReversePairs(arr, low, mid, high);
		mergeRevPairs(arr, low, mid, high);
		return count;
	}

	public static int countReversePairs(int[] arr, int n) {
		/*
		 * Time Complexity: O(2N*logN), where N = size of the given array. Reason:
		 * Inside the mergeSort() we call merge() and countPairs() except mergeSort()
		 * itself. Now, inside the function countPairs(), though we are running a nested
		 * loop, we are actually iterating the left half once and the right half once in
		 * total. That is why, the time complexity is O(N). And the merge() function
		 * also takes O(N). The mergeSort() takes O(logN) time complexity. Therefore,
		 * the overall time complexity will be O(logN * (N+N)) = O(2N*logN).
		 * 
		 * Space Complexity: O(N), as in the merge sort We use a temporary array to
		 * store elements in sorted order.
		 */
		return mergeSortRevPairs(arr, 0, n - 1);
	}

	public static int maximumProductSubarray(int[] arr) {
		int n = arr.length;

		int pre = 1, suff = 1;
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (pre == 0)
				pre = 1;
			if (suff == 0)
				suff = 1;

			pre *= arr[i];
			suff *= arr[n - i - 1];

			ans = Math.max(ans, Math.max(pre, suff));
		}

		return ans;
	}

}
