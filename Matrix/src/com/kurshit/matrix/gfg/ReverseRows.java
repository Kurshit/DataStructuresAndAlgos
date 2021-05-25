package com.kurshit.matrix.gfg;

import java.util.Arrays;

/*
 * Problem: Given a matrix, reverse all the rows of a matrix.
 * 
 * Example : 
 * 	
 * 		input : [1, 2, 3]
 *  			[4, 5, 6]
 *    			[7, 8, 9]
 *    
 *    Output: 	[3, 2, 1]
 *    			[6, 5, 4]
 *     			[9, 8, 7]
 */


public class ReverseRows {

	public static void main(String[] args) {
		int M = 3;
		int N = 3;
		int[][] grid = {
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}			
		};
		
		reverseRows(grid,M, N );
		//Following also works fine. Uncomment to try
		
		//reverseRowsUsingArrayReversal(grid, M, N);
		
		for(int[] arr : grid) {
			System.out.println(Arrays.toString(arr));
		}	

	}
	
	public static void reverseRows(int[][] grid, int R, int C) {
		
		for(int row = 0; row < R ; row++) {
			for(int col =0; col < C/2; col++) {
				int temp = grid[row][col];
				grid[row][col] = grid[row][C - col - 1];
				grid[row][C - col - 1] = temp;
			}
		}
		
	}
	
	public static void reverseRowsUsingArrayReversal(int[][] grid, int R, int C) {
		for(int[] arr : grid) {
			reverseArray(arr);
		}
	}
	
	private static void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end ) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			 end--;
		}
	}

}
