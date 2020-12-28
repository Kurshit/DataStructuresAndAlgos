package com.kurshit.arrays.slidingwindow.fixed;

/*
 * Problem Source : https://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/ 
 * Problem : Given an array arr[] of size n and integer k such that k <= n. 
 * 
 */

public class SubArrayWIthMaximumAverageOfSizeK {
	
	public static void main(String[] args) {
		int[] arr = {1, 12, -5, -6, 50, 3};
		int K = 4;
		
		//expected 1 4
		printSubarrayWithMaximumAverage(arr, K);
		
		int[] arr1 = {3, 7, 5, 20, -10, 0, 12};
		K = 2;
		//expected - 2 3
		printSubarrayWithMaximumAverage(arr1, K);
		
	}
	
	public static void printSubarrayWithMaximumAverage(int[] arr, int K) {
		int N = arr.length;
		
		int i=0;
		int j = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		int maxAvg = Integer.MIN_VALUE;
		while(j < N) {
			sum = sum + arr[j];
			
			if(j-i+1 < K) {
				j++;
				
			} else if(j-i+1 == K) {
				
				int avg = sum/3;
				
				if(avg > maxAvg) {
					maxAvg = avg;
					start = i;
					end = j;
				}
				sum = sum - arr[i];		
				i++;
				j++;
			}
		}
		
		System.out.println(start + " " + end);
	}
}
