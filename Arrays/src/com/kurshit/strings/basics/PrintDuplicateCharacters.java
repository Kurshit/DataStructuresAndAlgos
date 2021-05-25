package com.kurshit.strings.basics;

/*
 * Progeam : Write a program to print duplicate characters (characters whose occurence is > 1 in the same order
 * that occurs in original string.
 */

public class PrintDuplicateCharacters {

	public static void main(String[] args) {
		
		String s = "test"; 
		pringDuplicateCharacters(s);
		
		s = "geeksforgeeks";
		pringDuplicateCharacters(s);
		
		s = "kukkuu";
		pringDuplicateCharacters(s);

	}
	
	public static void pringDuplicateCharacters(String str) {
		
		int[] freq = new int[256];
		
		for(int i=0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			freq[c] = freq[c] + 1;
		}
		
		for(int i=0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if(freq[c] > 1) {
				System.out.print(c);
			}
		}
		
		System.out.println();
		
	}

}
