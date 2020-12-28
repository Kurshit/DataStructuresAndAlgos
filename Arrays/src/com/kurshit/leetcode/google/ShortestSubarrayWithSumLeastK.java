package com.kurshit.leetcode.google;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Source : https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * Problem: 
 * 
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 */

public class ShortestSubarrayWithSumLeastK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

}
