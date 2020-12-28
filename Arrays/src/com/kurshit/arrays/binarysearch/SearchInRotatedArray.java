package com.kurshit.arrays.binarysearch;

public class SearchInRotatedArray {
	
	public int searchInRotatedArray(int[] arr, int key) {
		
		int pivot = findPivot(arr, 0, arr.length -1);		
		BinarySearch b = new BinarySearch();
		int result = b.searchRecursionUtil(arr, key, 0, pivot);
		
		if(result != -1)
			return result;
		
		return b.searchRecursionUtil(arr, key, pivot + 1, arr.length);
	}
	
	private int findPivot(int[] arr, int low, int high) {
		
		if(low <= high) {
			int mid = (low + high)/2;
			
			if(mid < high && arr[mid] > arr[mid+1]) {
				return mid;
			}
			
			if(mid > low && arr[mid] < arr[mid-1]) {
				return mid - 1;
			}
			
			if(arr[low] >= arr[mid]) {
				return findPivot(arr, low, mid - 1);
			}
			
			return findPivot(arr, mid+1, high);
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		SearchInRotatedArray s = new SearchInRotatedArray();
		int[] arr = {15,20,25,30,5,10};
		
		System.out.println(s.searchInRotatedArray(arr, 5));
		
		
	}

}
