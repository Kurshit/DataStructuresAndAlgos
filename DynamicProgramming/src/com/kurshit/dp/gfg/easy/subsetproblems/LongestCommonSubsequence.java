package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Problem Statement : Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * 
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
	LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		System.out.println(longestCommonSubseqeunce(s1, s2, s1.length(), s2.length()));

	}
	
	public static int longestCommonSubseqeunce(String s1, String s2, int M, int N) {
		
		if(M == 0 || N == 0)
			return 0;
		
		if(s1.charAt(N-1) == s2.charAt(M-1)) {
			return 1 + longestCommonSubseqeunce(s1, s2, M-1, N-1);
		} else {
			return Math.max(longestCommonSubseqeunce(s1, s2, M-1, N), longestCommonSubseqeunce(s1, s2, M, N-1));
		}
	}

}
