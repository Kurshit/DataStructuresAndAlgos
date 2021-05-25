package com.kurshit.dp.atcoder.educational;

import java.util.Arrays;

/*
 * Source : https://atcoder.jp/contests/dp/tasks/dp_b
 * 
 * Problem : There are N stones numbered 1,2 ...N.F or each i (1 <= i <= N), the height of stone i is Hi.
 * 
 * There is a frog initally at stone 1. He will repeat the following action some number of times to reach stone N.
 * 	 -- If frog is currently on stone i, jump to one of the following : Stone i+1, i+2, i+3 ... i +K. Here a cose of |Hi-Hj| is incurred, where
 * j is stone to land on
 * 
 * Find the minimum possible total cost incurred before the frog reaches stone N.
 * 
 * Note : Frog can jump at any stone upgo given K - unlike FrogWithTwoJumps problem where it can only jump by max two stones. 
 * 
 * Input : 
 * 		First Line : N K
 * 		Second Line : N stone values
 * 
 * Example 1: 
 * 
 *  5 3
 *  10 30 40 50 20
 *  
 * Output: 30 // 1 -> 2 -> 5
 * 
 * Example 2 : 
 * 
 *    2  100
 *    10  10
 *    
 * Output: 0
 *   
 * 
 */

public class FrogWithKJumps {
	
	public static void main(String[] args) {
	
		int[] arr1 = {10, 30, 40, 50, 20};
		int N = arr1.length;
		int K = 3;
		
		System.out.println(getMinCost(arr1, N, K));
		
		int[] arr2 = {10, 10};
		N = arr2.length;
		K = 100;
		
		System.out.println(getMinCost(arr2, N, K));
		
		int[] arr3 = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
		N = arr3.length;
		K = 4;
		
		System.out.println(getMinCost(arr3, N, K));
	}
	
	public static int getMinCost(int[] arr, int N, int K ) {
		
		int[] dp = new int[N];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=1; i < N; i++) {
			
			for(int j = 1; j <= K; j++) {
				if(i - j < 0)
					break;
				dp[i] = Math.min(dp[i], Math.abs(arr[i] - arr[i-j]) + dp[i-j]);
			}
		}
		
		return dp[N-1];
	}

}
