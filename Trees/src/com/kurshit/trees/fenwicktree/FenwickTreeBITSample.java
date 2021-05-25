package com.kurshit.trees.fenwicktree;

public class FenwickTreeBITSample {

	public static void main(String[] args) {
		int arr[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9}; 
		
		int N = arr.length; 
		
		FenwickTreeBIT bit = new FenwickTreeBIT();
		
		int[] BIT = bit.createBIT(arr, N);
		
		
		//this returns commulative sum from 0th index
		System.out.println(bit.getSum(BIT, 5));
		
		//add this value to value at index 3
		arr[3] = arr[3] + 6;
		
		//the actual value replaced at index 3 will be 9 ->> 3 + 6. Recomputes the sum for dependent elements
		bit.updateBIT(BIT, N, 3, 6);
		
		//expected - 18
		//new array - {2, 1, 1, 9, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(bit.getSum(BIT, 5));
		
		
		//TO print the sum between some range - 
		
		int startIdx = 3;
		int endIdx = 7;
		
		//new array - {2, 1, 1, 9, 2, 3, 4, 5, 6, 7, 8, 9}
		//expected - 23 -> 9 + 2 + 3 + 4 + 5
		
		System.out.println(bit.getSum(BIT, endIdx) - bit.getSum(BIT, startIdx - 1));
		
		
	}

}
