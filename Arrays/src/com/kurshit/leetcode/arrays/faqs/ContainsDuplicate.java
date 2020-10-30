package com.kurshit.leetcode.arrays.faqs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 	Given an array of integers, find if the array contains any duplicates.
 * 
 *	Your function should return true if any value appears at least twice in the array, 
 * 	Given an array of integers, find if the array contains any duplicates.
 *  
 *  Link : https://leetcode.com/articles/contains-duplicate/
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		
		int[] nums1 = {1, 2, 3, 4, 1};
		
		System.out.println(containsDuplicateUsingSet(nums1));
		System.out.println(containsDuplicateUsingSet(nums1));
		
		System.out.println();
		
		int[] nums2 = {1, 10, -1, 5, 15, -5};
		System.out.println(containsDuplicateUsingSet(nums2));
		System.out.println(containsDuplicateUsingSet(nums2));
		
		System.out.println();
		
		int[] nums3 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(containsDuplicateUsingSet(nums3));
		System.out.println(containsDuplicateUsingSet(nums3));
		
		System.out.println();
		
		int[] nums4 = {1};
		System.out.println(containsDuplicateUsingSet(nums4));
		System.out.println(containsDuplicateUsingSet(nums4));
		
		

	}
	
	/*
	 * 1. Using HashSet - an extra space - to keep unique elements 
	 * 
	 * TC : O(n)
	 * 
	 * SC : O(n)
	 * 
	 */
	
	public static boolean containsDuplicateUsingSet(int[] nums) {
		
		Set<Integer>  set = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {

			if(!set.add(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		
		return false;		
				
	}
	
	/*
	 * 2. By sorting the array first and then checking adjacent elements
	 * 
	 * TC : O(nlogn) 
	 */
	
	public static boolean containsDuplicateBySortingArray(int[] nums) {
		
		Arrays.sort(nums);
		
		for(int i=0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i+1])
				return true;
		}
		
		return false;
	}

}
