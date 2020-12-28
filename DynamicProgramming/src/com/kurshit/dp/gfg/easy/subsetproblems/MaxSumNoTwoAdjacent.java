package com.kurshit.dp.gfg.easy.subsetproblems;

public class MaxSumNoTwoAdjacent {

	public static void main(String[] args) {
		
		int[] arr = {4, 1, 1, 4, 2, 1};
		//Expected - 
		System.out.println(getMaxSumNoTwoAdjacents(arr, arr.length));

	}
	
	public static int getMaxSumNoTwoAdjacents(int[] arr, int N) {
		
		if(N == 0)
			return 0;
		
		int iIt = arr[0]; //includeIt
		int eIt = 0;    //exlude it
		
		for(int i = 1; i < N; i++) {
			int temp = iIt;
			
			iIt = Math.max(iIt, eIt + arr[i]);
			eIt = temp;
		}
		
		return iIt;
	}

}
