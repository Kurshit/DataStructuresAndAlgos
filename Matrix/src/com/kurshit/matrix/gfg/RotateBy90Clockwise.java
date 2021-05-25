package com.kurshit.matrix.gfg;

import java.util.Arrays;

/*
 * Problem: Given a matrix, rotate it by 90 degrees in clock wise direction: (Reverse Rows after T')
 * 
 * Example: 
 * 
 * 		Input:
 * 				[1, 2, 3],
 * 				[4, 5, 6],
 * 				[7, 8, 9]
 * 
 * 		Output: 
 * 				[7, 4, 1]
 * 				[8, 5, 2]
 * 				[9, 6, 3]
 * 				
 */

public class RotateBy90Clockwise {

	public static void main(String[] args) {
		
		int M = 3;
		int N = 3;
		int[][] grid = {
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}			
		};
		
		rorateClockwise(grid, M, N);
		
		for(int[] arr : grid) {
			System.out.println(Arrays.toString(arr));
		}	

	}

	public static void rorateClockwise(int[][] grid, int m, int n) {
		
		TransposeOfMatrix.findTranspose(grid, m, n);
		ReverseRows.reverseRows(grid, m, n);
		
		
	}
	
	

}
