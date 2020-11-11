package com.kurshit.dp.gfg.easy;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} 
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
 * and {5,5}. So the output should be 5.
 * 
 * Source : https://www.geeksforgeeks.org/coin-change-dp-7/
 */

public class CoinChange {
	
	/*
	 * Approach 1 : Recursion
	 * 
	 * 
	 */
	
	public static int waysOfCoinChangeRecursion(int[] coins, int N, int C) {
	
		if(N == 0)
			return 0;
		
		if(C == 0)
			return 1;
		
		if(C < 0)
			return 0;

		return waysOfCoinChangeRecursion(coins, N - 1, C) + waysOfCoinChangeRecursion(coins, N, C - coins[N-1]);
		
	}
	
	/*
	 * Approach 1 : Memoization
	 *  
	 */
	
	static int[][] cache;
	
	public static int waysOfCoinChangeMemoization(int[] coins, int N, int C) {
	
		if(N ==0)
			return 0;
		
		if(C == 0)
			return 1;
		
		if(C < 0)
			return 0;
		
		if(cache[N][C] !=0) {
			return cache[N][C];
		}
		
		return cache[N][C] = waysOfCoinChangeRecursion(coins, N - 1, C) + waysOfCoinChangeRecursion(coins, N, C - coins[N-1]);
		
	}
	
	public static int waysOfCoinChangeTopdown(int[] coins, int N, int key) {
		int[][] dp = new int[N+1][key+1];
		initializeIt(dp, N, key);
		
		for(int i=1; i <=N; i++ ) {
			for(int j =1; j <= key; j++) {
				
				if(coins[i-1] <= j)
					dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[N][key];
	}
	 
	
	private static void initializeIt(int[][] dp, int N, int key) {
		
		for(int i = 0; i <  key; i++) {
			dp[0][i] = 0;
		}
		
		for(int i =0; i < key; i++) {
			dp[i][0] = 1;
		}
		
	}

	public static void main(String[] args) {
		
		int[] coins = {1, 2, 3};
		int N = coins.length;
		int key = 4;
		System.out.println("Using recursion: " +waysOfCoinChangeRecursion(coins, N, key));
		
		cache = new int[N+1][key+1];
		System.out.println("Using memoization: " + waysOfCoinChangeMemoization(coins, N, key));
		System.out.println("Using Top Down : " + waysOfCoinChangeTopdown(coins, N, key));

	}

}
