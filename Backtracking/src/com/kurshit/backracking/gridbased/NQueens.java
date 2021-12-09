package com.kurshit.backracking.gridbased;


import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {

        //placeNQueens(4);

        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}

        };
//        boolean[][] visited = new boolean[4][4];
//        markVisited(visited, 4, 0, 0);
//        markVisited(visited, 4, 0, 1);
//
//        for(int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

        placeNQueens(4);
    }

    public static void placeNQueens(int N) {
        int Q = 0;
        int[][] result = new int[N][N];

        System.out.println(canPlaceNQueen(result, N, 0, Q));

        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    private static boolean canPlaceNQueen(int[][] grid, int N, int col, int Q) {

        if(col >= N) {
            return false;
        }

        if(Q == N - 2) {
            return isValid(grid, N);
        }

        if(Q > N - 2) {
            return false;
        }

        //i represents row here
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {

                if(Q < N - 2) {
                    grid[i][j] = 1;
                    Q = Q + 1;
                    if(canPlaceNQueen(grid, N, col, Q)) {
                        return true;
                    }
                    Q = Q - 1;
                    grid[i][j] = 0;
                }

            }

        }

        return false;

    }

    static boolean isValid(int[][] grid, int N) {
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    markVisited(visited, N, i, j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }

    private static void markVisited(boolean[][] visited, int N, int row, int col) {

        //left
        for(int i = col; i >=0 ; i-- ) {
            visited[row][i] = true;
        }

        //right
        for(int i = col; i < N ; i++ ) {
            visited[row][i] = true;
        }

        //up

        for(int i = row; i >= 0 ; i-- ) {
            visited[i][col] = true;
        }

        //down
        for(int i = row; i < N ; i++ ) {
            visited[i][col] = true;
        }

        //lwft up diagonal

        //upper diagonal on left

        for(int i = row,j = col; i >=0 && j >= 0; i--, j--) {
            if(!visited[i][j]) {
                visited[i][j] = true;
            }
        }

        //lower diagnoal on left
        for(int i = row, j = col; i < N && j >= 0; i++, j-- ) {
            if(!visited[i][j]) {
                visited[i][j] = true;
            }
        }

        //upper diagonal on right

        for(int i = row,j = col; i < N && j < N; i++, j++) {
            if(!visited[i][j]) {
                visited[i][j] = true;
            }
        }

        //lower diagnoal on right
        for(int i = row, j = col; i < N && j < N; i++, j++ ) {
            if(!visited[i][j]) {
                visited[i][j] = true;
            }
        }
    }

    static boolean isSafe(int[][] grid, int N, int row, int col) {
        int i, j;

        //check current row on left side
        for( i = 0; i < col; i++) {
            if(grid[row][i] == 1) {
                return false;
            }
        }

        //upper diagonal on left
        for(i = row, j = col; i >=0 && j >= 0; i--, j--) {
            if(grid[i][j] == 1) {
                return false;
            }
        }

        //lower diagnoal on left
        for(i = row, j = col; i < N && j >= 0; i++, j-- ) {
            if(grid[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
