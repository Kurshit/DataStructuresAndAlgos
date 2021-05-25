package com.kurshit.matrix.gfg;

import java.util.Arrays;

/*
 * Problem: Given a matrix, reverse all the columns of a matrix.
 * 
 * Example : 
 * 	
 * 		input : [1, 2, 3]
 *  			[4, 5, 6]
 *    			[7, 8, 9]
 *    
 *    Output: 	[7, 8, 9]
 *    			[4, 5, 6]
 *     			[1, 2, 3]
 */


public class ReverseColumns {

	public static void main(String[] args) {
		int M = 3;
		int N = 3;
		int[][] grid = {
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}			
		};
		
		reverseColumns(grid,M, N );
		
		for(int[] arr : grid) {
			System.out.println(Arrays.toString(arr));
		}

	}
	
	public static void reverseColumns(int[][] grid, int R, int C) {
		
		for(int col = 0; col < C; col++) {
			for(int row =0; row < R/2; row++) {
				int temp = grid[row][col];
				grid[row][col] = grid[R - row - 1][col];
				grid[R - row - 1][col] = temp;
			}
		}
		
	}

}
