package com.kurshit.arrays.binarysearch;

public class BinarySearchReverseOrder {

	public static void main(String[] args) {
		BinarySearchReverseOrder b = new BinarySearchReverseOrder();
		
		int key = 15;
		int[] arr = {15, 11, 9, 8, 7, 5, 2};
		System.out.println(b.search(arr, key));

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
				high = mid - 1;
				
			} else {
				low = mid + 1;
			}
		}

		return -1;

	}


}
