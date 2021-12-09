package com.kurshit.dp.unacademy.sanket;

/*
        Given a value N, determine the number of steps to reduce N to 1.
        In one step you can either -

        1. Subtract 1 from it
        2. Or if N%2 == 0 then divide it by 2
        3. Or if N%3 == 0, then divide it by 3

       Example :

        Input : N = 7

        Output : 3 ( 7 -> 6 -> 3 -> 1)
 */

/*
     Note : Greedy will not work - Considering mad deduction

     Ex : N - 10
        Using Greedy - 4  (10 -> 5 -> 4 -> 2 -> 1)
        Using DP : 3 (10 -> 9 -> 3 -> 1)
 */


public class NumberOfOperations {

    public static void main(String[] args) {
        int N = 10;
        System.out.println(stepsBottomUp(N));
        System.out.println(stepsTopDown(N));

        System.out.println();
        N = 7;
        System.out.println(stepsBottomUp(N));
        System.out.println(stepsTopDown(N));
    }

    static int[] dp;

    public static int stepsTopDown(int N) {
        dp = new int[N+1];
        return stepsTopDownUtil(N);
    }

    public static int stepsTopDownUtil(int N) {

        if(N == 0 || N == 1)
            return dp[0] = 0;

        if(N == 2 || N == 3)
            return dp[N] = 1;

        if(dp[N] != 0)
            return dp[N];

        int divBy3 = Integer.MAX_VALUE;
        int divBy2 = Integer.MAX_VALUE;
        int subBy1 = Integer.MAX_VALUE;

        if(N % 2 == 0) {
            divBy2 = stepsTopDownUtil(N/2);
        }

        if(N % 3 == 0) {
            divBy3 = stepsTopDownUtil(N/3);
        }

        subBy1 = stepsTopDownUtil(N-1);

        return dp[N] = 1 + Math.min(divBy2, Math.min(divBy3, subBy1));


    }

    public static int stepsBottomUp(int N) {

        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            int divBy3 = Integer.MAX_VALUE;
            int divBy2 = Integer.MAX_VALUE;
            int subBy1 = Integer.MAX_VALUE;

            if(i % 2 == 0) {
                divBy2 = dp[i/2];
            }

            if(i % 3 == 0) {
                divBy3 = dp[i/3];
            }

            subBy1 = dp[i-1];

            dp[i] = 1 + Math.min(divBy2, Math.min(divBy3, subBy1));
        }

        return dp[N];

    }

}
