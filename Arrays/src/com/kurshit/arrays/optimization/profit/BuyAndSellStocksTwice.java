package com.kurshit.arrays.optimization.profit;

/*
 * Source: https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * Problem : In a daily share trading, a buyer buys shares in the morning and sells it on the same day. 
 * 
 * If the trader is allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first 
 * one is complete (Sell->buy->sell->buy). Given stock prices throughout the day, find out the maximum profit that a share trader 
 * could have made.
 * 
 * Input:   price[] = {10, 22, 5, 75, 65, 80}
	Output:  87
 *	Trader earns 87 as sum of 12 and 75
 *	Buy at price 10, sell at 22, buy at 5 and sell at 80

	Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
 *	Output:  100
	Trader earns 100 as sum of 28 and 72
 *	Buy at price 2, sell at 30, buy at 8 and sell at 80

 * 
 */

/*
 * Note : This is with at most two transactions allowed
 */

public class BuyAndSellStocksTwice {

	public static void main(String[] args) {
		int[] arr = {10, 22, 5, 75, 65, 80};
		int N = arr.length;
		
		//expected - 87
		System.out.println(getMaxProfit(arr, N));
		
		System.out.println();
		
		
		//In following example, only one transaction is needed to make max profit
		int[] arr1 = {15, 25, 4, 2};
		N = arr1.length;
		
		//expected - 10
				
		System.out.println(getMaxProfit(arr1, N));
		
		//0 transactions will happen in this case
		
		int[] arr2 = {35, 25, 4, 2};
		N = arr2.length;
		
		//expected - 0				
		System.out.println(getMaxProfit(arr2, N));
		
		

	}

	public static int getMaxProfit(int[] arr, int N) {
		int maxProfit = 0;

		int[] profit = new int[N];

		//First from right to left

		int maxRtoL = arr[N-1];

		for(int i = N-2; i >=0; i--) {

			if(arr[i] > maxRtoL) 
				maxRtoL = arr[i];

			profit[i] = Math.max(profit[i+1], maxRtoL - arr[i]);
		}

		int minLtoR = arr[0];

		for(int i=1; i < N; i++) {
			if(arr[i] < minLtoR) {
				minLtoR = arr[i];
			}

			profit[i] = Math.max(profit[i-1], profit[i] + (arr[i] - minLtoR));
			
		}
		maxProfit = profit[N-1];
		return maxProfit;


	}

}
