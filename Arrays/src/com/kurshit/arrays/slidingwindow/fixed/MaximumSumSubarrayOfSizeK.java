package com.kurshit.arrays.slidingwindow.fixed;

/*
 * 	Sources: 
 * 
 * 
 */

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
			int[] arr1 = {100, 200, 300, 400};
			System.out.println(getMaxSize(arr1, 4, 2));
			int[] arr2 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
			System.out.println(getMaxSize(arr2, arr2.length, 4));
		
	}
	
	public static int getMaxSize(int[] arr, int N, int K) {
		
		
		int i = 0, j = 0;
		int maxSum = 0;
		int sum = 0;
		if(K > N)
			return -1;
		
		while(j < N) {
			sum = sum + arr[j];
			if(j-i+1 < K) {
				j++;
			} else if(j-i+1 == K) {
				maxSum = Math.max(maxSum,sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
			
		}		
		
		return maxSum;
		
	}

}
