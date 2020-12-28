package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Source : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */

public class SubsetSumExists {
	
	public boolean hasSubsetSumRecursion(int[] nums, int N, int S) {
		
		if(N == 0 && S ==0)
			return true;
		
		if( N == 0)
			return false;
		
		if(S == 0)
			return true;
		
		if(nums[N-1] > S)
			return hasSubsetSumRecursion(nums, N -1, S);
		
		return hasSubsetSumRecursion(nums, N -1 , S - nums[N-1]) || hasSubsetSumRecursion(nums, N -1, S);		
		
	}
	
	
	
	public boolean hasSubsetSumTopDown(int[] nums, int N, int S) {
		
		boolean[][] t = new boolean[N +1][S+1];
		
		for(int i=0; i < S+1; i++)
			t[0][i] = false;
		
		for(int i=0; i < N+1; i++)
			t[i][0] = true;
		
		for(int i=1; i < N+1; i++) {
			for(int j=1; j < S+1; j++) {
				
				if( nums[i-1] <= j) {
					t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[N][S];
	}
	
	public static void main(String[] args) {
		
		//int[] nums = {2, 3, 7, 8, 10};
//		int[] nums = {3,34,4,12,5,2};
//		int N = nums.length;
//		int S = 9;
//		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int N = nums.length;
		int S = 18;
		
		SubsetSumExists s = new SubsetSumExists();
		
		System.out.println(s.hasSubsetSumRecursion(nums, N, S));
		
		System.out.println(s.hasSubsetSumTopDown(nums, N, S));
		

	}

}
