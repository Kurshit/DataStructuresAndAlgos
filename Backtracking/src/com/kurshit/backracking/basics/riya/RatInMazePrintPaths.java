package com.kurshit.backracking.basics.riya;

/*
        Given a grid of M X N,
 */

public class RatInMazePrintPaths {

    public static void main(String[] args) {
        int M = 4;
        int N = 4;
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };
        //expected total paths - 4
        ratsAllPaths(grid, M, N);

        M = 7;
        N = 7;
        int[][] grid1 = {
                { 1, 1, 0, 1, 1, 0, 1},
                { 0, 1, 0, 0, 1, 1, 1},
                { 1, 1, 1, 1, 0, 1, 0},
                { 0, 1, 0, 1, 1, 1, 1},
                { 0, 1, 0, 0, 1, 0, 1},
                { 0, 1, 1, 1, 1, 0, 1},
                { 0, 0, 0, 0, 1, 1, 1},
        };

        System.out.println(" ******* ");
        //total expected paths 4
        ratsAllPaths(grid1, M, N);




    }

    public static void ratsAllPaths(int[][] grid, int M, int N) {


        int[][] ans = new int[M][N];

        if(dfs(grid, 0, 0, M, N, ans) == false) {
            return;
        }


    }

    public static void printPath(int[][] ans, int M, int N) {
        for(int i=0; i < M; i++) {
            for(int j=0; j < N; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static boolean dfs(int[][] grid, int row, int col, int M, int N, int[][] ans) {

        if(row == M-1 && col == N-1) {
            ans[row][col] = 1;
            printPath(ans, M, N);
        }

        if(isSafe(grid, row, col, M, N, ans)) {

            //do
            ans[row][col] = 1;

            //recurse

            if(dfs(grid, row + 1, col, M, N, ans)) {
                return true;
            }

            if(dfs(grid, row -1, col, M, N, ans)) {
                return true;
            }

            if(dfs(grid, row, col + 1, M, N, ans)) {
                return true;
            }

            if(dfs(grid, row, col - 1, M, N, ans)) {
                return true;
            }

            //undo

            ans[row][col] = 0;

            return false;


        }

        return false;


    }

    private static boolean isSafe(int[][] grid, int row, int col, int M, int N, int[][] ans) {

        if(row < 0 || row >= M || col < 0 || col >= N || grid[row][col] == 0 || ans[row][col] == 1)
            return false;

        return true;

    }
}
