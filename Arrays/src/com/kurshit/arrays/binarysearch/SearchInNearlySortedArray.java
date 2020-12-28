package com.kurshit.arrays.binarysearch;

/*
 * Problem Source : https://www.geeksforgeeks.org/search-almost-sorted-array/
 * 
 * Problem : Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

	For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

	Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
	Output: 2 
	Output is index of 40 in given array

	Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
	Output: -1
	-1 is returned to indicate element is not present

 *
 */

public class SearchInNearlySortedArray {

	public static void main(String[] args) {
		
		int[] arr =  {10, 3, 40, 20, 50, 80, 70}; 
		int key = 40;
		System.out.println(search(arr, key));
		key = 70;
		System.out.println(search(arr, key));
	}

	public static int search(int[] arr, int key) {
		return binarySearch(arr, 0, arr.length - 1, key);
	}

	public static int binarySearch(int arr[], int low, int high, int key) 
	{ 
		while(low <= high) 
		{ 
			int mid = low + (high - low) / 2; 

			// If the element is present at  
			// one of the middle 3 positions 
			if (arr[mid] == key)  
				return mid; 
			if (mid > low && arr[mid - 1] == key) 
				return (mid - 1); 
			if (mid < high && arr[mid + 1] == key) 
				return (mid + 1); 

			// If element is smaller than mid, then 
			// it can only be present in left subarray 
			if (arr[mid] > key)  
				high = mid-2;
			else	 
				low = mid + 2;
			 
		} 

		// We reach here when element is  
		// not present in array 
		return -1; 
	} 



}
