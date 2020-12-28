package com.kurshit.dp.gfg.easy.subsetproblems;

/*
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
	Examples :
	
	Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
	Output : 5
	The longest common substring is “Geeks” and is of length 5.
	
	Input : X = “abcdxyz”, y = “xyzabcd”
	Output : 4
	The longest common substring is “abcd” and is of length 4.
	
	Input : X = “zxabcdezy”, y = “yzabcdezx”
	Output : 6
 */

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1 = "zxabcdezy";
		String s2 = "yzabcdezx";
		int count = 0;
		System.out.println(longestCommonSubstring(s1, s2, s1.length(), s2.length(), count));
		

	}
	
	public static int longestCommonSubstring(String s1, String s2, int M, int N, int count) {
	
		if(M == 0 || N == 0)
			return 0;
		
		if(s1.charAt(N-1) == s2.charAt(M-1)) {
			count = longestCommonSubstring(s1, s2, M-1, N-1, count + 1);
		} else {
			count =  Math.max(count, Math.max(longestCommonSubstring(s1, s2, M-1, N,0), longestCommonSubstring(s1, s2, M, N-1,0)));
		}		
		return count;
	}

}
