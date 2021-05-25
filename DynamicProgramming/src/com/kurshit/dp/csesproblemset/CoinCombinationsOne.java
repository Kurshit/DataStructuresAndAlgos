package com.kurshit.dp.csesproblemset;

/*
 * Problem Source : https://cses.fi/problemset/task/1635
 * 
 * Solution Source : https://www.youtube.com/watch?v=sSdnSS0piIM&t=2466s
 * 	
 * Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to calculate the number of distinct ways you can produce a money sum x using the available coins.

	For example, if the coins are {2,3,5} and the desired sum is 9, there are 8 ways:
	2+2+5
	2+5+2
	5+2+2
	3+3+3
	2+2+2+3
	2+2+3+2
	2+3+2+2
	3+2+2+2

	The first input line has two integers n and x: the number of coins and the desired sum of money.

	The second line has n distinct integers c1,c2,…,cn: the value of each coin.

	Output

	Print one integer: the number of ways modulo 109+7.

	Constraints
	1≤n≤100
	1≤x≤106
	1≤ci≤106
	Example

	Input:
	3 9
	2 3 5

	Output:
	8

 */


/*
 * Solution Note : Now this is same as DiceCombination where in dice values were pre-defines - 1 to 6. Assume the same problem where you 
 * have been given array with values - 1,2,3,4,5,6.
 * 
 * There values were fixed but here its not the case.
 * 
 * Also, this is different from CoinChange Problem that you know where each permutation is NOT considered as unique. Here it is considered
 * as unique.
 *  
 */

public class CoinCombinationsOne {

	public static void main(String[] args) {

		int[] coins = {2, 3, 5};
		int X = 9;
		System.out.println(getWaysBottomUp(coins, X));
		System.out.println(getWaysRecurssion(coins, coins.length, X));
		System.out.println(getWaysMemoization(coins, coins.length, X));
		
		int[] coins1 = {2, 3, 5, 7};
		X = 12;
		System.out.println(getWaysBottomUp(coins1, X));
		System.out.println(getWaysRecurssion(coins1, coins1.length, X));
		System.out.println(getWaysMemoization(coins1, coins1.length, X));


	}

	public static int getWaysBottomUp(int[] coins, int X) {
		int N = coins.length;
		int[] dp = new int[X+1];

		dp[0] = 1;

		for(int i=1 ; i <= X; i++) {
			for(int j=0; j <= N-1; j++) {
				if(coins[j] > i) 
					continue;

				dp[i] = (dp[i] + dp[i - coins[j]] );

			}
		}

		return dp[X] ;

		//return dp[N] % mod; // solution with mod constraint
	}

	public static int getWaysRecurssion(int[] coins, int N, int X) {

		//BC

		if(X == 0)
			return 1;


		int count = 0;

		for(int i = 0; i <= N-1; i++) {

			if(coins[i] > X) {
				continue;
			}
			count = count + getWaysRecurssion(coins, N, X - coins[i]);
		}

		return count;
	}

	public static int getWaysMemoization(int[] arr, int N, int X) {
		int[] cache = new int[X+1];
		return getWaysMemoization(arr, N, X, cache);

	}

	public static int getWaysMemoization(int[] coins, int N, int X, int[] cache) {

		//BC

		if(X == 0)
			return 1;

		if(cache[X] != 0) {
			return cache[X];
		}
		
		int count = 0;

		for(int i = 0; i <= N-1; i++) {

			if(coins[i] > X) {
				continue;
			}
			count = count + getWaysRecurssion(coins, N, X - coins[i]);
		}

		return cache[X] = count;
	}


}
