package com.kurshit.arrays.binarysearch;

/*
 * This program returns the Index of minimum elements in an rotated array using binary search
 */

public class MinElementInArray {

	public static void main(String[] args) {

		int[] arr = {2,5,7,8,9,11,15};

		System.out.println(getMin(arr));
		System.out.println(getMinEfficient(arr));
		
		System.out.println();

		int[] arr1 = {8, 9, 11, 15, 2, 5, 7};
		System.out.println(getMin(arr1));
		System.out.println(getMinEfficient(arr1));
		
		System.out.println();
		
		//		/int[] arr2 = {15 , 11, 9, 8, 7, 5, 2};
		int[] arr2 = {5, 7, 8, 9, 11, 15, 2};
		System.out.println(getMin(arr2));
		System.out.println(getMinEfficient(arr2));
		
		System.out.println();
		int[] arr3 = {2, 2, 2, 2, 2, 2, 2};
		System.out.println(getMin(arr3));
		System.out.println(getMinEfficient(arr3));
		
		System.out.println();
		int[] arr4 = {3, 3, 3, 2, 2, 2, 2, 2};
		System.out.println(getMin(arr4));
		System.out.println(getMinEfficient(arr4));

	}

	public static int getMin(int[] arr) {
		return getMin(arr, 0, arr.length-1);
	}
	
	public static int getMinEfficient(int[] arr) {
		return getMinEfficient(arr, 0, arr.length-1);
	}

	public static int getMin(int[] arr, int low, int high) {

		if (high < low)  return arr[0]; 

		// If there is only one element left 
		if (high == low) return arr[low]; 


		while(low <= high) {
			int mid = low + (high - low)/2; /*(low + high)/2;*/

			// Check if element (mid+1) is minimum element. Consider 
			// the cases like {3, 4, 5, 1, 2} 
			if (mid < high && arr[mid] > arr[mid+1]  ) 
				return mid+1; 

			// Check if mid itself is minimum element 
			if (mid > low && arr[mid] < arr[mid - 1]) 
				return mid; 

			// Decide whether we need to go to left half or right half 
			if (arr[high] > arr[mid]) 
				high = mid-1;
			else				
				low = mid + 1;
		}        

		return high;
	}

	/*
	 * The following approach is more efficient for duplicates in array
	 */

	public static int getMinEfficient(int arr[], int low, int high)  
	{  
		while(low < high) 
		{ 
			int mid = low + (high - low) / 2; 
			if (arr[mid] == arr[high]) 
				high--; 

			else if(arr[mid] > arr[high]) 
				low = mid + 1; 
			else
				high = mid; 
		} 
		return high; 
	}  

}
