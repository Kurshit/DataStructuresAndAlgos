package com.kurshit.dp.subsetsumprobs;

import java.util.HashMap;
import java.util.Map;

/*
 * 	Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 * 
 * Output: 
 * 		A = [4,5,0,-2,-3,1], K = 5
 *		Output: 7
 *
 *		Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * 				[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * Source: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */

public class SubArraySumDivisibleByK {

	public static void main(String[] args) {
		
		SubArraySumDivisibleByK s = new SubArraySumDivisibleByK();
		int[] arr = {4, 5, 0, -2, -3, 1};
		int N = 6;
		int K = 5;
		System.out.println(s.subArraySymDivisibleByK(arr, N, K));
	}
	
	public int subArraySymDivisibleByK(int[] arr, int N, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int runningSum = 0;
		int count = 0;
		for(int i=0; i < N; i++) {
			runningSum += arr[i];
			int remainder = runningSum % K;
			
			if(remainder < 0)
				remainder = remainder + K;
			
			if(map.containsKey(remainder)) {
				count = count + map.get(remainder);
			}
			
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}
		return count;
	}
	
	

}
