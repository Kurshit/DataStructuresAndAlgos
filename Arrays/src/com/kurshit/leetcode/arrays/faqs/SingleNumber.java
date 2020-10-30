package com.kurshit.leetcode.arrays.faqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 	Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *	All elements would be a
 *
 *	Note:
 *	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *	
 *	Example 1:
 *		
 *		Input: [2,2,1]
 *		
 *		Output: 1
 */

public class SingleNumber {

	public static void main(String[] args) {
		
		int[] nums1 = {4,1,2,1,2};		
		
		System.out.println(findSingleNumberUsingArrayList(nums1));
		System.out.println(findSingleNumberUsingHashMap(nums1));
		System.out.println(findSingleNumberUsingXOR(nums1)); //  best case
		
		System.out.println();
		
		int[] nums2 = {2, 2, 1};
		
		System.out.println(findSingleNumberUsingArrayList(nums2));
		System.out.println(findSingleNumberUsingHashMap(nums2));
		System.out.println(findSingleNumberUsingXOR(nums2)); //  best case
		
		
	}

	/*
	 *  We will use array list to keep first occurent of each number. On encountering the second element,
	 *   we will instead remove the first same element from arraylist. This way, in the last we would be left
	 *   with single number in arraylist.
	 *   
	 *   TC : O(n2) : 
	 *   	The for loop has complexity of O(n). Now within the for loop- 
	 *   	The list.contains() - has TC O(n). Hence, it would take O(n2).
	 *   
	 *   SC : O(n);
	 *   
	 */
	
	public static int findSingleNumberUsingArrayList(int[] nums) {
		
		List<Integer> singleList = new ArrayList<>();
		
		for( int i : nums) {
			if(!singleList.contains(i))
				singleList.add(i);
			else 
				singleList.remove(new Integer(i));
		}
		
		return singleList.get(0);
	}
	
	/*
	 * Hashmap will be used to store element of array as key and occurences as its values.
	 * In the last, we will return the key with its value as 1.
	 * 
	 * TC : O(n)
	 * SC : O(N)
	 * 
	 * 
	 */
	
	public static int findSingleNumberUsingHashMap(int[] nums) {
			
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) == 1)
				return nums[i];
		}
		
		return 0;
	}
	
	/*
	 * Approach 4: Bit Manipulation - XOR - ^
     *
	 *		If we take XOR of zero and some bit, it will return that bit
	 *			a XOR 0 = a
	 *		If we take XOR of two same bits, it will return 0
	 *			a XOR a = 0	 *		
	 *		SO 
	 *			a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
	 *
	 * TC : O(n)
	 * 
	 */
	
	public static int findSingleNumberUsingXOR(int[] nums) {
		int ans = 0;
		
		for(int i = 0; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		
		return ans;
		
	}
}
