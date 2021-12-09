package com.kurshit.dp.unacademy.sanket;/*
    Problem : MCoin games
    Problem Source : SPOJ and Sanket Singh - https://unacademy.com/class/problem-solving-on-dynamic-programming-4/A325QITE
    SPOJ Link :
    Statement : Asen and Boyan are playing the following game. They choose two different positive integers K and L, and start the game with a tower of N coins. Asen always plays first, Boyan – second, after that – Asen again, then Boyan, and so on. The boy in turn can take 1, K or L coins from the tower. The winner is the boy, who takes the last coin (or coins). After a long, long playing, Asen realizes that there are cases in which he could win, no matter how Boyan plays. And in all other cases Boyan being careful can win, no matter how Asen plays.

    So, before the start of the game Asen is eager to know what game case they have. Write a program coins which help Asen to predict the game result for given K, L and N.

    INPUT
    The input describes m games.

    The first line of the standard input contains the integers K, L and m, 1 < K < L < 10, 3 < m < 50. The second line contains m integers N1, N2, …, Nm, 1 ≤ Ni ≤ 1 000 000, i = 1, 2, …., m, representing the number of coins in each of the m towers

    SAMPLE INPUT
    2 3 5
    3 12 113 25714 88888
    OUTPUT
    The standard output contains a string of length m composed of letters A and B. If Asen wins the ith game (no matter how the opponent plays), the ith letter of the string has to be A. When Boyan wins the ith game (no matter how Asen plays), the ith letter of the string has to be B.

    SAMPLE OUTPUT
    ABAAB

 */

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

public class CoinsGame {

    public static void main(String[] args) {
        int K = 2;
        int L = 3;
        int M = 3;

        int[] arr = { 3, 12, 113};

        String result = whoWinsTopDown(K, L, M, arr);
        System.out.println(result);

        result = whoWinsBottomUp(K, L, M, arr);
        System.out.println(result);
    }

    static int[] dp = new int[10000005];
    public static String whoWinsTopDown(int K, int L, int M, int[] arr) {

        String s = "";

        for(int i = 0; i < M; i++) {
            Arrays.fill(dp, -1);
            s = s + ( whoWinsTopDown(K, L, arr[i]) == 1 ? "A" : "B");
        }

        return  s;

    }

    public static String whoWinsBottomUp(int K, int L, int M, int[] arr) {

        String s = "";

        for(int i = 0; i < M; i++) {
            Arrays.fill(dp, -1);
            s = s + ( whoWinsTopDown(K, L, arr[i]) == 1 ? "A" : "B");
        }

        return  s;

    }

    private static int whoWinsTopDown(int K, int L, int N) {

        if(N == 1 || N == K  || N == L )
            return dp[N] = 1;

        if(dp[N] != -1) {
            return dp[N];
        }

        boolean temp = (whoWinsTopDown(K, L, N-1) == 1 ? true : false) && (N-K >=0 ? whoWinsTopDown(K, L, N-K) == 1 ? true : false : true)
         && (N-L >= 0 ? whoWinsTopDown(K, L, N-L) == 1 ? true : false : true);

        temp = !temp;

        if(temp) {
            return dp[N] = 1;
        } else {
            return dp[N] = 0;
        }

    }

    public static int whoWinsBottomUp(int K, int L, int N) {

        dp[1] = 1;
        dp[K] = 1;
        dp[L] = 1;

        for(int i = 2; i < dp.length; i++) {
            boolean result = (dp[i-1] == 1 ? true : false) && ((i-K >= 0) ? (dp[i-K] == 1 ? true : false) : true) && ((i-L >= 0) ? (dp[i-L] == 1 ? true : false) : true);

            result = !result;

            if(result) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }


        return dp[N];

    }
}

