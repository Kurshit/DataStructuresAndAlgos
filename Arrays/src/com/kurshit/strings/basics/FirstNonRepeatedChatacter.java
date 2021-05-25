package com.kurshit.strings.basics;

/*
 * Problem: Write a program to print the first non repeating character. 
 * i.e, print a first character whose occurence is 1.
 */

public class FirstNonRepeatedChatacter {

	public static void main(String[] args) {
		
		String str = "geeksforgeeks";
		System.out.println(getFirstNonRepeatedCharacter(str));

	}
	
	/*
	 * Approach 1 : Using freq array or hashmap.
	 * 
	 * TC : O(N)
	 * SC : O(N)
	 * 
	 */
	
	public static char getFirstNonRepeatedCharacter(String str) {		

		int[] freq = new int[256];
		
		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			freq[c] = freq[c] + 1;
		}
		
		char result = ' ';
		for(int i=0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if(freq[c] == 1) {
				result = c;
				break;
			}		
		}
				
		return result;
	}
	
}
