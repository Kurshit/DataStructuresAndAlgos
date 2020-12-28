package com.kurshit.arrays.slidingwindow.fixed;

/*
 * Problem Source : https://www.geeksforgeeks.org/find-subarray-least-average/ 
 * Problem : Given an array arr[] of size n and integer k such that k <= n.
 * 
 * 
 */

public class SubArrayWithLeastAverageOfSizeK {
	
	public static void main(String[] args) {
		int[] arr = {3, 7, 90, 20, 10, 50, 40};
		int K = 3;
		
		//expected 3 5
		printSubarrayWithLeastAverage(arr, K);
		
		int[] arr1 = {3, 7, 5, 20, -10, 0, 12};
		K = 2;
		//expected - 4 5
		printSubarrayWithLeastAverage(arr1, K);
		
	}
	
	public static void printSubarrayWithLeastAverage(int[] arr, int K) {
		int N = arr.length;
		
		int i=0;
		int j = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		int minAvg = Integer.MAX_VALUE;
		while(j < N) {
			sum = sum + arr[j];
			
			if(j-i+1 < K) {
				j++;
				
			} else if(j-i+1 == K) {
				
				int avg = sum/3;
				
				if(avg < minAvg) {
					minAvg = avg;
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
