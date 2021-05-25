package com.kurshit.dp.atcoder.educational;

/*
 * Problem Source : https://atcoder.jp/contests/dp/tasks/dp_f
 * Problem Statement : You are given Strings S1 & S2. Fine one longest string that is subsequence of both S1 & S2.
 * 
 * A Subsequence of String X is the string obtained by removing zero or more characters from X and concatenating remaining characters without
 * changing the order.
 * 
 * Constraints :
 * 	-- String S1 & S2 are english lower case letters.
 * 
 * Input: 
 * 		S1 
 * 		S2
 * 
 * Output: 
 * 
 * 		Print one LCS String (Not length). If there are multiple strings, any of them will be accepted.
 * 
 * Sample Input1 : 
 * 
 * 		axyb
 * 		abyxb
 * 
 * Output: 
 * 		axb / ayb
 * 
 * Sample Input2 :
 * 
 * 		aa
 * 		xayaz
 * 
 * Output: 
 * 		aa
 * 
 * Sample Input 3:
 * 
 * 		a
 * 		z
 * 
 * Output: 
 * 
 * 		Empty
 * 		
 */

/*
 * Note : In this, we do NOT need length of LCS but the actual string.
 */

public class LCSString {

	public static void main(String[] args) {
		
		String S1 = "axyb";
		String S2 = "abyxb";
		
		System.out.println(getLCSString(S1, S2));
		
		S1 = "aa";
		S2 = "xayaz";
		
		System.out.println(getLCSString(S1, S2));
		
		S1 = "a";
		S2 = "z";
		
		System.out.println(getLCSString(S1, S2));
		
		S1 = "abracadabra";
		S2 = "avadakedavra";
		
		System.out.println(getLCSString(S1, S2));
		

	}
	
	/*
	 * Approach : Refer notes
	 * 
	 * 		First create the matrix of length of LCS. The final answer will be present at last index.
	 * 
	 * 	Now use this matrix to obtain the actual string which would be in reverse order. So before returning it, reverse it.
	 * 	Following will be the cases to consider while tracing actual string from above matrix.
	 * 
	 * 		Store ans = dp[M][N] // max length
	 * 		String result = "";
	 * 
	 * 	Case 1 :If ith and jth character (row and column) of S1 & S2 match 
	 * 			This case indicates the given value was achived from previos diagonal element. 
	 * 
	 * 			Add this character to "result" string and jump to previous diagonal value.
	 * 
	 * Case 2 : If ith & jth character are NOT equal (not values present there)
	 * 
	 * 		Case 2.1 : If values at i(row) and j(column) are SAME.
	 * 
	 * 					More anywhere between Left & Up in matrix. In my case, I am moving to the LEFT
	 * 
	 * 		Case 2.2 If values present at i(row) & j (column) are NOT same.
	 * 					Consider Max(Left,Up) and move there.
	 *  
	 */
	
	public static String getLCSString(String S1, String S2) {
		
		int M = S1.length();
		int N = S2.length();
		
		int[][] dp = new int[M+1][N+1];
		
		//this is to pupulate the matrix
		
		for(int i = 1; i <= M; i++ ) {
			for(int j = 1; j <= N; j++) {
				if(S1.charAt(i-1) == S2.charAt(j-1))   {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		//to print the string out of matrix
		
		int finalAns = dp[M][N];
		
		/*
		 * Using StringBuilder instead of String because String does not have inbuild reverse function
		 */
		StringBuilder result = new StringBuilder(""); 
		
		int i = M, j = N;
		
		while(i > 0 && j > 0) {
			if(S1.charAt(i-1) == S2.charAt(j-1)) {
				result.append(S1.charAt(i-1));
				i--;
				j--;
			} else if(dp[i-1][j] > dp[i][j-1]) {
				//go up direction
				i--;
			} else {
				//for same or left larger - Go left
				j--;
			}
		}
		
		
		return result.reverse().toString();
	}

}
