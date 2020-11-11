package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Source : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * Problem : 
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * 
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * 
 */

public class LengthOfLongestCommonnSubSequence {
	
	int[][] cache;

	public static void main(String[] args) {
		LengthOfLongestCommonnSubSequence l = new LengthOfLongestCommonnSubSequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		int m = s1.length();
		int n = s2.length();
		l.cache = new int[m+1][n+1];
		System.out.println(l.lengthOfLongestCommonSubsequenceRecurssion(s1, s2, m, n));
		System.out.println(l.lengthOfLongestCommonSubsequenceMemoization(s1, s2, m, n));
	}
	
	/*
	 * Approach 1 : Using recurssion
	 */
	
	public int lengthOfLongestCommonSubsequenceRecurssion(String s1, String s2, int m, int n) {
		
		
		if(n == 0 ||  m == 0)
			return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return 1 + lengthOfLongestCommonSubsequenceRecurssion(s1, s2, m -1, n -1);
		} else {
			return Math.max(lengthOfLongestCommonSubsequenceRecurssion(s1, s2, m-1, n), 
					lengthOfLongestCommonSubsequenceRecurssion(s1, s2, m, n-1));
		}
		
	}
	
	/*
	 * Approach 2 : Using memoization
	 * 
	 */
	
	public int lengthOfLongestCommonSubsequenceMemoization(String s1, String s2, int m, int n) {
		
		
		if(n == 0 ||  m == 0)
			return 0;
		
		if(this.cache[m][n] != 0)
			return this.cache[m][n];
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return this.cache[m][n] = 1 + lengthOfLongestCommonSubsequenceMemoization(s1, s2, m -1, n -1);
		} else {
			return this.cache[m][n] =  Math.max(lengthOfLongestCommonSubsequenceMemoization(s1, s2, m-1, n), 
					lengthOfLongestCommonSubsequenceMemoization(s1, s2, m, n-1));
		}
		
	}
}
