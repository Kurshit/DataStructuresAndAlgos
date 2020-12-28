package com.kurshit.arrays.optimization.profit;

/*
 * Source : https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * Problem : Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element 
 * appears after the smaller number.
 * 
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * Output : 8
 * Explanation : The maximum difference is between 10 and 2.

 * Input : arr = {7, 9, 5, 6, 3, 2}
 * Output : 2
 * Explanation : The maximum difference is between 9 and 7.
 * 
 * Question : WHat if array is in descending order : 
 * 
 * Ex: {10, 8, 5, 5, 2}
 * Output : 0
 */

/*
 * This problem is a base for other problems prsent in same package - Max profit by buying and selling stocks
 */

public class MaxDiffOfTwoLargerOneAfterSmaller {

	public static void main(String[] args) {
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		int N = arr.length;
		
		//expected output : 8
		System.out.println(getMaxProfitBruteForce(arr, N));
		System.out.println(getMaxProfitWithMinAndLtoR(arr, N));
		System.out.println(getMaxProfitWithMaxAndRtoL(arr, N));
		
		System.out.println();
		
		int[] arr1 = {7, 9, 5, 6, 3, 2};
		N = arr1.length;
		
		//expected output : 2
		System.out.println(getMaxProfitBruteForce(arr1, N));
		System.out.println(getMaxProfitWithMinAndLtoR(arr1, N));
		System.out.println(getMaxProfitWithMaxAndRtoL(arr1, N));
	}

	/*
	 * Approach 1 : Brute force - O(n2)
	 * Use two loops. In the outer loop, pick elements one by one and in the inner loop calculate the difference of the 
	 * picked element with every other element in the array and compare the difference with the maximum difference calculated so far. 
	 * 
	 * Below is the implementation of the above approach :
	 */

	public static int getMaxProfitBruteForce(int[] arr, int N) {
		int maxProfit = 0;

		for(int i=0; i < N; i++) {
			for(int j=i+1; j < N; j++) {

				if(arr[j] > arr[i]) {

					int diff = arr[j] - arr[i];
					maxProfit = Math.max(maxProfit, diff);
				}
			}
		}

		return maxProfit;
	}

	/*
	 * Approach 2 : Min element and LtoR - O(n)
	 * 
	 *  Chosing min element at as we go from L to R in array and keeping the diff or every arr[i] with min in maxSoFar.
	 *  
	 */
	
	public static int getMaxProfitWithMinAndLtoR(int[] arr, int N) {
		
		int maxSoFar = 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int i =0; i < N; i++) {
			
			if(arr[i] < min) {
				min = arr[i];
			}
			
			maxSoFar = Math.max(maxSoFar, arr[i] - min);
		}
		
		
		return maxSoFar;
		
	}
	
	public static int getMaxProfitWithMaxAndRtoL(int[] arr, int N) {
		
		int maxProfit = 0;
		
		int max = Integer.MIN_VALUE;
		
		for(int i = N-1 ; i >=0; i--) {
			
			if(arr[i] > max) {
				max = arr[i];
			}
			
			maxProfit = Math.max(maxProfit, max - arr[i]);
		}
		
		
		return maxProfit;
		
	}
	
	
	
}
