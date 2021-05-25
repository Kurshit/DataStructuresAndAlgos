package com.kurshit.dp.atcoder.educational;

import java.util.Scanner;

/*
 * Problem Source : https://atcoder.jp/contests/dp/tasks/dp_d
 * Problem : There are N items number 1, 2 .. N. For each i (1 <= i <= N). Item i has a weight of Wi and a value Vi.
 * The capacity of knapsack is W. Taro needs to add items in knapsack such that profit is maximum. Items can be added to sack such that 
 * the sum of weight is at most W.
 * 
 * Constraints : 
 * 		-- 1 <= N <= 100
 * 		-- 1 <= W <= 10^5
 * 		-- 1 <= Wi <= W
 *  	-- 1 <= Vi <= 10 ^ 9
 *  
 *  Input : 
 *  
 *  	N W
 *  		
 *  	w1 v1
 *  	w2 v2
 *  	....
 *  	wn vN
 *  
 *  Sample Input 1 : 
 *  
 *  	3 8
 *  	3 30
 *  	4 50
 *  	5 60
 *  Output : 90
 *  
 *  Sample Input2 : 
 *  	
 *  	5 5
 *		6 15
 *		6 5
 *		5 6
 *		6 4
 *		6 6
 *		3 5
 *		7 2
 *
 *	Output : 17
 */

public class Knapsack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			
			int[] weights = new int[N];
			int[] values = new int[N];
			
			for(int i = 0; i < N ; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			
			System.out.println("Max Profit : " + maxProfit(N, W, weights, values));
		}
		
		sc.close();

	}

	private static int maxProfit(int N, int W, int[] weights, int[] values) {
		
		int[][] dp = new int[N+1][W+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= W; j++) {
				if(weights[i-1] > j ) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
				}				
			}
		}
		
		return dp[N-1][W];
		
	}
	
	 /* Approach 1 : Using Dynamic Programming (Not optimized). 
	 * 
	 */
	
	

}
