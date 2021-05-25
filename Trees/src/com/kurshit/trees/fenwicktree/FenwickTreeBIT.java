package com.kurshit.trees.fenwicktree;

/*
 * This is the implementation of fenwick tree - Binary Indexed Tree.
 * 
 * Source : https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * 	
 * 
 */

public class FenwickTreeBIT {
	
	public int getSum(int[] BIT, int idx) {
		int sum =0;
		
		idx = idx +1;
		
		while(idx > 0) {
			sum = sum + BIT[idx];
			idx = idx - (idx & (-idx));
		}
		
		return sum;
	}
	
	/*
	 * arr - is input array of size N
	 */
		
	public int[] createBIT(int[] arr, int N) {
		
		int[] BIT = new int[N+1];
		
		for(int i=0; i < N; i++) {
			updateBIT(BIT, N, i, arr[i]);
		}
		
		return BIT;
	}
	
	/*
	 * This update function does NOT directly replaces the new value. But adds this value to exisiting index and recomputes the presum.
	 * This is basically addValue()
	 */
	public void updateBIT(int[] BIT, int N, int idx, int value) {
		
		idx = idx +1;
		
		while(idx <= N) {
			BIT[idx] = BIT[idx] + value;
			idx = idx + (idx & (-idx));
		}
		
	}

}
