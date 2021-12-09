package com.kurshit.graphs.gridbased;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int M = 3;
        int N = 3;

        int[][] arr = floodFill(grid, 1, 1, 2);

        for(int[] a : arr ) {
            System.out.println(Arrays.toString(a));
        }

    }


    public static int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {

        if(grid[sr][sc] == newColor) {
            return grid;
        }
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        dfs(grid, sr, sc, M, N, grid[sr][sc], newColor, visited);
        return grid;

    }

    public static void dfs(int[][] grid, int i, int j, int M, int N, int currColor, int newColor, boolean[][] visited) {

        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == newColor || grid[i][j] != currColor || visited[i][j]) {
            return;
        }

        grid[i][j] = newColor;
        visited[i][j] = true;

        dfs(grid, i + 1, j, M, N, currColor, newColor, visited);
        dfs(grid, i - 1, j, M, N, currColor, newColor, visited);
        dfs(grid, i, j + 1, M, N, currColor, newColor, visited);
        dfs(grid, i, j - 1, M, N, currColor, newColor, visited);

        visited[i][j] = false;
    }
}
