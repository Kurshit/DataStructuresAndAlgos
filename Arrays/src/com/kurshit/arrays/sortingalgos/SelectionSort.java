package com.kurshit.arrays.sortingalgos;


/*
 * Idea : Starts with 0th index. Making it target Index. Find index of min element in right array. 
 * Once done with inner loop, replace target element with element at minIndex. Now set new target position 
 * as one position ahead of previous.
 * 
 * Code : Since target starts with 0, outer for loop should start with 0 to n-1.Thus in every pass of i, 
 * target location for an  * element would always be a[i]. Declare minIndex =i (resets in every pass of 
 * i) and run j loop from i+1. Inside inner loop, check if current element is smaller that element at minIndex. if yes,
 * change minIndex to j - min element achived so far. 
 * 
 * Out of inner loop, swap a[i] - target position with minIndex element.
 */
 
public class SelectionSort {

	
	public void selectionSort(int[] arr, int n) {
		
		for(int i=0; i < n-1; i++) {
			
			int minIndex = i;
			
			for(int j =i+1; j< n; j++) {
				
				if(arr[j] < arr[minIndex])
					minIndex = j;
				
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp; 
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {15,20,11,8,25,2,9,19};
		
		SelectionSort selection = new SelectionSort();
		
		selection.selectionSort(arr, arr.length);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		

	}

}
