package com.kurshit.dp.atcoder.educational;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Problem Source: https://atcoder.jp/contests/dp/tasks/dp_i
 * Solution Source : https://unacademy.com/class/atcoder-dp-problem-set-2/ZTHRSSE7
 * Problem Statement :  
 * 		Let N be a positive odd number.
 * 
 * There are N coins, numbered 1,2,...N. For each i (1 <= i <= N), when Coin i is tossed, it comes up heads with probability Pi and tails with
 * probability 1 - Pi.
 * 
 * Taro has tossed all the N coins. Find the probability of having more heads than tails.
 * 
 * Constraints : 
 * 		--> N is odd number
 * 		--> 1 <= N <= 2999
 * 		--> Pi is a real number and has two decimal places.
 * 		--> 0 <Pi < 1
 * 
 *  Input: 
 *  	N
 *  	p1 p2 p3 ... pn
 *  
 *  Output: 
 *  
 *  	Print the probability of having more heads than tails. The output is considered correct whn the absolute error is NOT greater than 10-9.
 *  
 *  Sample Input: 
 *  
 *  	3
 *      0.30 0.60 0.80
 *      
 *  Sample output: 
 *  
 *  	0.612
 *  
 *  Explain : 
 *  
 *  	The probability of each case where we have more heads than tails is as follows :
 *  
 *  	-> P(C1, C2, C3) = (H, H, H) is : 0.3 * 0.6 * 0.8 = 0.144
 *  	-> P(C1, C2, C3) = (H, H, T) is : 0.3 * 0.6 * 0.2 = 0.036
 *  	-> P(C1, C2, C3) = (H, T, H) is : 0.3 * 0.4 * 0.8 = 0.096
 *  	-> P(C1, C2, C3) = (T, H, H) is : 0.7 * 0.6 * 0.8 = 0.336
 *  
 *  Thus the probability of having more heads than tails is : 0.144 + 0.036 + 0.096 + 0.336 =0.612
 */

public class CoinsProbability {
	
	private static double[][] dp = new double[3005][3005];
	
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] arr = new double[N];
		
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextDouble();
		}
		
		
		//initialize dp with -1
		
		for(int i=0; i < 3005; i++) {
			for(int j=0; j < 3005; j++) {
				dp[i][j] = -1;
			}
		}
		
		double result = getProbability(arr, N, (N+1) / 2);
		System.out.println(result);
		sc.close();
	}
	
	public static double getProbability(double[] arr, int i, int X) {
		
		if(X == 0)
			return 1;
		
		if(i == 0)
			return 0;
		
		if(dp[i][X] > -0.9) {
			return dp[i][X];
		}
		
		dp[i][X] = arr[i-1] * getProbability(arr, i - 1, X -1)	+ (1 - arr[i-1]) * getProbability(arr, i - 1, X);	
		
		return dp[i][X];
	}

}
