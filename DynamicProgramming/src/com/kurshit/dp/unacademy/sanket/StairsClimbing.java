package com.kurshit.dp.unacademy.sanket;

/*
    Problem : Climbing stairs with k 3 jumps OR reaching end by 3-faced dice throw
    Problem Source : https://unacademy.com/class/problem-solving-on-dynamic-programming-2/0J7LXW0X
    Solution Source : https://unacademy.com/class/problem-solving-on-dynamic-programming-2/0J7LXW0X
    Problem :

        Given a three faced dice with values 1, 2 & 3. You are also given a 1 X N board. When a dice is thrown, it shows number of moves
        you can take on 1 X N board. Return the total number of ways to reach the end on the board.

        Ex: N = 3
        Output : 3

            1 1 1
            1 2
            2 1
            3

    OR : This is same problem for Climbing Stairs problem where you are given N steps of stairs and maximum jump a person can take from first step.


 */




public class StairsClimbing {


    public static void main(String[] args) {

        int N = 4;

        // {1 1 1 1}, {1, 1, 2}, {1, 2, 1}, {2, 1, 1}, {1, 3}, {3, 1}, {2, 2}  -- 7

        System.out.println(getStepsMemoization(N));
        System.out.println(getStepsBottomUp(N));
        N = 3;
        System.out.println(getStepsMemoization(N));
        System.out.println(getStepsBottomUp(N));
    }

    /*
        Approach of DP :

           Let f(N) be the number of ways in which a person can reach upto N with 3 jumps

           f(N) = f(N-1) + f(N-2) + f(N-3).

           BC : N == 0, return 1

           OR: This can also be shown as -

           f(i) : be the number of ways in which a person can reach to last step from ith step

           f(i) = f(i+1) + f(i+2) + f(i+3)

           BC : i = N return 1
     */
    static int[] dp;
    public static int getStepsMemoization(int N) {

        dp = new int[N + 1];

        return getStepsMemoizationUtil(N);

    }

    public static int getStepsMemoizationUtil(int N) {

        if(N == 0)
            return 1;

        if(N == 1)
            return 1;

        if(N == 2)
            return 2;

        if(dp[N] != 0)
            return dp[N];

        return dp[N] = getStepsMemoization(N-1) + getStepsMemoization(N-2) + getStepsMemoization(N-3);

    }

    public static int getStepsBottomUp(int N) {

        if(N == 0)
            return 1;

        if(N == 1)
            return 1;

        if(N == 2)
            return 2;

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=N; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[N];

    }

}
