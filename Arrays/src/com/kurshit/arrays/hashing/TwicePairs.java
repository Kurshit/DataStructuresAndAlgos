package com.kurshit.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a number, find the count of pairs such that the other number is twice the first one.
 * 
 * Example : 
 * 	
 * 	{2, 2, 4, 4, 4}
 * 
 * Output: 
 * 	
 * 	6 
 * 
 */

public class TwicePairs {

	public static void main(String[] args) {
		
		int[] arr = {2, 2, 4, 4, 4};
		System.out.println(getPairs(arr, arr.length));

	}
	
	public static int getPairs(int[] arr, int N) {
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int item : arr) {
			freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
		}
		
		int ans = 0;
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			
			if(freqMap.containsKey(2 * entry.getKey())) {
				ans = ans + freqMap.get(2 * entry.getKey()) * entry.getValue();
			}
		}
		
		
		return ans;

	}

}
