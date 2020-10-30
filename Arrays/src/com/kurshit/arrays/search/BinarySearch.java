package com.kurshit.arrays.search;

public class BinarySearch {
	
	public int searchRecursion(int[] a, int key) {
		
		return searchRecursionUtil(a,key,0,a.length - 1);
		
	}	
	public int searchRecursionUtil(int[] arr, int key, int low, int high) {
		
		if(low <= high) {
			
			int mid = (low + high) / 2;
			
			if(arr[mid] == key)
				return mid;
			
			if(key < arr[mid])
				return searchRecursionUtil(arr, key, low, mid -1);
			else
				return searchRecursionUtil(arr, key, mid + 1, high);
			
		}
		
		return -1;
	}
	
	public int search(int[] arr, int key) {
		
		int n = arr.length;
		
		if(n == 0)
			return 0;
		
		int low = 0;
		int high = n-1;
		
		while(low <= high) {
			
			int mid = (low  + high) / 2;
			
			if(arr[mid] == key)
				return mid;
			
			if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
		
	}


	public static void main(String[] args) {
			
		BinarySearch b = new BinarySearch();
		
		int key = 15;
		int[] arr = {2,5,7,8,9,11,15};
		System.out.println(b.searchRecursion(arr, key));
		System.out.println(b.search(arr, key));

	}

}
