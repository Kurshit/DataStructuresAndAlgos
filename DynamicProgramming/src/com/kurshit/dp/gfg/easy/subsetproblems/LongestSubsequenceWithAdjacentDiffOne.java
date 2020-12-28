package com.kurshit.dp.gfg.easy.subsetproblems;

import java.util.Arrays;

/*
 * Problem Source : https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/
 * 
 * Problem: Given an array of n size, the task is to find the longest subsequence such that difference between adjacents is one.

	Examples:

	Input :  arr[] = {10, 9, 4, 5, 4, 8, 6}
	Output :  3
	As longest subsequences with difference 1 are, "10, 9, 8", 
	"4, 5, 4" and "4, 5, 6"

	Input :  arr[] = {1, 2, 3, 2, 3, 7, 2, 1}
	Output :  7
	As longest consecutive sequence is "1, 2, 3, 2, 3, 2, 1"
 */

public class LongestSubsequenceWithAdjacentDiffOne {

	public static void main(String[] args) {
		
		int[] arr = {10, 9, 4, 5, 4, 8, 6};
		System.out.println(lisTopDown(arr, arr.length));
		
		int[] arr1 = {1, 2, 3, 2, 3, 7, 2, 1};
		System.out.println(lisTopDown(arr1, arr1.length));
	}

	/*
	 * Solution approach is same as LIS
	 */

	public static int lisTopDown(int[] arr, int N) {

		if(N ==0) {
			return 0;
		}

		int[] LIS = new int[N];

		Arrays.fill(LIS,1);

		for(int i =1; i < N; i++) {
			for(int j=0; j < i; j++) {
				if(Math.abs(arr[i] - arr[j]) == 1 &&  LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for(int i =0; i < N; i++)
			max = Math.max(max, LIS[i]);
		return max;
	}

}
