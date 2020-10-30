package com.kurshit.arrays.matrix;

/*
 * Source : https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * Problem Statement :	
 * 		
 *  The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell. 
 *  You can either move only to right or down.
 * 	
 * 	Example 1:
 * 
 *  	maze matrix : (matrix need not to be given, as it is gonna just be a sequence of 1,2,3,.. so on. Providing just row and column length is enough.
 * 		 
 * 		Input :  m = 2, n = 2;
 * 		Matrix : (Need not to be given. Taking for this example only)
 * 				
 * 				{1, 2}
 * 				{3, 4} 	
 *  
 *		Output : 2
 *		
 *		There are two paths
 *		(0, 0) -> (0, 1) -> (1, 1)  // 1 -> 2 -> 4
 *		(0, 0) -> (1, 0) -> (1, 1)  // 1 -> 3 -> 4
 *
 *		Input :  m = 2, n = 3;
 *		Output : 3
 *	
 *		There are three paths
 *		(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 *		(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 *		(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 * 	
 * 	Solutions : There are different solutions to those. Breifely mentioned at method level 
 * 
 * 		
 * 
 */

public class CountAllPathsTwoMovesAllowed {
	
	/*
	 * Solution 1 : Using solution matrix
	 * 
	 * The following solution creates the solution matrix with initial first row and first column values = 1
	 * 
	 * For example : for  3 X 3  
	 * 
	 *    {1, 2, 3}
	 *    {4, 5, 6}
	 *    {7, 8, 9}
	 *    
	 *  Initial Solution matrix :
	 *  
	 *    {1, 1, 1}
	 *    {1, 0, 0}
	 *    {1, 0, 0}
	 *    
	 *  Now for rest of positions, it is calculated based on previus adjacent row and column values :
	 *  Like - 
	 *  
	 *  1. 
	 *    {1, 1, 1}
	 *    {1, 2, 0}
	 *    {1, 0, 0}
	 *    
	 *  2.
	 *    {1, 1, 1}
	 *    {1, 2, 3}
	 *    {1, 0, 0}
	 *
	 * 3. 
	 *    {1, 1, 1}
	 *    {1, 2, 3}
	 *    {1, 3, 0}
	 *
	 * 4. 
	 *  
	 *    {1, 1, 1}
	 *    {1, 2, 3}
	 *    {1, 3, 6}
	 *
	 *   Return last element of array - 6
	 * 
	 */
	
	
	public int countPathsUsingSolutionMatrix(int[][] maze, int n, int m) {
		
		int[][] solution = new int[n][m];
		
		for(int i =0; i<n; i++) 
			solution[i][0] = 1;
		
		for(int j=0; j<m; j++) 
			solution[0][j] = 1;
		
		for(int i=1; i < n; i++) {
			for(int j=1; j<m; j++) {
				solution[i][j] = solution[i-1][j] + solution[i][j-1];
			}
		}
		
		return solution[n-1][m-1];
	}
	
	/*
	 * Solution 2 : Using Recurrsion Only and no need of actual matrix
	 * 
	 * 	
	 * 
	 */
	
	public int countPathsUsingRecurssionOnly(int m, int n) {
			
		if(m == 1 || n ==1) {
			return 1;
		}
		
		return countPathsUsingRecurssionOnly(m -1 , n) + countPathsUsingRecurssionOnly(m, n - 1);		
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int m = 3;
		
		int[][] maze = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		CountAllPathsTwoMovesAllowed paths = new CountAllPathsTwoMovesAllowed();
			
		System.out.println(paths.countPathsUsingSolutionMatrix(maze, n, m));
		System.out.println(paths.countPathsUsingRecurssionOnly(n, m));
		
		n = 2;
		m = 2;
		
		maze = new int[][]{{1,2}, {3,4}};
		
		System.out.println(paths.countPathsUsingSolutionMatrix(maze, n, m));
		System.out.println(paths.countPathsUsingRecurssionOnly(n, m));
			
		
		n = 3;
		m = 4;
		
		
		maze = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		
		System.out.println(paths.countPathsUsingSolutionMatrix(maze, n, m));
		System.out.println(paths.countPathsUsingRecurssionOnly(n, m));
		
		
	}
	
}
