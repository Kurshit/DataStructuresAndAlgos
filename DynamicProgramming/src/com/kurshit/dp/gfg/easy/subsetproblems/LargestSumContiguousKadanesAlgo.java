package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Source : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * Problem : Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of 
 * numbers which has the largest sum.
 * 
 * Solution : Kadane's algo
 * 
 * Solution source: https://www.youtube.com/watch?v=YxuK6A3SvTs&t=282s&ab_channel=TECHDOSE
 * 
 * 
 */

public class LargestSumContiguousKadanesAlgo {

	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		//Expected 7
		System.out.println(getMaxSum(arr, arr.length));
		printStartAndEndIndexes(arr, arr.length);
		
		
				
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
	
	public static void printStartAndEndIndexes(int[] arr, int N) {
		
		if(N == 0)
			return;
		
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
		
		System.out.println("Start index is : " + start + " End index is : " + end);
	}

}
