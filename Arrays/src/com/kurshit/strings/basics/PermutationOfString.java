package com.kurshit.strings.basics;

/*
 * Problem: Print all permutations of a given string
 * 
 * This is simillar to Permutations.java program for array of inetegr. This is dones using backtracking.
 * 
 */

public class PermutationOfString {

	public static void main(String[] args) {
		
		String str = "ABC";
		permute(str);

	}
	
	public static void permute(String str) {
		
		char[] arr = str.toCharArray();
		int start = 0;
		int end = str.length();
		permuteUtil(arr, start, end);
	}
	
	public static void permuteUtil(char[] arr, int start, int end) {
		
		if(start == end) {
			System.out.println(String.valueOf(arr));
		} else {
			
			for(int i = start; i < end; i++) {
				swap(arr, start, i);
				permuteUtil(arr, start+1, end);
				swap(arr, start, i);
			}
			
		}
		
	}

	private static void swap(char[] arr, int start, int end) {
		
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}

}
