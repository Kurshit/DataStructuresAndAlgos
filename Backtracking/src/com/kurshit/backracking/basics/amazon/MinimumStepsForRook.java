package com.kurshit.backracking.basics.amazon;

public class MinimumStepsForRook {

    public static void main(String[] args) {

        /*
             0 0 0 0
             0 1 0 1
             0 0 0 0
             1 0 1 0

             Output : 3
         */

        int[][] grid = {
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };

        System.out.println(getMoves(grid, 4));

    }

    public static int min = Integer.MAX_VALUE;
    public static int getMoves(int[][] grid, int N) {
        boolean[][] visited = new boolean[N][N];
        char dir = 'L';
        dfs(grid, 0, 0, N, visited, dir, 0);
        return min;
    }

    public static void dfs(int[][] grid, int i, int j, int N, boolean[][] visited, char dir, int count) {

        if(i < 0 || i >= N || j < 0 || j >= N || visited[i][j] == true) {
            return;
        }

        if(grid[i][j] == 1)
            return;

        if(i == N-1 && j == N-1) {
            min = Math.min(min, count);
        }

        visited[i][j] = true;

        dfs(grid, i, j+1, N, visited, 'R', dir == 'R' ? count : count + 1);

        dfs(grid, i, j-1, N, visited, 'L', dir == 'L' ? count : count + 1);

        dfs(grid, i + 1, j, N, visited, 'D', dir == 'D' ? count : count + 1);

        dfs(grid, i - 1, j+1, N, visited, 'U', dir == 'U' ? count : count + 1);

        visited[i][j] = false;
    }
}
