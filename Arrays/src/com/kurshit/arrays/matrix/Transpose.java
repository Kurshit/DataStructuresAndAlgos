package com.kurshit.arrays.matrix;

/*
 * Source : https://www.geeksforgeeks.org/program-to-find-transpose-of-a-matrix/
 * Transpose of a matrix is obtained by changing rows to columns and columns to rows. 
 * In other words, transpose of A[][] is obtained by changing A[i][j] to A[j][i].
 */

public class Transpose {
	
	public static void transpose(int[][] t, int m, int n) {
		
		for(int i =0; i < m; i++) {
			for(int j=i; j < n; j++) {
				int temp = t[i][j];
				t[i][j] = t[j][i];
				t[j][i] = temp;
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[][] t = {{1, 2, 3},
					 {4, 5, 6},
					 {7, 8, 9}};
		int m = 3;
		int n = 3;
		
		for(int i=0; i< m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		
		transpose(t, m, n);
		System.out.println();
		for(int i=0; i< m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
