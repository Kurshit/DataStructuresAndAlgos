package com.kurshit.backracking.basics.riya;

/*
        Given a M X N grid o characters and a word, find if given word exist in the grid.  If it exist, return true, if not return false.

        The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may no
        be used more than once.

        Eample :


        Input: board = [
                        ["A","B","C","E"],
                        ["S","F","C","S"],
                        ["A","D","E","E"]],
               word = "ABCCED"

        Output: true

 */


public class WordSearch {

    public static void main(String[] args) {

        char[][] grid = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'F'}
        };

        int M = 3;
        int N = 4;
        String word = "ABCCSF";
        System.out.println(exist(grid, word, M, N));


    }

    public static boolean exist(char[][] grid, String word, int M, int N) {

        for(int i=0; i < M; i++) {
            for(int j=0; j < N; j++) {
                if(exist(grid, word,i, j, M, N, 0))
                    return true;
            }
        }

        return false;

    }

    /*
            Following methods works perfectly fine but calls separate recusion methods for each direction
     */

    /*private static boolean exist(char[][] grid, String word, int row, int col, int M, int N, int idx) {

        if(idx >= word.length()) {
            return true;
        }

        if(row < 0 || row ==  M || col < 0 || col == N || word.charAt(idx) != grid[row][col]) {
            return false;
        }


            grid[row][col] = '#';

            if(exist(grid, word, row + 1,col, M, N, idx + 1))
                return true;

            if(exist(grid, word, row - 1,col, M, N, idx + 1))
                return true;

            if(exist(grid, word, row ,col + 1, M, N, idx + 1))
                return true;

            if(exist(grid, word, row ,col - 1, M, N, idx + 1))
                return true;



            grid[row][col] = word.charAt(idx);

        return false;

    }*/

    private static boolean exist(char[][] grid, String word, int row, int col, int M, int N, int idx) {

        if(idx >= word.length()) {
            return true;
        }

        if(row < 0 || row ==  M || col < 0 || col == N || word.charAt(idx) != grid[row][col]) {
            return false;
        }


        grid[row][col] = '#';

        /*
            Inspite of writing for different directions separately, we could write like following
         */

        boolean res = false;
        int[] rowOff = {0, 1, 0, -1};
        int[] colOff = {1, 0, -1, 0};

        for(int d =0; d < 4; d++) {
            res = exist(grid, word, row + rowOff[d], col + colOff[d], M, N, idx +1);

            if(res)
                break;
        }



        grid[row][col] = word.charAt(idx);

        return res;  // changed here

    }

    private static boolean isSafe(char[][] grid, String word, int row, int col, int M, int N, int idx) {

        if(row < 0 || row ==  M-1 || col < 0 || col == N-1 || word.charAt(idx) != grid[row][col]) {
            return false;
        }

        return true;

    }
}
