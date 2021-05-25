package com.kurshit.trees.fenwicktree.problems;

import com.kurshit.trees.fenwicktree.FenwickTreeBIT;

/*
 * The updateBIT in FenwickTreeBIT adds the value to current element at that index in array and finds corresponding sum int BIT array.
 * 
 * The following program shows an approach to replace the existing value with new one rather than adding it.
 * 
 */

public class UpdateValuesFindSumQueries {

	public static void main(String[] args) {
		
		int arr[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9}; 
		
		int N = arr.length;
		
		FenwickTreeBIT bit = new FenwickTreeBIT();
		
		int[] BIT = bit.createBIT(arr, N);
						
		//this returns commulative sum from 0th index
		//Expected - 12
		System.out.println(bit.getSum(BIT, 5));
		int newValue = 6;
				
		bit.updateBIT(BIT, N, 3, newValue - arr[3]);
		
		arr[3] = newValue;
		//expected - 15
		System.out.println(bit.getSum(BIT, 5));
		
		newValue = 1; // replace 3 with 1 at index 5
		bit.updateBIT(BIT, N, 5, newValue - arr[5]);
		arr[5] = newValue;
		
		//Expected - 13
		System.out.println(bit.getSum(BIT, 5));
		
	}
	
	
	
	

}
