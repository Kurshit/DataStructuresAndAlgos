package com.kurshit.graphs.codencode;

/*
 * Allowed movement U, R, D, L
 */

public class DFSOnGrid {

	public static void main(String[] args) {
		int M = 3;
		int N = 3;		
		boolean[][] visited = new boolean[M][N];

		dfs(0, 0, M, N, visited);
		System.out.println();
		boolean[][] visited1 = new boolean[M][N];
		dfsEfficient(0, 0, M, N, visited1);
	}

	public static void dfs(int x, int y, int M, int N, boolean[][] visited) {

		if(x < 0 || y < 0 || x >= M || y >= N || visited[x][y]) {
			return;
		}

		visited[x][y] = true;

		System.out.println(x + " " + y );


		dfs(x - 1, y, M, N, visited);   // Left

		dfs(x , y + 1, M, N, visited);  // Up


		dfs(x + 1, y, M, N, visited); // Right
		
		dfs(x , y - 1, M, N, visited); // Down 



	}

	private static boolean isValid(int x, int y, int M, int N, boolean[][] visited) {
		if(x < 0 || x >= M || y <0 || y >= N || visited[x][y] == true ) {
			return false;
		}

		return true;
	}

	public static void dfsEfficient(int x, int y, int M, int N, boolean[][] visited) {

		// UP, right, down, left

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		dfsEfficientUtil(x, y, M, N, visited, dx, dy);

	}

	public static void dfsEfficientUtil(int x, int y, int M, int N, boolean[][] visited, int[] dx, int[] dy) {
		visited[x][y] = true;
		System.out.println(x + " " +y);

		for(int i=0; i < 4; i++) {
			if(isValid(x + dx[i], y + dy[i], M, N, visited)) {
				dfsEfficientUtil(x + dx[i], y + dy[i],  M, N, visited, dx, dy);
			}
		}
	}

}
