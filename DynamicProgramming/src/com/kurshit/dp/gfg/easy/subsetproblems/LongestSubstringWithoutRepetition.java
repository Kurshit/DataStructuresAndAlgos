package com.kurshit.dp.gfg.easy.subsetproblems;

import java.util.HashSet;
import java.util.Set;

	
		/*
		 * Given a string, find the length of the longest substring without repeating characters.
		 *
		 *	Example 1:
		 *
		 *	Input: "abcabcbb"
		 *	Output: 3 
		 *	Explanation: The answer is "abc", with the length of 3. 
		 *	Example 2:
			
		 *	Input: "bbbbb"
		 *	Output: 1
		 *	Explanation: The answer is "b", with the length of 1.
			
		*/

public class LongestSubstringWithoutRepetition {
	
	public static void main(String[] args) {
		
		LongestSubstringWithoutRepetition l = new LongestSubstringWithoutRepetition();
		String s1 = "abcabccba";
				
		System.out.println(s1 +": " + l.getLSWRThreeLoops((s1)));
		
		System.out.println(s1 +": " + l.getLSWR(s1));
		
		//Optimized and most efficient - O(n)
		System.out.println(s1 +": " + l.getLSWRSlidingWindow(s1));
		
		String s2 = "GEEKSFORGEEKS";
		
		System.out.println(s2 +": " + l.getLSWRThreeLoops((s2)));
		
		System.out.println(s2 +": " + l.getLSWR(s2));
		
		System.out.println(s2 + ":" + l.getLSWRSlidingWindow(s2));
	}
	
	
	/*
	 * Approach 1: TC O(n3)
	 * 
	 * 	For each substring, check if that substring is unique and if yes, compare the length of that unique string with the maintained Max string
	 * 
	 */
	
	public int getLSWRThreeLoops(String key) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i < key.length(); i++) {
			for(int j=i; j < key.length(); j++) {
				if(isUnique(key, i, j)) {
					max = Math.max(max, j-i+1);
				}
			}
		}
		return max;
	}
	
	private boolean isUnique(String key, int i, int j) {
		Set<Character> set = new HashSet<>();
		
		while(i <= j) {
			char value = key.charAt(i);
			
			if(set.contains(value))
				return false;
			
			set.add(value);
			i++;
		}
		
		return true;
	}
	
	/*
	 * Approach 2: TC: O(n2)
	 * 	
	 * We will use two for loops which would act as a sliding window. 
	 * 
	 * 
	 * 
	 */
	
	public int getLSWR(String key) {
		
		int n = key.length();
		int max = Integer.MIN_VALUE;
		for(int i=0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			for(int j=i; j < n; j++) {
				
				if(set.contains(key.charAt(j)))
					break;
				
				set.add(key.charAt(j));
				max = Math.max(max, j-i+1);
				
			}
			
			set.remove(key.charAt(i));
		}
		
		return max;
	}
	
	/*
	 * Approach 3 : Slding Window by Rachit - TC O(n) 
	 * Source :  https://www.youtube.com/watch?v=s2ZGeNeKpuI&t=566s&ab_channel=RachitJain
	 *  
	 */
	
	public int getLSWRSlidingWindow(String s) {
		
		int N = s.length();
		
		if(N == 0)
			return 0;
		
		int i =0, j = 0;
		Set<Character> set = new HashSet<>();
		set.add(s.charAt(0));
		int maxLength = 1;
		
		while(j < N-1) {
			
			if(!set.contains(s.charAt(j+1))) {
				set.add(s.charAt(j+1));				
				j++;
				maxLength = Math.max(maxLength, j-i+1);
				
			}else {
				set.remove(s.charAt(i));
				i++;
			}
			
		}
		
		return maxLength;
		
	}
	
	
}
