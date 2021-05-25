package com.kurshit.dp.atcoder.educational;

/*
 * Source : https://atcoder.jp/contests/dp/tasks/dp_a
 * Problem : There are N stones numbered 1,2 ...N.F or each i (1 <= i <= N), the height of stone i is Hi.
 * 
 * There is a frog initally at stone 1. He will repeat the following action some number of times to reach stone N.
 * 	 -- If frog is currently on stone i, jum to stone i + 1 OR i +2. Here cost of |Hi - Hj| is incurred where j is stone to land on.
 * 
 * Find the minimum possible total cost incurred before the frog reaches stone N.
 * 
 * Note : Frog can jum max by two ahead stones. 
 * 
 * Example: 
 * 
 * 	Fist line - N : No of stones
 *  Second line - : N Stone values 
 *  
 *  4
 *  10 20 30 40
 *  
 *  Output: 30
 *  
 *  Explain : Path : 1 --> 2 --> 4
 *  
 *  Example 2: 	
 *  
 *  	2
 *  	10 10
 *  
 *  Output : 0
 * 
 */

/*
 * Solution & Note: 
 * 
 * This problem may appear to be solved by Greedy algorithm. But if fails for following test cases - 
 * 
 * Example: 
 * 
 * 	6
 *  30 10 60 10 60 50
 *  
 *  Expected Output : 40  // 1 --> 3 --> 5 --> 6
 *  
 *  Actual : 60 //1 --> 2 --> 4 --> 6
 * 
 * Hence Greedy approach will not work here. Thus DP is used
 * 
 */

public class FrogWithTwoJumps {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40};
		int N = arr.length;
		
		System.out.println(getMinCost(arr, N));
		
		int[] arr1 = {10, 10};
		N = arr1.length;
		
		System.out.println(getMinCost(arr1, N));
		
		int[] arr2 = {30, 10, 60, 10, 60, 50};
		N = arr2.length;
		
		System.out.println(getMinCost(arr2, N));
	}
	
	
	/*
	 * Approach 1 : DP
	 */
	
	public static int getMinCost(int[] arr, int N ) {
		
		int[] dp = new int[N];
		
		dp[0] = 0;
		dp[1] = Math.abs(arr[1] - arr[0]);
		
		for(int i=2; i < N; i++) {
			dp[i] = Math.min( Math.abs(arr[i] - arr[i-1]) + dp [i-1], Math.abs(arr[i] - arr[i-2]) + dp[i-2]);
		}
		
		return dp[N-1];
	}
}
