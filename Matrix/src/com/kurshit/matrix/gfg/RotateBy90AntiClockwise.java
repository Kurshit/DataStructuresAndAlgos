package com.kurshit.matrix.gfg;

import java.util.Arrays;

/*
 * Problem: Given a matrix, rotate it by 90 degrees in anti-clock wise direction: (Reverse Columns after T')
 * 
 * Example: 
 * 
 * 		Input:
 * 				[1, 2, 3],
 * 				[4, 5, 6],
 * 				[7, 8, 9]
 * 
 * 		Output: 
 * 				[3, 2, 9]
 * 				[2, 5, 8]
 * 				[1, 8, 7]
 * 				
 */

public class RotateBy90AntiClockwise {

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
		ReverseColumns.reverseColumns(grid, m, n);
		
	}
}
