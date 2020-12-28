package com.kurshit.arrays.binarysearch;

public class OrderNotKnownBS {

	public static void main(String[] args) {
		
		int key = 15;
		int[] arr = {2,5,7,8,9,11,15};
		System.out.println(search(arr, key));
		int key1 = 15;
		int[] arr1 = {15, 11, 9, 8, 7, 5, 2};
		System.out.println(search(arr1, key1));

	}

	public static int search(int[] arr, int key) {

		int n = arr.length;

		if(n == 0)
			return 0;
		
		boolean isAsc = true;
		
		if(arr.length == 1 ) {
			if(arr[0] == key) {
				return 0;
			} else 
				return -1;
			
		} 
		
		if(arr[0] > arr[1])
			isAsc = false;

		int low = 0;
		int high = n-1;

		while(low <= high) {

			int mid = (low  + high) / 2;

			if(arr[mid] == key)
				return mid;

			if(key > arr[mid]) {
				if(isAsc) 
					low = mid + 1;
				else 
					high = mid - 1;
				
			} else {
				if(isAsc)
					high = mid - 1;
				else 
					low = mid + 1;
			}
		}

		return -1;

	}
}
