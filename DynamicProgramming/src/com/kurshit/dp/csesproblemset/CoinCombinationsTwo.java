package com.kurshit.dp.csesproblemset;

/*
 * Consider a money system consisting of n coins. Each coin has a positive integer value. 
 * Your task is to calculate the number of distinct ordered ways you can produce a money sum x using the available coins.

	For example, if the coins are {2,3,5} and the desired sum is 9, there are 3 ways:
	2+2+5
	3+3+3
	2+2+2+3
	Input

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
	3

	Note : THis is same as unbounded knap sack coint change problem.
 */

/*
 * Solution : Ref notes;
 */

public class CoinCombinationsTwo {

	public static void main(String[] args) {
		int[] coins = {2, 3, 5};
		int X = 9;
		int N = coins.length;
		//System.out.println(getWaysBottomUp(coins, X));
		//.out.println(getWaysRecurssion(coins, N, X));
		
		X = 8;
		
		/*
		 * 2 + 2 + 2 + 2 
		 * 2 + 3 + 3
		 * 3 + 5
		 */
		
		//System.out.println(getWaysBottomUp(coins, X));
		System.out.println(getWaysRecurssion(coins, N, X));
		
	}

	public static int getWaysBottomUp(int[] coins, int X) {
		
		int N = coins.length;
		
		int[] dp = new int[X+1];

		dp[0] = 1;

		for(int i=0 ; i <= N-1; i++) {
			for(int j=1; j <= X; j++) {
				if(coins[i] > j)
					continue;
				dp[j] = (dp[j] + dp[j - coins[i]] );

			}
		}

		return dp[X] ;

		//return dp[N] % mod; // solution with mod constraint
	}
	
	public static int getWaysRecurssion(int[] coins, int N, int X) {

		//BC
		
		if(N-1 == 0)
			return 1;
			
		int count = 0;

		for(int i = 1; i <= X; i++) {
			if(coins[N-1] > i)
				continue;
			count = count + getWaysRecurssion(coins, N - 1,i - coins[N-1]);
		}

		return count;
	}


}
