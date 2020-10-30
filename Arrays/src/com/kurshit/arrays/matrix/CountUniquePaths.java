package com.kurshit.arrays.matrix;

/*
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * https://leetcode.com/problems/unique-paths/
 * 
 *  Problem : The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the 
 *  constraints that from each cell you can either move only to right or down.
 *  
 */

public class CountUniquePaths {
	
	/* Approach 1: Using recursion - 2(n+m)
	 * 
	 */
	
	public static int countPaths(int m, int n) {
		
		if(m == 0 && n == 0) 
			return 0;
		
		if(m ==1 || n ==1)
			return 1;
		
		return countPaths(m-1, n) +  countPaths(m, n-1);
	}
	
	/*
	 * Approach 2: Using DP  -- O( n*m)
	 * 
	 * The number of ways to reach in particular cell is addition of its above and left cell.
	 */
	
	public static int countPathsDP(int m, int n) {
		
		int[][] t = new int[m][n];
		
		for(int i=0; i < m; i++)
			for(int j=0; j<n; j++)
				t[i][j] = 1;
		
		for(int i=1; i < m; i++) {
			for(int j=1; j<n; j++) {
				t[i][j] = t[i][j-1] + t[i-1][j];
			}
		}
		
		return t[m-1][n-1];
	}

	public static void main(String[] args) {
		
		int m = 3;
		int n = 3;
		
		System.out.println(countPaths(m, n));
		System.out.println(countPathsDP(m, n));

	}

}
