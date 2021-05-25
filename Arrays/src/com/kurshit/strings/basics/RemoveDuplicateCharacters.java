package com.kurshit.strings.basics;

import java.util.HashSet;
import java.util.Set;

/*
 * Write a program to remove all duplicate characters from a given string
 * 
 * Constraints:
 * 
 * 	1. Order should remain same
 *  2. Capital and small letters are considered difft
 *  3. Return a new string - you can't really do this task in place as string is immutable.
 *  4. String is not orderd in the input
 *  
 *  
 *  
 */

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
	
		String s1 = "Kurshit";
		System.out.println(removeDuplicates(s1));
		System.out.println(removeDuplicatesUsingBits(s1));
		s1 = "kukreja";
		System.out.println(removeDuplicates(s1));
		System.out.println(removeDuplicatesUsingBits(s1));
		s1 = "kurshitkukreja";
		System.out.println(removeDuplicates(s1));
		System.out.println(removeDuplicates(s1));
		
		
		
	}
	
	/*
	 * Brute force approach is to use two for loops with i and j and check for every i in every j.
	 * 
	 * Approach 1 : 
	 * Following approach uses hashmap: 
	 * 
	 * TC: O(N)
	 * SC : O(N)
	 */
	
	public static String removeDuplicates(String str) {
		
		Set<Character> set = new HashSet<>();
		String result = "";
		
		for(int i=0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if(!set.contains(c)) {
				result = result + c;
				set.add(c);
			}			
		}
		
		return result;
	}
	
	
	/*
	 * Approach 2 : Using bitwise operations:
	 * 
	 * Assumption : Only small letters
	 * 
	 * TC : O(N)
	 * SC : O(1)
	 * 
	 */
	
	
	public static String removeDuplicatesUsingBits(String str) {
		
		String result = "";
		
		int counter = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			char currChar = str.charAt(i);
			
			int bitFromLeft = currChar - 'a';
			
			if(!checkIfBitisSet(counter, bitFromLeft)) {
				
				result = result + currChar;
				
				counter = counter | (1 << bitFromLeft);
			}
			
		}
		
		return result;
		
	}

	private static boolean checkIfBitisSet(int counter, int bitFromLeft) {
		
		int F = 1;
		
		F = F << bitFromLeft;
		
		if( (counter & F) == 0) {
			return false;
		}
		
		return true;
	}
	

}
