package com.kurshit.dp.gfg.easy;


public class KnapSack {
	
	/*
	 * Approach/Step 1 : Recursion solution
	 */
	
	public int getMaxProfitRecursion(int[] wt, int[] val, int N, int W) {
		
		if(N ==0 || W ==0 ) {
			return 0;			
		}
		
		if(wt[N-1] > W) {
			return getMaxProfitRecursion(wt, val, N - 1, W);
		}
		
		return Math.max(val[N-1] + getMaxProfitRecursion(wt, val, N - 1, W - wt[N-1]), 
				getMaxProfitRecursion(wt, val, N - 1, W));		
		
	}
	
	/*
	 * Since there are certain recurssive functions that are being computed again and again for same set of
	 * values, we will store the values which are computed and would utilize it
	 */
	
	int t1[][];
	
	public int getMaxProfitMemoization(int[] wt, int[] val, int N, int W) {
		
		if(N == 0 || W ==0)
			return 0;
		
		if(t1[N][W] != -1)
			return t1[N][W];
		
		if(wt[N-1] > W) {
			return t1[N][W] = getMaxProfitRecursion(wt, val, N - 1, W);
		}
		
		return t1[N][W] = Math.max(val[N-1] + getMaxProfitRecursion(wt, val, N - 1, W - wt[N-1]), 
				getMaxProfitRecursion(wt, val, N - 1, W));
	}
	
	int t2[][];
	
	public int getMaxProfitTopDown(int[] wt, int[] val, int N, int W) {
		
		for(int i=1; i < N+1; i++) {
			for(int j=1; j < W+1; j++) {
				
				if( wt[i-1] <= j) {
					t2[i][j] = Math.max(val[i-1] + t2[i-1][j-wt[i-1]], t2[i-1][j]);
				} else {
					t2[i][j] = t2[i-1][j];
				}
			}
		}
		
		return t2[N][W];
	}
	
	
	public static void main(String[] args) {
		
		KnapSack knapsack = new KnapSack();

		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int N = wt.length;
		int W = 7;
		
		System.out.println("Max profit using recursion is : " + knapsack.getMaxProfitRecursion(wt, val, N, W));
		
		knapsack.t1 = new int[N+1][W+1];
		initializeMatrix(knapsack.t1, N+1, W+1, -1);
		System.out.println("Max profit using memoization is : " + knapsack.getMaxProfitMemoization(wt, val, N, W));
		
		knapsack.t2 = new int[N+1][W+1];
		
		System.out.println("Max profit using Top-Down approach is : " + knapsack.getMaxProfitTopDown(wt, val, N, W));
	}
	
	public static void initializeMatrix(int[][] mat, int M, int N, int value) {
		for(int i =0; i < M; i++)
			for(int j=0; j <N; j++)
				mat[i][j] = -1;
	}

}
