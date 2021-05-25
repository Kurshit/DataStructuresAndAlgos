package com.kurshit.strings.basics;


/*
 * Problem: Given a string, check if it is palindrome or not.
 */

public class IsPalindrome {

	public static void main(String[] args) {
		
		String str = "NITIN";
		System.out.println(isPalindrome(str));
		
		str = "KAMALLAMAK";
		System.out.println(isPalindrome(str));

	}
	
	public static boolean isPalindrome(String str) {
		
		int start = 0;
		int end = str.length()-1;
		
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
		
	}

}
