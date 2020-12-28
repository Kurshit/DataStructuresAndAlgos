package com.kurshit.arrays.binarysearch;

public class SearchInRotatedArrayUsingGetMinIndex {
	
	public int searchInRotatedArray(int[] arr, int key) {
		
		int pivot = MinElementInArray.getMin(arr);		
		BinarySearch b = new BinarySearch();
		int result = b.searchRecursionUtil(arr, key, 0, pivot-1);
		
		if(result != -1)
			return result;
		
		return b.searchRecursionUtil(arr, key, pivot, arr.length - 1);
	}	
	
	public static void main(String[] args) {
		
		SearchInRotatedArrayUsingGetMinIndex s = new SearchInRotatedArrayUsingGetMinIndex();
		int[] arr = {15,20,25,30,5,10};
		
		System.out.println(s.searchInRotatedArray(arr, 5));
		
		int[] arr1 = {15,20,25,30,5,10};
		
		System.out.println(s.searchInRotatedArray(arr1, 20));
		
		int[] arr2 = {15,20,25,30,5,10};
		
		System.out.println(s.searchInRotatedArray(arr2, 40));
		
		
	}

}
