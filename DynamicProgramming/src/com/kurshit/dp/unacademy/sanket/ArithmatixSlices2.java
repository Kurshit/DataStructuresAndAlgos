package com.kurshit.dp.unacademy.sanket;

/*
    Problem source : https://unacademy.com/class/problem-solving-on-dynamic-programming-3/3NIL4F4C
    Leetcode #446 - https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
    Solution Source : https://unacademy.com/class/problem-solving-on-dynamic-programming-3/3NIL4F4C

    Statement :

    Given an integer array nums, return the number of all the arithmetic subsequences of nums.

    A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
    For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
    A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

    For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
    The test cases are generated so that the answer fits in 32-bit integer.

        Example 1:

        Input: nums = [2,4,6,8,10]
        Output: 7
        Explanation: All arithmetic subsequence slices are:
        [2,4,6]
        [4,6,8]
        [6,8,10]
        [2,4,6,8]
        [4,6,8,10]
        [2,4,6,8,10]
        [2,6,10]
        Example 2:

        Input: nums = [7,7,7,7,7]
        Output: 16
        Explanation: Any subsequence of this array is arithmetic.


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmatixSlices2 {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        System.out.println(numberOfArithmeticSlices(arr));

    }

    public static int numberOfArithmeticSlices(int[] arr) {
         int N = arr.length;

         if(N == 1)
             return 0;

         Map<Long, Long>[] dp = new HashMap[N];

         for(int i = 0 ; i < N; i++) {
             dp[i] = new HashMap<>();
         }

         long ans = 0;
         for(int i = 1; i< N; i++) {
             for(int j = 0; j < i; j++) {
                 long diff = (long) arr[i] - (long)arr[j];
                 long count = dp[j].getOrDefault(diff, 0l);
                 dp[i].put(diff, dp[i].getOrDefault(diff, 0l) + count + 1);
                 ans = (int) (ans + count);
             }
         }

         return (int)ans;

    }


}
