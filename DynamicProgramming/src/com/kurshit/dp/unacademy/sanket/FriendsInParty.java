package com.kurshit.dp.unacademy.sanket;

/*
    Problem : Friends Pair
    Problem Source : https://unacademy.com/class/problem-solving-on-dynamic-programming-1/RZ4EKL69
    Solution source : https://unacademy.com/class/problem-solving-on-dynamic-programming-1/RZ4EKL69
    There are N friends who want to go to party. Each one can either go alone or can go in a pair. Count the total number of ways in which
    friends can go.

 */

public class FriendsInParty {

    public static void main(String[] args) {
        FriendsInParty fip = new FriendsInParty();
        int N = 3;
        System.out.println(fip.getCountTowDown(N));

        N = 4;
        System.out.println(fip.getCountTowDown(N));

        N = 5;
        System.out.println(fip.getCountTowDown(N));
    }

    int[] dp = new int[100005];
    public int getCountTowDown(int N) {

        if(N == 0 || N == 1) {
            return 1;
        }

        if(dp[N] != 0)
            return dp[N];

        return dp[N] = getCountTowDown(N-1) + (N-1) * getCountTowDown(N-2);

    }
}
