package com.kurshit.graphs.codencode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Allowed movement U, R, D, L
 */

public class BFSOnGrid {

	public static void main(String[] args) {
		
		int M = 4;
		int N = 4;		
				
		bfs(0, 0, M, N);

	}
	
	public static void bfs(int x, int y, int M, int N) {
		
		boolean[][] visited = new boolean[M][N];
		int[][] dist = new int[M][N];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[]{x,y});
		
		visited[x][y] = true;
		//Directions U, R, D, L
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		
		while(!queue.isEmpty()) {
			int[] currentXY = queue.poll();
			
			for(int i=0; i < M; i++) {
				if(isValid(currentXY[0] + dx[i], currentXY[1] + dy[i], M, N, visited)) {
					int newX = currentXY[0] + dx[i];
					int newY = currentXY[1] + dy[i];
					
					queue.offer(new int[] {newX, newY});
					dist[newX][newY] = dist[currentXY[0]][currentXY[1]] + 1;
					visited[newX][newY] = true;
				}
				
			}	
			
		}
		
		for(int i=0; i< M; i++) {
			for(int j=0; j < N; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean isValid(int x, int y, int M, int N, boolean[][] visited) {
		if(x < 0 || x >= M || y <0 || y >= N || visited[x][y] == true ) {
			return false;
		}
		
		return true;
	}

}
