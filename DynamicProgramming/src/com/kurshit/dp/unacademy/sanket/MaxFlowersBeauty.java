package com.kurshit.dp.unacademy.sanket;

/*
        Problem Source : https://atcoder.jp/contests/dp/tasks/dp_q
        Problem : Similar to LIS
        Statement : There are N flowers arranged in a row. For each i (1≤i≤N), the height and the beauty of the i-th flower from the left is Hi & Ai respectively. Here, h1, h2... hn are all distinct.

        Taro is pulling out some flowers so that the following condition is met:

        The heights of the remaining flowers are monotonically increasing from left to right.
        Find the maximum possible sum of the beauties of the remaining flowers.

        Input :
        N
        h1 h2 h3 ... hN
        a1 a2 a3 ... aN

        Output:
            Print the maximum possible sum of the beauties of the remaining flowers.

        Sample Input 1:
            4
            3 1 4 2
            10 20 30 40

        O/P : 60

        Input 2 :

            1
            1
            10

        Output: 10

        Input :
            9
            4 2 5 8 3 6 1 7 9
            6 8 8 4 6 3 5 7 5
        Output: 31
 */

public class MaxFlowersBeauty {

    public static void main(String[] args) {

        int[] h = {3, 1, 4, 2};
        int[] b = {10, 20, 30, 40};
        System.out.println(maxBeauty(h, b));

        int[] h1 = {4, 2, 5, 8, 3, 6, 1, 7, 9};
        int[] b1 = {6, 8, 8, 4, 6, 3, 5, 7, 5};
        System.out.println(maxBeauty(h1, b1));
    }

    public static int maxBeauty(int[] h, int[] b) {

        int N = h.length;

        int[] LIS = new int[N];

        for(int i = 0; i < N; i++) {
            LIS[i] = b[i];
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(h[i] > h[j] && LIS[j] + b[i] > LIS[i]) {
                    LIS[i] = LIS[j] + b[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int item : LIS) {
            max = Math.max(max, item);
        }

        return max;
    }
}
