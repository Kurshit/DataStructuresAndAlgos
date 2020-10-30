package com.kurshit.arrays.matrix;

/*
 * Source : https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/?ref=rp
 * 
 * Problem: The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the 
 * constraints that from each cell you can either move only to right or down.
 * 
 */

public class PrintUniquePaths {
	
	public static void printPaths(int[] path, int m, int n, int currIndex ) {
		
		path[currIndex] = n;
		
		if( m ==0 && n ==0) {
			printArray(path);
			return;
		}
		
		if(m == 0) {
			printPaths(path, m, n-1, currIndex - 1);
			return;
		}
		
		if(n == 0) {
			printPaths(path, m -1 , n, currIndex - 1);
			return;
		}
		
		printPaths(path, m, n -1, currIndex - 1);
		printPaths(path, m-1, n, currIndex - 1);
	}
	
	public static void printPathsActual(int[][] t, int[] path, int m, int n, int currIndex ) {
		
		path[currIndex] = t[m][n];
		
		if( m ==0 && n ==0) {
			printArray(path);
			return;
		}
		
		if(m == 0) {
			printPathsActual(t, path, m, n-1, currIndex - 1);
			return;
		}
		
		if(n == 0) {
			printPathsActual(t, path, m -1 , n, currIndex - 1);
			return;
		}
		
		printPathsActual(t,path, m, n -1, currIndex - 1);
		printPathsActual(t,path, m-1, n, currIndex - 1);
	}
	
	private static void printArray(int[] path) {
		
		for(int i : path) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		int m = 3;
		int n = 3;
		
		int[] path = new int[m+n-1];
		//printPaths(path, m-1, n-1, path.length-1);
		System.out.println();
		int[][] t = {{1, 2, 3},
					 {4, 5, 6},
					 {7, 8, 9}};
		
		printPathsActual(t,path, m-1, n-1, path.length-1);
		
	}

}
