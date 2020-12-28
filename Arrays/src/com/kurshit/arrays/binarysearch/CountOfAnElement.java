package com.kurshit.arrays.binarysearch;

public class CountOfAnElement {

	public static void main(String[] args) {
		
		int key = 7;
		int[] arr = {2, 5, 7, 7, 7, 7, 7, 8, 9, 11, 15};
		
		System.out.println(getCountOfAnElement(arr, key));
		
		key = 30;
		System.out.println(getCountOfAnElement(arr, key));
		key = 5;
		System.out.println(getCountOfAnElement(arr, key));

	}
	
	public static int getCountOfAnElement(int[] arr, int key) {
		
		int count = 0;
		int first = FirstNLastOccurence.first(arr, key);
		
		if(first == -1)
			return 0;
		int last = FirstNLastOccurence.last(arr, key); 
		count = last - first + 1;
		
		return count;
	}

}
