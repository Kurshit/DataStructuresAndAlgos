package com.kurshit.arrays.binarysearch;

public class FirstNLastOccurence {

	public static void main(String[] args) {
		
		
		int key = 7;
		int[] arr = {2, 5, 7, 7, 7, 7, 7, 8, 9, 11, 15};
		System.out.println(first(arr, key));
		System.out.println(last(arr, key));
		int[] arr1 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		int key1 = 2;
		System.out.println(first(arr1, key1));
		System.out.println(last(arr1, key1));
		
		key1 = 5;
		System.out.println(first(arr1, key1));
		System.out.println(last(arr1, key1));

	}

	public static int first(int[] arr, int key) {

		int n = arr.length;

		if(n == 0)
			return 0;

		int low = 0;
		int high = n-1;
		int res = -1;
		while(low <= high) {

			int mid = (low  + high) / 2;

			if(arr[mid] == key) {
				res = mid;
				high = mid-1;
				continue;
			}

			if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return res;



	}
	
	public static int last(int[] arr, int key) {

		int n = arr.length;

		if(n == 0)
			return 0;

		int low = 0;
		int high = n-1;
		int res = -1;
		while(low <= high) {

			int mid = (low  + high) / 2;

			if(arr[mid] == key) {
				res = mid;
				low = mid+1;
				continue;
			}

			if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return res;



	}
}
