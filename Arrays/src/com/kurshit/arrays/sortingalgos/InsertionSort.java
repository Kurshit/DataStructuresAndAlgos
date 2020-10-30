package com.kurshit.arrays.sortingalgos;

public class InsertionSort {
	
	/*
	 * Idea is to scan from left to right, pick each element, and place it in sorting order in left subarray.
	 * We will have two subarrays. Left one subarray would be sorted. Right would be unsorted.  
	 * When we pick element from unsorted array and insert in sorted array, elements would be shifted towards right.
	 * 
	 */
	
	public void insertionSort(int[] arr, int n) {
		
		for(int i = 1; i < n; i++) {
			
			int j = i-1;
			
			int key = arr[i];
			
			
			while(j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			
			arr[j+1] = key;
		}
		
	}
	
	public static void main(String[] args) {
		
		InsertionSort sort = new InsertionSort();
		
		int[] arr = {15,20,11,8,25,2,9,19};
		
		sort.insertionSort(arr, arr.length);

	}

}
