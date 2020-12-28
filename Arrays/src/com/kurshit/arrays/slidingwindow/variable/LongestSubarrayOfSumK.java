package com.kurshit.arrays.slidingwindow.variable;

import java.util.HashMap;

/*
 * Problem : Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
 * 
 * SOlution approaches Ref : 
 * 
 * 1. By Aditya Verma - https://www.youtube.com/watch?v=TfQPoaRDeMQ&ab_channel=AdityaVerma
 * 
 *  Drawback : This works for positive integers only
 *  
 *  2. By a Video - https://www.youtube.com/watch?v=HbbYPQc-Oo4&ab_channel=TECHDOSE 
 *  https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 * 
 */



 public class LongestSubarrayOfSumK {

	public static void main(String[] args) {
		
		//int[] arr = {4, 1, 1, 1, 2, 3, 5};
		int[] arr = {1, 1, 1, 2, 1, 4, 3, 5};
		int K = 5;
		
		//expected - 4
		System.out.println(getLongestSubaaray(arr, K));
		System.out.println(getLongestSubarrayUsingMap(arr, K));
		
		System.out.println();
		
		//expected 
		int[] arr2 = {3, 4, 7, 2, -3, 1, 4, 2};
		K = 7;
		
		//expected - 4
		System.out.println(getLongestSubaaray(arr2, K)); // this will give wrong output - since it does not work for positive integers
		System.out.println(getLongestSubarrayUsingMap(arr2, K));

	}
	
	/*
	 * Approach 1 : By Aditya verma - Sliding Window of variable size
	 * 
	 * TC: O(n)
	 * SC : O(1)
	 * 
	 * NOTE : This approach does not work for negative values
	 */
	public static int getLongestSubaaray(int[] arr, int K) {
		//{1, 1, 1, 2, 1, 4, 3, 5};
		int i=0;
		int j = 0;
		int sum = 0;
		int maxSubarrayLength = 0;
		while( j < arr.length) {
			sum = sum + arr[j];
			
			if( sum < K) {
				j++;
			} else if( sum == K) {
					
					if(j- i +1 > maxSubarrayLength) {
						maxSubarrayLength = j - i + 1;
						
					}
					
					sum = sum - arr[i];
					i++;
					j++;
					
			} else if( sum > K) {
				while( sum > K && i < arr.length) {
					sum = sum - arr[i];
					i++;
				}
				
			}
			
		}
		
		return maxSubarrayLength;
	}
	
	/*
	 * Approach 2 : Leet code appraoch
	 * 
	 * TC : O(n)
	 * SC: O(n)
	 */
	public static int getLongestSubarrayUsingMap(int[] arr, int K) {
		int count = 0, sum = 0;	//[1, 1, 1, 2, 1, 4, 3, 5]
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - K))
                count += map.get(sum - K);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
	}

}
