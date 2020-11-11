package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Problem Statement : Given an array, check if it can be divided into two sub-set so that sum of these two sub-sets be equal.
 * 
 *  The partitioned sub sets can be of different size
 *  
 *  Ex: 
 *  	Input: int[] arr = [1, 5, 11, 5]
 *  
 *  	Output : true
 *  
 *  	{1,5,5} {11} ==> 11 = 11
 * 
 * 
 */

/*
 * Solution: Let sum of two partitions P1 and P2 be S1 and S2. 
 * 
 * 	P1 ==> S1	& P2 ==> S2.
 * 
 * 	Now we know, S1 and S1 should be same, S1 = S2 = S. 
 * 
 *	i.e S1 + S2 = 2S. 
 *
 *	i.e total Array Sum = 2S.
 *	
 *TO get above eeuation, the sum of all elements on an array has to be EVEN
 *
 * We can solve this by using Subset Sum Problem. - We can obtain sum of all elements of array and pass sum/2 to SSP to see if such subsets 
 * exists.
 */

public class EqualSumPartition {
	
	/*
	 * Approach 1 : Using SSP
	 */
	
	private SubsetSumExists ssp = new SubsetSumExists();
	
	public boolean hasEqualSumPartitionTopDown(int[] nums, int N) {
		
		int sum = 0;
		
		for(int i=0; i < N; i++)
			sum = sum + nums[i];
		
		if( sum % 2 != 0)
			return false;
		else 
			return ssp.hasSubsetSumTopDown(nums, N, sum/2);		
	}
	
	public static void main(String[] args) {
		
		EqualSumPartition esp = new EqualSumPartition();
		int[] nums1 = {1, 5, 11, 5 };
		int N = nums1.length;
		
		System.out.println(esp.hasEqualSumPartitionTopDown(nums1, N));
		
		int[] nums2 = {1, 5, 11, 4};
		N = nums2.length;
		
		System.out.println(esp.hasEqualSumPartitionTopDown(nums2, N));
		
	}

}
