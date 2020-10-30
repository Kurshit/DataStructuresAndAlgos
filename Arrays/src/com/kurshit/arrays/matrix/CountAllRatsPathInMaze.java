package com.kurshit.arrays.matrix;

/* Given a matrix of 0's and 1's. 
 * 
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
 * maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source
 * and has to reach the destination. The rat can move only in two directions: forward and down.
 * 
 * In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path 
 * from source to destination. Note that this is a simple version of the typical Maze problem. 
 * 
 * For example, a more complex version can be that the rat can move in 4 directions and a more 
 * complex version can be with a limited number of moves.
 *
 * Following is an example maze.
 * 
 * 			{1, 0, 0, 0}
 * 			{1, 1, 0, 1}
 * 			{0, 1, 0, 0}
 * 			{1, 1, 1, 1}
 * 
 * Solution : 
 * 			{1, 0, 0, 0}
 *			{1, 1, 0, 0}
 *			{0, 1, 0, 0}
 *			{0, 1, 1, 1}
 * 
 * All enteries in solution path are marked as 1.
 * 
 * Note : There could be more than one solution
 *   
 */

public class CountAllRatsPathInMaze {
	
	/*
	 *  Solution: 
	 *  Source : https://www.youtube.com/watch?v=_QPrHo88mAc
	 */
	
	public void printRatsPathInMaze(int[][] maze, int n) {
		
		int[][] solution = new int[n][n];
		
		printRatsPathInMazeUtil(maze, n, 0, 0, solution);
		
	}
	
	static int count = 0;
	
	public void printRatsPathInMazeUtil(int[][] maze, int n, int x, int y, int[][] solution) {
		
		if( x == n-1 && y == n-1) {
			solution[x][y] = 1;
			printSolution(solution,n);
			count++;			
			System.out.println();
			return;
		}
		
		if(x < 0 || x >= n || y <0 || y >= n || solution[x][y] == 1 || maze[x][y] == 0) {
			return;
		}
		solution[x][y] = 1;
		printRatsPathInMazeUtil(maze, n, x, y+1, solution);
		printRatsPathInMazeUtil(maze, n, x, y-1, solution);
		printRatsPathInMazeUtil(maze, n, x+1, y, solution);
		printRatsPathInMazeUtil(maze, n, x-1, y, solution);
		solution[x][y] = 0;
		
	}
	
	public void printSolution(int[][] solution, int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(solution[i][j] +" ");
			}			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		
		int[][] maze = {{1,1,0},{1,1,1},{1,1,1}};
		
		CountAllRatsPathInMaze ratMaze = new CountAllRatsPathInMaze();
		ratMaze.printRatsPathInMaze(maze, n);		
		System.out.println(count);
	}

}
