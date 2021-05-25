package com.kurshit.backracking.basics.sanket;

/*
 * Problem: Given a grid of m X n, There is a rat at position 0,0 and needs to go to m-1, n1 positon.
 * Ther are several squares which are blocked and indicated by 1 and Valid path with 0. You need to tell number of available valid paths
 * for rat to reach to destination with following constraint.  
 * 
 * Constraint : 
 * 	1. Rat can move in four directions - U, L, R, D
 *  2. Every cell can be visited only once
 * 
 * Example: 
 * 
 * 		m = 5, n = 4
 * 
 * 		{ 0, 0, 0, 0}
 * 		{ 0, 0, 0, 1}
 * 		{ 0, 0, 0, 1}
 * 		{ 0, 1, 0, 0}
 * 		{ 0, 1, 0, 0}
 * 
 * 	Output : 10
 * 
 */

public class RatInMazeOne {

	public static void main(String[] args) {
		int M = 7, N = 7;
		int[][] grid= {
				{ 0, 0, 1, 0, 0, 1, 0},
				{ 1, 0, 1, 1, 0, 0, 0},
				{ 0, 0, 0, 0, 1, 0, 1},
				{ 1, 0, 1, 0, 0, 0, 0},
				{ 1, 0, 1, 1, 0, 1, 0},
				{ 1, 0, 0, 0, 0, 1, 0},
				{ 1, 1, 1, 1, 0, 0, 0},
		};
		
		System.out.println(countPaths(grid, M, N));

	}
	static int count = 0;
	public static int countPaths(int[][] grid, int M, int N ) {
		boolean[][] visited = new boolean[M][N];
		dfs(grid, 0, 0, M, N, visited);	
		return count;
	}
	
	public static void dfs(int[][] grid, int X, int Y, int M, int N, boolean[][] visited) {
		
		if(X == M-1 && Y == N-1) {
			count = count + 1;
			return;
		}
		
		if(X < 0 || X > M-1 || Y < 0 || Y > N-1 || grid[X][Y] == 1 || visited[X][Y] == true) {
			return;
		}
		
		
		
		visited[X][Y] = true;
		
		dfs(grid, X - 1, Y, M, N, visited);
		dfs(grid, X + 1, Y, M, N, visited);
		dfs(grid, X , Y - 1, M, N, visited);
		dfs(grid, X, Y + 1 , M, N, visited);
		visited[X][Y] = false;
		
	}
	

}
