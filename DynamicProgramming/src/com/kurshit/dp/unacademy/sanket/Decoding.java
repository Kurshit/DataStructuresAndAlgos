package com.kurshit.dp.unacademy.sanket;

/*
    Problem : Decoding ways - Leetcode # 91
    Problem Source : https://leetcode.com/problems/decode-ways/
    Solution source : https://unacademy.com/class/problem-solving-on-dynamic-programming-1/RZ4EKL69
    Problem :A message containing letters from A-Z can be encoded into numbers using the following mapping:

        'A' -> "1"
        'B' -> "2"
        ...
        'Z' -> "26"
        To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

        "AAJF" with the grouping (1 1 10 6)
        "KJF" with the grouping (11 10 6)
        Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

        Given a string s containing only digits, return the number of ways to decode it.

        The answer is guaranteed to fit in a 32-bit integer.

        Example 1:

        Input: s = "12"
        Output: 2
        Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
        Example 2:

        Input: s = "226"
        Output: 3
        Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Decoding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            String s = sc.next();
            System.out.println(getTotalDecodingCountTopDown(s));
            System.out.println(getTotalDecodingCountBottomUp(s));

            System.out.println(getTotalDecodingCountTopDownGfg(s));

        }

        sc.close();

    }

    public static int getTotalDecodingCountTopDown(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return getTotalDecodingCountTopDown(s, s.length());
    }

    public static int getTotalDecodingCountTopDown(String s, int i) {

        if(i == 0 ) {
            return 1;
        }

        if(dp[i] != -1)
            return dp[i];

        int ans = 0;

        if(s.charAt(i-1) -'0' > 0) {
            ans += getTotalDecodingCountTopDown(s, i-1);
        }

        if(i-2 >=0 && s.charAt(i-2) - '0' > 0 && (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0') <= 26) {
            ans += getTotalDecodingCountTopDown(s, i-2);
        }

        return dp[i] = ans;
    }

    public static int getTotalDecodingCountBottomUp(String s ) {

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        if(s.charAt(0) == '0')
            return 0;

        for(int i = 2; i <= s.length(); i++) {
            dp[i] = 0;

            if (s.charAt(i - 1) - '0' > 0) {
                dp[i] = dp[i - 1];
            }

            if ((s.charAt(i - 2) - '0') > 0) {
                dp[i] = dp[i] + (((s.charAt(i - 2) - '0') * 10) + (s.charAt(i - 1) - '0') <= 26 ? dp[i - 2] : 0);
            }
        }

        return dp[s.length()];

    }

    static int[] dp;

    public static int getTotalDecodingCountTopDownGfg(String s) {

        if(s.length() == 0 || (s.length() == 1 && s.charAt(0) == '0'))
            return 0;

        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return getTotalDecodingCountTopDownGfg(s, s.length());
    }

    public static int getTotalDecodingCountTopDownGfg(String s, int i) {

        if(i == 0 || i == 1)
            return 1;

        if(s.charAt(0) == '0')
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int count = 0;

        if(s.charAt(i-1) - '0' > 0) {
            count = getTotalDecodingCountTopDownGfg(s, i-1);
        }

        if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) -'0' < 7)) {
            count += getTotalDecodingCountTopDownGfg(s, i-2);
        }

        return dp[i] = count;

    }

}
