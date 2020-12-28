package com.kurshit.arrays.binarysearch.median;

import java.util.Arrays;

public class MedianInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 4, 2, 6, 5, 8, 7};
		
		System.out.println(findMedian(arr, arr.length));
	}

	public static double findMedian(int a[], int n) {
		// First we sort the array
		Arrays.sort(a);

		// check for even case
		if (n % 2 != 0)
			return (double)a[n / 2];

		return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
	}
}
