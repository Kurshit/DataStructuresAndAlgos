package com.kurshit.arrays.binarysearch;

/*
 * Problem Source : https://www.geeksforgeeks.org/floor-in-a-sorted-array/
 * Problem : Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. 
 * Write efficient functions to find index of floor of x.
 * 
 *  Example : 
 *  	arr = {1, 2, 8, 10, 10, 12, 19};
 *  	key = 5;
 *  
 *  Output: 2 
 *  
 */

public class FloorOfAnElement {

	public static void main(String[] args) {
		int[] arr = {1, 2, 8, 10, 10, 12, 19};
		int key = 5;
		System.out.println(getFloor(arr, key));
		key = 20;
		System.out.println(getFloor(arr, key));
		key = 10;
		System.out.println(getFloor(arr, key));
		
		int[] arr1 = {10, 12, 19};
		key = 9;
		System.out.println(getFloor(arr1, key));
		

	}

	public static int getFloor(int[] arr, int key) {
		return getFloor(arr, 0, arr.length - 1, key);
	}

	public static int getFloor(int arr[], int low, int high, int key) 
	{ 

		while(low <= high) {

			// If last element is smaller than x 
			if (key >= arr[high]) 
				return high; 

			// Find the middle point 
			int mid = (low + high) / 2; 

			// If middle point is floor. 
			if (arr[mid] == key) 
				return mid; 

			// If key lies between mid-1 and mid 
			if (mid > 0 && arr[mid - 1] <= key && key < arr[mid]) 
				return mid - 1; 

			// If key is smaller than mid, floor 
			// must be in left half. 
			if (key < arr[mid])  
				high = mid - 1;
			else 	
				low = mid + 1;

		}
		
		return -1;
	}

}
