package com.kurshit.graphs.gridbased;

/*
	This problem can also be solved by DSU and BFS
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

	public static void main(String[] args) {

		int grid[][] = new int[][] {
				{ 1, 1, 0, 0, 0 },
				{ 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 1 }
		};

		NumberOfIsland island = new NumberOfIsland();
		//expected 3
		System.out.println(island.numOfIslands(grid));
	}

	/*
		TC : O(M X N)
		Every cell be touched once either in DFS or loop - Total Cells - N2

		SC : O(M X N)
		Takes recursion space
	 */

	public int numOfIslands(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int M = grid.length;
		int N = grid[0].length;
		int num_islands = 0;
		for (int r = 0; r < M; ++r) {
			for (int c = 0; c < N; ++c) {
				if (grid[r][c] == 1) {
					//dfs(grid, r, c, M, N);
					//dfsBetter(grid, r, c, M, N);
					bfs(grid, r, c, M, N);
					++num_islands;
				}
			}
		}

		return num_islands;
	}

	void dfs(int[][] grid, int i, int j, int M, int N) {

		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;

		dfs(grid, i, j + 1, M, N);
		dfs(grid, i, j - 1, M, N);
		dfs(grid, i + 1, j, M, N);
		dfs(grid, i - 1, j, M, N);

	}

	int[] dirx = {0, 0, 1, -1};
	int[] diry = {1, -1, 0, 0};

	void dfsBetter(int[][] grid, int i, int j, int M, int N) {

		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;

		for(int d = 0; d < 4; d++) {
			dfs(grid, i + dirx[d], j + diry[d], M, N);
		}

	}

	public void bfs(int[][] grid, int i, int j, int M, int N) {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[]{i, j});

		while(!q.isEmpty()) {
			int[] cell = q.poll();

			for(int d = 0; d < 4; d++) {

				int x = cell[0] + dirx[d];
				int y = cell[1] + diry[d];

				if(isSafe(grid, M, N, x, y)) {
					grid[x][y] = 0;
					q.offer(new int[]{x, y});
				}
			}
		}

	}

	private boolean isSafe(int[][] grid, int M, int N, int i, int j) {

		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0)
			return false;

		return true;
	}


}
