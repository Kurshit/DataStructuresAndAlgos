package com.kurshit.matrix.gfg;

import java.util.Arrays;

/*
 * Problem : Given a matrix, find the transpose of a matrix. Do this inplace
 * 
 * Transpose : It is a new matrix in which rows becomes columns and columns becomes rows
 * 
 * Example : 
 * 	
 * 		input : [1, 2, 3]
 *  			[4, 5, 6]
 *    			[7, 8, 9]
 *    
 *    Output: 	[1, 4, 7]
 *    			[2, 5, 8]
 *     			[3, 6, 9]
 */
 

public class TransposeOfMatrix {

	public static void main(String[] args) {
		
		int M = 3;
		int N = 3;
		int[][] grid = {
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}			
		};
		
		findTranspose(grid, M, N);
		
		for(int[] arr : grid) {
			System.out.println(Arrays.toString(arr));
		}

	}
	
	public static void findTranspose(int[][] grid, int R, int C) {
		
		for(int row=0; row < R; row++) {
			for(int col = row; col < C; col++) {
				int temp = grid[row][col];
				grid[row][col] = grid[col][row];
				grid[col][row] = temp;
			}
		}
	}

}
