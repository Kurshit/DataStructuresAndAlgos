package com.kurshit.leetcode.arrays.faqs;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once 
 * and return the new length. *
 * Do not allocate extra space for another array, you must do this by modifying the input 
 * array in-place with O(1) extra memory.
 * 
 * Link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		
		int[] nums1 = {10,20,20,30,30,30};		
		
		System.out.println("Test Case 1 :\n" );
		testCases(nums1);
		
		int[] nums2 = {10,10,10,10};
		
		System.out.println("\n\nTest Case 2 :\n " );
		testCases(nums2);
		
		int[] nums3 = {10,10,20,20,20,20,30};
		
		System.out.println("\n\nTest Case 3 :\n " );
		testCases(nums3);
		
		int[] nums4 = {10,20,30,40};
		
		System.out.println("\n\nTest Case 4 :\n " );
		testCases(nums4);
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;

		if(n == 0 || n == 1)
			return n;

		int curr = 0;

		for(int i =0; i < n-1; i++) {

			if(nums[i] != nums[i+1]) {
				nums[curr] = nums[i];
				curr = curr + 1;
			}
		}

		nums[curr] = nums[n-1];

		return curr + 1;
	}
	
	public static int removeDuplicatesUsingContinue(int[] nums) {
		
		int n = nums.length;
		
		if( n ==0  || n ==1)
			return n;
		
		int curr = 0;
		
		for(int i =0; i< n; i++) {
			
			if(nums[curr] == nums[i]) 
				continue;
			else {
				curr++;
				nums[curr] = nums[i];
			}
		}
		
		return curr + 1;
	}
		
	public static void testCases(int[] nums) {
		
		int[] nums1 = nums.clone();
		int[] nums2 = nums.clone();
				
		int newLength = removeDuplicates(nums1);
		
		/* 
		 * 1. Using two pointer with i and i+1 comparison.
		 */
		
		System.out.println("\n1. Using two pointer approach with i and i+1 comparison : \n");
		for(int i = 0; i < newLength; i++) {
			System.out.print(nums1[i] + " ");
		}
		
		System.out.println();
		
		/*
		 *  2. Using Continue and Equality of curr and i. If equal, skip the iteration with continue. 
		 *  If not, assign arr[curr] with arr[i]
		 */
		
		System.out.println("\n2. Using two pointer approach with continue and equality of curr and i : \n");
				
		newLength = removeDuplicatesUsingContinue(nums2);
				 
		for(int i = 0; i < newLength; i++) {
			System.out.print(nums2[i] + " ");
		}
		
		System.out.println();
		
	}

}
