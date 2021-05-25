package com.kurshit.strings.basics;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "kurshit";
		System.out.println(reverseWithoutRecursion(str));
		
		System.out.println(reverseUsingRecurssion(str));
	}
	
	public static String reverseWithoutRecursion(String str) {
		
		char[] s = str.toCharArray();
		
		int start = 0;
		int end = str.length() - 1;
		
		while(start <= end) {
			char c = s[start];
			s[start] = s[end];
			s[end] = c;
			start++;
			end--;
		}
		
		return String.valueOf(s);
		
	}
	
	public static String reverseUsingRecurssion(String str) {
		
		String res = "";
		int N = str.length();
		res = reverseUtil(str, res, N);
		return res;
	}

	private static String reverseUtil(String str, String res, int N) {
		
		if(N == 0) {
			return res;
		}
		
		res = res + str.charAt(N-1);
		
		return reverseUtil(str, res, N-1);
	}
	
}
