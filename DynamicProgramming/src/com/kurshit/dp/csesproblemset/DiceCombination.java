package com.kurshit.dp.csesproblemset;

/*
 * Problem Source : https://cses.fi/problemset/task/1633
 * SOlution Source : https://www.youtube.com/watch?v=sSdnSS0piIM&t=2466s
 * 
 * Problem : our task is to count the number of ways to construct sum n by throwing a dice one or more times. 
 * Each throw produces an outcome between 1 and 6.

	For example, if n=3, there are 4 ways:
	1+1+1
	1+2
	2+1
	3
	Input

	The only input line has an integer n.

	Output

	Print the number of ways modulo 109+7.

	Constraints
	1≤n≤106
	Example

	Input:
	3

	Output:
	4

	Input : 
	3

	Output : 
	8

	1 1 1 1
	1 1 2
	1 2 1
	2 1 1
	2 2
	1 3
	3 1
	4

 */

public class DiceCombination {

	public static void main(String[] args) {

		System.out.println(getWaysBottomUp(2));
		System.out.println(getWaysRecurssion(2));
		System.out.println(getWaysMemoization(2));
		
		System.out.println(getWaysBottomUp(3));		
		System.out.println(getWaysRecurssion(3));
		System.out.println(getWaysMemoization(3));
		
		System.out.println(getWaysBottomUp(4));
		System.out.println(getWaysRecurssion(4));
		System.out.println(getWaysMemoization(4));
	}
	
	static int mod = 1000000007;;
	
	public static int getWaysRecurssion(int N) {

		//BC
		
		if(N == 0 || N == 1)
			return 1;			
		
		int count = 0;
		
		for(int i =1; i <=6; i++) {

			if(i > N) {
				continue;
			}
			count = count + getWaysRecurssion(N-i);
		}

		return count;
	}

	public static int getWaysMemoization(int N) {
		
		int[] cache = new int[N+1];
		return getWaysMemoization(N, cache);

	}

	public static int getWaysMemoization(int N, int[] cache) {

		//BC

		if(N == 0 || N == 1)
			return 1;
		
		if(cache[N] != 0)
			return cache[N];

		int count = 0;

		for(int i =1; i <=6; i++) {

			if(i > N) {
				continue;
			}
			count = count + getWaysRecurssion(N-i);
		}

		return cache[N] = count;
	}

	public static int getWaysBottomUp(int N) {

		int[] dp = new int[N+1];

		dp[0] = dp[1] = 1;

		for(int i=2 ; i <= N; i++) {
			for(int j=1; j <= 6; j++) {
				if(j > i) 
					continue;
				dp[i] = (dp[i] + dp[i-j] );
				//dp[i] = (dp[i] % mod + dp[i-j] % mod) %mod;  // solution with mod constraint
			}
		}

		return dp[N] ;
		
		//return dp[N] % mod; // solution with mod constraint
	}

}
