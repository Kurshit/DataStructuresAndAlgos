package com.kurshit.arrays.slidingwindow.variable;

public class MinimumLengthSubarraySumGreaterThanK {
	public static void main(String[] args) {
		
		int[] arr = {1, 4, 45, 6, 0, 19};
		int K = 51;
				
		System.out.println(getMinLengthSubarray(arr, K));
		
		int[] arr1 = {1, 10, 5, 2, 7};
		K = 9;
		System.out.println(getMinLengthSubarray(arr1, K));
		
		int[] arr2 = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		K = 280;
		System.out.println(getMinLengthSubarray(arr2, K));
		
		int[] arr3 = {1, 2, 4};
		K = 8;
		System.out.println(getMinLengthSubarray(arr3, K));
		
	}
	
	public static int getMinLengthSubarray(int[] arr, int K) {
		int N = arr.length;
		
		int i=0; 
		int j = 0;
		int smallestSize = Integer.MAX_VALUE;
		int sum = 0;
		//{1, 4, 45, 6, 0, 19};
		while(j < N) {
			
			sum = sum + arr[j];
			
			if(sum <= K) {
				j++;
			} else if(sum > K) {

				while(sum > K && i < N) {
					sum = sum - arr[i];
					if(j - i + 1 < smallestSize) {
						smallestSize = j - i + 1;
					}
					i++;
					
				}
				
				j++;
			}
			
			
		}
		
		return smallestSize;
	}
}
