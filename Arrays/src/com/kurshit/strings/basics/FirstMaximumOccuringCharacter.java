package com.kurshit.strings.basics;

/*
 * Program: Write a program to find maximum occuring character in a string.
 * If there are multiple character with same no of occurence, return the first one.
 * 
 * 
 */


public class FirstMaximumOccuringCharacter {

	public static void main(String[] args) {
		String s = "test"; 
		System.out.println(getFirstCharacter(s));
		
		s = "geeksforgeeks";
		System.out.println(getFirstCharacter(s));
		
		s = "kukkuu";
		System.out.println(getFirstCharacter(s));
	}
	
	
	/*
	 * Approach 1 : 
	 *  
	 *  Populate freqency array for each character with its freqeuncy.
	 *  Then, iterate characte by character on String and store character with max freq in result.
	 *  For same freq, skip it as we only need first character with max occurence. 
	 * 
	 * 
	 * TC : O(N)
	 * 	: Population of freq map would take O(N). Now next iteration to find max one would need O(N).
	 *  
	 * SC: O(N)
	 * 
	 * 
	 */
	
	public static char getFirstCharacter(String str) {
		
		int[] freq = new int[256];
		
		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			freq[c] = freq[c] + 1;
		}
		
		char result = ' ';
		int maxFreq = Integer.MIN_VALUE;
		
		
		for(int i=0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(maxFreq < freq[c]) {
				maxFreq = freq[c];
				result = c;
			}
		}
		
		return result;
	}

}
