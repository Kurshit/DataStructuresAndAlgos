package com.kurshit.graphs.unacademy.sanket;


/*
    Problem : Word Search LC # https://leetcode.com/problems/word-search/
    Problem Source : https://leetcode.com/problems/word-search/
    Solution SOurce : Sanket - https://unacademy.com/class/graph-interview-problems-part-1/B9V2XRWD

    You have been given a grid of characters and also given a word.

    In the grid, we can construct the word by taking any adjacent non diagonal characters ( i.e 4 directions - U, D, L ,R). Also, the same letter of grid
    can only be used once.

    Find if a given word exists in the grid.

    E.g :
    Grid[] =
    [ A, B, C, E],
    [ S, F, C, S],
    [ A, D, E, E]

    Word : ABCCED

    Output: YES

 */

public class WordInGrid {

    public static void main(String[] args) {

        int M = 3, N = 4;
        String word = "ABCCED";
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        //exp : true
        System.out.println(doesExist(grid, M, N, word));

        char[][] grid1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "SEE";
        //expected true
        System.out.println(doesExist(grid1, M, N, word));

        char[][] grid2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCCES";
        //expected false
        System.out.println(doesExist(grid2, M, N,  word));
    }

    /*
            TC: O(N2 * 3 ^ len(word))
            1. To search first character - you will make N2 searches in worst case - O(N2)
            2. Further, you have 4 directions - you have N2 cells and for each cell you have four choises - it is O(4^N2)
            3. Total so far is O(N2 * 4 ^ N2). But this is also very loose bound
            4. When we go for further words, one choise goes away because of parents and you look in 3 direcstions - So O(N2 * 3 ^ N2)
            5. Also, we do not need to go to N2 but upto length of word
            Final O(N2 * 3 ^ len(word)
     */

    public static boolean doesExist(char[][] grid, int M, int N, String word) {

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++ ) {
                if(grid[i][j] == word.charAt(0)) {
                    //if(dfs(grid, M, N, i, j, word, 0))  tbis will also work
                    if(dfsBetter(grid, M, N, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    /*
        Few points :
        1. visited array could also have worked and in first if we would have checked if visited[i][j] = true, then return and while backtracking visited[i][j] would have been set to false. But to avoid it, we can also change character to special character. But in this case, no need to check grid[i][j] = '$
        and return false in first if because it anyway won't match character further.
     */

    public static boolean dfs(char[][] grid, int M, int N, int i, int j, String word, int idx) {

        if(i < 0 || i >= M || j < 0 || j >= N) {
            return false;
        }

        if(idx >= word.length())
            return false;

        if(grid[i][j] != word.charAt(idx)) {
            return false;
        }

        if(idx == word.length()-1) {
            return true;
        }

        grid[i][j] = '$';


        if(dfs(grid, M, N, i, j+1, word, idx + 1)) {
            return true;
        }
        if(dfs(grid, M, N, i, j-1, word, idx + 1)) {
            return true;
        }
        if(dfs(grid, M, N, i + 1, j, word, idx + 1)) {
            return true;
        }

        if(dfs(grid, M, N, i - 1, j, word, idx + 1)) {
            return true;
        }

        //backtrack
        grid[i][j] = word.charAt(idx);

        return false;

    }

    public static boolean dfsBetter(char[][] grid, int M, int N, int i, int j, String word, int idx) {

        if(i < 0 || i >= M || j < 0 || j >= N) {
            return false;
        }

        if(idx >= word.length())
            return false;

        if(grid[i][j] != word.charAt(idx)) {
            return false;
        }

        if(idx == word.length()-1) {
            return true;
        }

        grid[i][j] = '$';
        //L, R, U, D
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        for(int d = 0; d <4; d++) {

            if(dfsBetter(grid, M, N, i + dirX[d], j + dirY[d], word, idx + 1)) {
                return true;
            }
        }
        //backtrack
        grid[i][j] = word.charAt(idx);

        return false;

    }

}
