package com.kurshit.arrays.optimization.profit;

/* Problem Source : https://www.geeksforgeeks.org/stock-buy-sell/
 * 
 * Problem : The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in 
 * those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying 
 * on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, 
 * then profit cannot be earned at all.
 * 
 * Solution : Peak valley approach : https://www.youtube.com/watch?v=K8iHi8AW1ls&ab_channel=TECHDOSE
 * 
 * Note : This is same as "BuyAndSellStocksTwice" but here we can make any number of transactions to earn max profit
 */

public class BuyAndSellStocksAnyNumberOfTimes {

	public static void main(String[] args) {
		int[] arr = { 100, 180, 260, 310, 40, 535, 695 };
		//expected - 856
		System.out.println(getMxProfit(arr));
		
		//expected - 5
		int[] arr1 = {7,1,5,3,6,4};
		System.out.println(getMxProfit(arr1));
		
		int[] arr2 = {7,6,4,3,1};
		System.out.println(getMxProfit(arr2));
	}
	
	/*
	 * Solution : Buy stock when prices are lower (Valley) and sell when its at peak.
	 * 
	 * We start from 1st index and compare current i with previous. So, if curr i value is greater than prev ith value, we 
	 * add tha diff of i and (i-1) to profit.
	 */
	
	public static int getMxProfit(int[] arr) {
		
		int max = 0;
		
		for(int i=1; i < arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				max = max + arr[i] - arr[i-1];
			}
		}
		
		return max;
	}

}
