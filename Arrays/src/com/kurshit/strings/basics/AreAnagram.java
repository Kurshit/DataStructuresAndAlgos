package com.kurshit.strings.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Given two strings, check if they are anagram of each other.
 * An anagram of a string is another string that contains the same characters, only the order of characters can be different. 
 * 
 * For example, �abcd� and �dabc� are an anagram of each other.
 * 
 * Example: LISTEN SILENT
 *  
 */

public class AreAnagram {

	public static void main(String[] args) {

		String s = "LISTEN";

		String[] arr = s.split("");

		System.out.println(Arrays.toString(arr));
		
		String str1 = "LISTEN";
		String str2 = "SILENT";
		
		System.out.println(areAnagram(str1, str2));
		
		str1 = "LISTEN";
		str2 = "SILENP";
		
		System.out.println(areAnagram(str1, str2));

	}
	
	public static boolean areAnagram(String str1, String str2) {
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		HashMap<Character, Integer> freqMap = new HashMap<>();
		
		for(int i=0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
			
		}
		
		for(int i=0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			
			if(!freqMap.containsKey(c)) {
				return false;
			} else {
				freqMap.put(c, freqMap.getOrDefault(c, 0) - 1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			
			if(entry.getValue() != 0) {
				return false;
			}
		}
		
		return true;
		
	}

}
