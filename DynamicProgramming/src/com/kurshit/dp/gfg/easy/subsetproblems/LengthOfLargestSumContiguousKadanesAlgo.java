package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Source : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * Problem : Write an efficient program to print the size of contiguous subarray with max sum a one-dimensional array. 
 * 
 * Solution : Kadane's algo
 * 
 * Solution source: https://www.youtube.com/watch?v=YxuK6A3SvTs&t=282s&ab_channel=TECHDOSE
 * 
 * 
 */

public class LengthOfLargestSumContiguousKadanesAlgo {

	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; 

		//Expected 5
		
		System.out.println(getSizeOfSubarrayWithLargestSum(arr, arr.length));
		
		int[] arr1 = {1, -2, 1, 1, -2, 1};
		//expected - 2
		System.out.println(getSizeOfSubarrayWithLargestSum(arr1, arr1.length));
		
		int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		//expected - 5
		System.out.println(getSizeOfSubarrayWithLargestSum(arr2, arr2.length));
				
	}
	
	public static int getMaxSum(int[] arr, int N) {
		
		if(N == 0)
			return 0;
		
		int meh = 0;    //max ending here
		int msf = Integer.MIN_VALUE;   // max so far
		
		for(int i=0; i < N; i++) {
			meh = meh + arr[i];
			
			if(meh < arr[i]) {
				meh = arr[i];
			}
			
			if(meh > msf) {
				msf = meh;
			}
		}
		
		return msf;
	}
	
	public static int getSizeOfSubarrayWithLargestSum(int[] arr, int N) {
		
		if(N == 0)
			return 0;
		
		int meh = 0;    //max ending here
		int msf = Integer.MIN_VALUE;   // max so far
		int start = 0;
		int end = 0;
		for(int i=0; i < N; i++) {
			meh = meh + arr[i];
			
			if(meh < arr[i]) {
				meh = arr[i];
				start = i;
				end = i;
			}
			
			if(meh > msf) {
				msf = meh;
				end = i;
			}
		}
		
		return end - start + 1;
	}

}
