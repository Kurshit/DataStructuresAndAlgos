package com.kurshit.dp.unacademy.sanket;

/*
    Problem :
    Problem source : https://unacademy.com/class/problem-solving-on-dynamic-programming-2/0J7LXW0X
    Solution Source : https://unacademy.com/class/problem-solving-on-dynamic-programming-2/0J7LXW0X
    Problem Statement : You are given an array of size N. a[i] represents the amount of gold present in ith house. There is a robber who plans a robbery such that if he loots the ith house then he cant loose the (i-1) or (i+1) house. (If he loots consecutive houses, alarms can raise.
    Calculate the maximum profit that he can make with this strategy.

    Example : arr - [2, 7, 9, 3 , 1]
    Output : 12 (2, 9, 1)

 */

import java.util.Arrays;

public class MaximumRobbery {

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 1, 1};
        System.out.println(maxRobberyMemoization(arr));
        System.out.println(maxRobberyBottomUp(arr));
    }

    /*
        Approach 1 : Using Memoization O (N)

     */
    static int[] dp;
    public static int maxRobberyMemoization(int[] arr) {
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return maxRobberyMemoization(arr, arr.length);
    }

    public static int maxRobberyMemoization(int[] arr, int N) {

        if(N == 0)
            return 0;

        if(N == 1) {
            return arr[0];
        }

        if(dp[N] != -1) {
            return dp[N];
        }

        if(N == 2) {
            return dp[N] = Math.max(arr[0], arr[1]);
        }

        return dp[N] = Math.max(maxRobberyMemoization(arr, N-1), arr[N-1] + maxRobberyMemoization(arr, N-2));
    }


    /*
        Approach 2 : Using bottom up

     */

    public static int maxRobberyBottomUp(int[] arr) {

        int N = arr.length;

        if(N == 0)
            return 0;
        if(N == 1)
            return arr[0];

        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);


        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], arr[i-1] + dp[i-2]);
        }

        return dp[N];

    }


}
