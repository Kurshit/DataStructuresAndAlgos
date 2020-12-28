package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Problem SOurce : https://www.geeksforgeeks.org/longest-repeated-subsequence/
 * 
 * Problem: Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character 
 * at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 * 
 * Example: str = "AABEBCDD";
 * 
 * Output: 3 - (ABD)
 */

public class LongestRepeatedSubsequence {

	public static void main(String[] args) {
		String s1 = "AABEBCDD";
		String s2 = s1;
		System.out.println(longestCommonSubseqeunce(s1, s2, s1.length(), s2.length()));
		
	}

	public static int longestCommonSubseqeunce(String s1, String s2, int M, int N) {

		if(M == 0 || N == 0)
			return 0;

		if(s1.charAt(N-1) == s2.charAt(M-1) && M != N) {
			return 1 + longestCommonSubseqeunce(s1, s2, M-1, N-1);
		} else {
			return Math.max(longestCommonSubseqeunce(s1, s2, M-1, N), longestCommonSubseqeunce(s1, s2, M, N-1));
		}
	}

}
