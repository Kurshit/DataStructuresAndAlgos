package com.kurshit.dp.atcoder.educational;

import java.io.InputStream;
import java.util.Scanner;

/*
 * Problem Source : https://atcoder.jp/contests/dp/tasks/dp_c
 * 
 * Problem : Taro's summer vacation starts tomorrow and he has decided to make plans for it now.
 * 
 * Vacation consist of N days. For each i (1 <= i <= N), Taro will choose one of the following activities and do it on ith Day -
 * 
 * 	 	-- A : Swim. Gain Ai point of happiness
 * 		-- B : Catch bugs : Gain Bi point of happiness.
 * 		-- C : Do HW : Gain Ci points of happiness.
 * 
 *  Taro can't do same activity on two or more consecutive days.
 *  
 *  Find the max possible total points of happiness Taro can gain.
 *  
 *  Input : 
 *  
 *  		N
 *  		a1 b1 c1
 *  		a2 b2 c2
 *  		.......
 *  		.......
 *  		aN bN cN
 *  
 *  Example 1 : 
 *  
 *  		3
 *  		10 40 70
 *  		20 50 80
 *  		30 60 90
 *  
 *  Output :
 *  		210
 *   
 */

public class VacationHappiness {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();

			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt(); 

			int[][] dp = new int[3][N]; // [Activity][Days]

			dp[0][0] = A;  // activity 0 on Day 0 : A happiness
			dp[1][0] = B;  // activity 1 on Day 1 : B Happiness
			dp[2][0] = C;  // activity 2 on Day 2 : C Happiness

			for(int i = 1; i < N; i++) {

				A = sc.nextInt();
				B = sc.nextInt();
				C = sc.nextInt();

				dp[0][i] = A + Math.max(dp[1][i-1], dp[2][i-1]);
				dp[1][i] = B + Math.max(dp[0][i-1], dp[2][i-1]);
				dp[2][i] = C + Math.max(dp[0][i-1], dp[1][i-1]);

			}

			int result =  Math.max(dp[0][N-1], Math.max(dp[1][N-1], dp[2][N-1]));

			System.out.println(result);

		}

	}


}
