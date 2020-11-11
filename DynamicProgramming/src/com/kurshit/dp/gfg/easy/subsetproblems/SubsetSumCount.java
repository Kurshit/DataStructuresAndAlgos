package com.kurshit.dp.gfg.easy.subsetproblems;

public class SubsetSumCount {
	
	public int getCountOfSubsetSumRecursion(int[] nums, int N, int S) {
		
		if(N == 0 && S ==0)
			return 1;
		
		if( N == 0)
			return 0;
		
		if(S == 0)
			return 1;
		
		if(nums[N-1] > S)
			return getCountOfSubsetSumRecursion(nums, N -1, S);
		
		return getCountOfSubsetSumRecursion(nums, N -1 , S - nums[N-1]) + getCountOfSubsetSumRecursion(nums, N -1, S);		
		
	}
	
	
	
	public int getCountOfSubsetSumTopDown(int[] nums, int N, int S) {
		
		int[][] t = new int[N +1][S+1];
		
		for(int i=0; i < S+1; i++)
			t[0][i] = 0;
		
		for(int i=0; i < N+1; i++)
			t[i][0] = 1;
		
		for(int i=1; i < N+1; i++) {
			for(int j=1; j < S+1; j++) {
				
				if( nums[i-1] <= j) {
					t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[N][S];
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2, 3, 7, 8, 10};
		int N = nums.length;
		int S = 11;
		
		SubsetSumCount s = new SubsetSumCount();
		
		System.out.println(s.getCountOfSubsetSumRecursion(nums, N, S));
		
		System.out.println(s.getCountOfSubsetSumTopDown(nums, N, S));
		
		int[] nums1 = {2, 3, 5, 6, 8, 10};
		N = nums1.length;
		S = 10;
		
		System.out.println(s.getCountOfSubsetSumRecursion(nums1, N, S));
		
		System.out.println(s.getCountOfSubsetSumTopDown(nums1, N, S));
		

	}

}
