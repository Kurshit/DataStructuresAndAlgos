package com.kurshit.graphs.unacademy.sanket;

/*
    Problem Source : https://unacademy.com/class/graph-interview-problems-part-2/UUUUVBUH - Graph Interview Problems Part 2
    https://leetcode.com/discuss/interview-question/476340/Google-or-Onsite-or-Min-Modifications
    Problem :
    Given a matrix of direction with L, R, U, D, at any point you can move to the direction which is written over the cell [i, j]. We have to tell minimum number of modifications to reach from [0, 0] to [N - 1, M - 1] .
    Each replacement costs 1 unit.

    Example :-
    R R D
    L L L
    U U R
    Answer is 1, we can modify cell [1, 2] from L To D.



 */

import java.util.*;

public class MinModifications {

    public static void main(String[] args) {

        char[][] grid = {
                {'R', 'R', 'D'},
                {'L', 'L', 'L'},
                {'U', 'U', 'R'}
        };

        System.out.println(modifications(grid, 3, 3));

    }

    /*
        Solution Approach : 0-1 BFS : It is like a graph with either 0 or 1 weight
        Use DeQueue - If weight is 0, push to front - if weight is 1, push to end
     */

    public static int modifications(char[][] grid, int M , int N) {

        Deque<Triplets> q = new LinkedList<>();

        int[] dirx = {-1, 1, 0, 0};
        int[] diry = {0, 0, -1, 1};
        boolean[][] visited = new boolean[M][N];

        q.offerFirst(new Triplets(0, 0, 0));
        int result = 0;
        while(!q.isEmpty()) {
            Triplets curr = q.pollFirst();
            visited[curr.x][curr.y] = true;
            if(curr.x == M-1 && curr.y == N-1) {
                return curr.cost;
            }

            for(int d  = 0; d < 4; d++) {
                int x = curr.x + dirx[d];
                int y = curr.y + diry[d];

                if(x < 0 || x >= M || y < 0 || y >= N || visited[x][y]) {
                    continue;
                }

                int cost = 0;

                if(grid[curr.x][curr.y] == 'U' && dirx[d] == -1 && diry[d] == 0)
                    cost =0;
                else if(grid[curr.x][curr.y] == 'D' && dirx[d] == 1 && diry[d] == 0)
                    cost = 0;
                else if(grid[curr.x][curr.y] == 'L' && dirx[d] == 0 && diry[d] == -1)
                    cost = 0;
                else if(grid[curr.x][curr.y] == 'R' && dirx[d] == 0 && diry[d] == 1)
                    cost = 0;
                else
                    cost = 1;

                if(cost == 1) {
                    q.offerLast(new Triplets(x, y, curr.cost + cost));
                } else {
                    q.offerFirst(new Triplets(x, y, curr.cost));
                }
            }
        }

        return -1;

    }

    public static class Triplets {
        int x;
        int y;
        int cost;

        public Triplets(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }


}
