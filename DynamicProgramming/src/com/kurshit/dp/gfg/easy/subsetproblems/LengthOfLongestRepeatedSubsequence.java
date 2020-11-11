package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Source: 
 * 
 * Problem: 
 * 
 * 	Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string 
 * character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the 
 * original string.
 * 
 * Example :
 * 		Input: str = "aabb"
 *	Output: "ab"
	
 *	Input: str = "aab"
 *	Output: "a"
 *	The two subsequence are 'a'(first) and 'a' 
 *	(second). Note that 'b' cannot be considered 
 *	as part of subsequence as it would be at same
 *	index in both.
 */

/*
 * Solution Idea : 
 * 
 * 	This problem is just the modification of Longest Common Subsequence problem. The idea is to find the LCS(str, str) 
 *  where str is the input string with the restriction that when both the characters are same, they shouldn’t be on the 
 *  same index in the two strings.
 *  
 *  Note : Unlike LCS, this takes just one string as input. But we will use same string twice in LCS to get the solution.
 */

public class LengthOfLongestRepeatedSubsequence {

	int[][] cache;

	public static void main(String[] args) {
		LengthOfLongestRepeatedSubsequence l = new LengthOfLongestRepeatedSubsequence();
		String s1 = "aabb";
		int m = s1.length();
		int n = s1.length();
		
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceRecurssion(s1, s1, m, n));
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceMemoization(s1, s1, m, n));
		
		System.out.println();
		
		s1 = "aab";
		m = s1.length();
		n = s1.length();
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceRecurssion(s1, s1, m, n));
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceMemoization(s1, s1, m, n));
		
		System.out.println();
		
		s1 = "abc";
		m = s1.length();
		n = s1.length();
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceRecurssion(s1, s1, m, n));
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceMemoization(s1, s1, m, n));
		
		System.out.println();
		
		s1 = "AABEBCDD";
		m = s1.length();
		n = s1.length();
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceRecurssion(s1, s1, m, n));
		System.out.println("Input: s1:" + s1 + " Result : " + l.lengthOfLongestCommonSubsequenceMemoization(s1, s1, m, n));
		
	}
	
	/*
	 * Approach 1 : Using recurssion
	 */
	
	public int lengthOfLongestCommonSubsequenceRecurssion(String s1, String s2, int m, int n) {
		
		
		if(n == 0 ||  m == 0)
			return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1) && m != n) {
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
		this.cache = new int[m+1][n+1];
		return lengthOfLongestCommonSubsequenceMemoizationUtil(s1, s2, m, n);
	}
	
	public int lengthOfLongestCommonSubsequenceMemoizationUtil(String s1, String s2, int m, int n) {
		
		
		if(n == 0 ||  m == 0)
			return 0;
		
		if(this.cache[m][n] != 0 )
			return this.cache[m][n];
		
		if(s1.charAt(m-1) == s2.charAt(n-1) && m != n) {
			return this.cache[m][n] = 1 + lengthOfLongestCommonSubsequenceMemoizationUtil(s1, s2, m -1, n -1);
		} else {
			return this.cache[m][n] =  Math.max(lengthOfLongestCommonSubsequenceMemoizationUtil(s1, s2, m-1, n), 
					lengthOfLongestCommonSubsequenceMemoizationUtil(s1, s2, m, n-1));
		}
		
	}

}
