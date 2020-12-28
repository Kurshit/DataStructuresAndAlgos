package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Problem SOurce : https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
 * Problem: Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 * such that the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, 
 * then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 */

public class LongestSumIncreasingSequence {

	public static void main(String[] args) {
		
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(lisTopDown(arr, arr.length));

	}

	public static int lisTopDown(int[] arr, int N) {

		if(N ==0) {
			return 0;
		}

		int[] LIS = new int[N];

		for(int i=0; i < arr.length; i++) {
			LIS[i] = arr[i];
		}

		for(int i =1; i < N; i++) {
			for(int j=0; j < i; j++) {
				if(arr[j] < arr[i] && LIS[i] < LIS[j] + arr[i]) {
					LIS[i] = LIS[j] + arr[i];
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for(int i =0; i < N; i++)
			max = Math.max(max, LIS[i]);
		return max;
	}

}
