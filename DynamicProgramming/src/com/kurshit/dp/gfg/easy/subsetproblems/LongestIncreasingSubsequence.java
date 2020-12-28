package com.kurshit.dp.gfg.easy.subsetproblems;

import java.util.Arrays;

/*
 * Source : https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * 
 * Problem : The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given 
 * sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

 * 
 * Solution Source : https://www.youtube.com/watch?v=SHFyIAnjj90&ab_channel=codebix
 * 
 * Solution by topw down by Tushar : https://www.youtube.com/watch?v=CE2b_-XfVDk&t=253s&ab_channel=TusharRoy-CodingMadeSimple
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 5, 3, 4, 10}; 
		//Expected output 5
		System.out.println(lisRecursion(arr, arr.length));		
		System.out.println(lisMemoization(arr, arr.length));
		System.out.println(lisTopDown(arr, arr.length));
		
		System.out.println();
		int[] arr2 = {3, 4, -1, 0, 6, 2, 3};
		
		//Expected Output: 4
		
		System.out.println(lisRecursion(arr2, arr2.length));		
		System.out.println(lisMemoization(arr2, arr2.length));
		System.out.println(lisTopDown(arr2, arr2.length));
		
		

	}
	
	/*
	 *  TC: Exponential
	 */
	
	public static int lisRecursion(int[] arr, int N) {
		return lisRecursionUtil(arr, 0, -1);
	}
	
	public static int lisRecursionUtil(int[] arr, int curr, int prev) {
		
		if(curr == arr.length)
			return 0;
		
		int op1 = 0;
		
		if(prev == -1 || arr[prev] < arr[curr]) {
			op1 = 1 + lisRecursionUtil(arr, curr + 1, curr);
		}
		
		int op2 = lisRecursionUtil(arr, curr + 1, prev);
		
		return Math.max(op1,  op2);		
	}
	
	public static int lisMemoization(int[] arr, int N) {
		int[][] dp = new int[N][N];
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		return lisMemoizationUtil(arr, 0, -1, dp);
	}
	
	public static int lisMemoizationUtil(int[] arr, int curr, int prev, int[][] dp) {
		
		if(curr == arr.length)
			return 0;
		
		if(prev != -1 && dp[prev][curr] != -1)
			return dp[prev][curr];
		
		int op1 = 0;
		
		if(prev == -1 || arr[prev] < arr[curr]) {
			op1 = 1 + lisMemoizationUtil(arr, curr + 1, curr, dp);
		}
		
		int op2 = lisMemoizationUtil(arr, curr + 1, prev, dp);
		
		if(prev != -1 ) {
			return dp[prev][curr] = Math.max(op1,  op2);		
		} else {
			return Math.max(op1,  op2);
		}
	}
	
	public static int lisTopDown(int[] arr, int N) {
		
		if(N ==0) {
			return 0;
		}
		
		int[] LIS = new int[N];
		
		Arrays.fill(LIS,1);
		
		for(int i =1; i < N; i++) {
			for(int j=0; j < i; j++) {
				if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
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
