package com.kurshit.dp.atcoder.educational;

import java.util.Scanner;

/*
 * Problem Source : https://atcoder.jp/contests/dp/tasks/dp_h
 * Solution Source : https://unacademy.com/class/atcoder-dp-problem-set-2/ZTHRSSE7
 * Statement : There is a grid with H horizontal rows & W vertical columns. Let (i,j) denote the square at ith row and jth column from left.
 *  Square (i,j) is described by a character Aij. If Aij is ".", square (i,j) is an empty square; if it is "#", then that suqare is a wall square.
 *  It is guranteed that square (1,1) and (H, W) are empty squares.
 *  
 *  Taro will start from square (1,1), and reach (H,W) by repeatedly moving right or down to an adjacent empty square.
 *  
 *  Find the number of total paths from (1,1) to (H,W). As the answer can be extremely large, find the count modulo 10^9 + 7.
 *  
 *  Constraints : 
 *  	--> H & W are integers
 *  	--> 2 <= H, W <= 1000
 *  	--> Aij is . or #
 *  	--> Squares (1,1) & (H,W) are empty
 *  
 *  Input: 
 *  	H       W 
 *  	A1q ... A1W
 *  	..........
 *  	AH1 ... AHW.
 *  
 *  Output: 
 *  	Total paths from (1,1) to (H,W), modulo 10^9 + 7.
 *  
 *  Sample Input: 
 *  
 *  	3  4
 *      . . . #
 *      . # . .
 *      . . . .
 *      
 *   Output : 
 *   		3
 *   
 *   Sample Input 2 : 
 *   
 *   	5 2
 *   	. .
 *    	# .
 *    	. .
 *    	. #
 *    	. .
 *    
 *   Output: 
 *   
 *   	0
 */

public class Grid1 {
	
	public static void main(String[] args) {
		int mod = 10000007;
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			char[][] grid = new char[M][N];
			
			for(int i=0; i < M; i++) {
				for(int j=0; j < N; j++) {
					grid[i][j] = sc.next().charAt(0);
				}
			}
			
			System.out.println(getTotalPaths(grid, M, N));
		}
		
		

	}
	
	public static int getTotalPaths(char[][] grid, int M, int N) {
		
		int[][] dp = new int[M][N];
		boolean isHash = false;
		
		for(int i =0; i< M; i++) {
			if(isHash) {
				dp[i][0] = 0;
				continue;
			}
			
			if(grid[i][0] == '.') {
				dp[i][0] = 1;
			} else {
				dp[i][0] = 0;
				isHash = true;
			}
		}
		
		isHash = false;
		
		for(int i =0; i< N; i++) {
			if(isHash) {
				dp[0][i] = 0;
				continue;
			}
			
			if(grid[0][i] == '.') {
				dp[0][i] = 1;
			} else {
				dp[0][i] = 0;
				isHash = true;
			}
		}
		
		for(int i = 1; i < M; i++) {
			for(int j = 1; j < N; j++) {
				if(grid[i][j] == '#') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		
		return dp[M-1][N-1];
		
	}

}
