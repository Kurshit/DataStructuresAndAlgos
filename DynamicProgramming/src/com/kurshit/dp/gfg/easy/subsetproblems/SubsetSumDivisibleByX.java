package com.kurshit.dp.gfg.easy.subsetproblems;

import java.util.Arrays;

/*
 * Given a set of non-negative distinct integers, and a value m, determine if there is a subset of the given set with sum divisible by m.
	Input Constraints

	Example: 
		Input : arr[] = {3, 1, 7, 5};
        	m = 6;
		Output : YES

		Input : arr[] = {1, 6};
		        m = 5;
		Output : NO
 */

/*
 * Solution Idea:
 * 
 * 	If n > m there will always be a subset with sum divisible by m (which is easy to prove with pigeonhole principle). 
 *  So we need to handle only cases of n <= m.
 *  
 */

public class SubsetSumDivisibleByX {

	public static void main(String[] args) {
		int[] a = {3,1,7,5};
		int N = 4;
		int M = 6;
		System.out.println(modularSum(a, N, M));

	}

	static boolean modularSum(int arr[], 
			int n, int m) 
	{ 
		if (n > m) 
			return true; 

		// This array will keep track of all 
		// the possible sum (after modulo m) 
		// which can be made using subsets of arr[] 
		// initialising boolean array with all false 
		boolean DP[]=new boolean[m]; 

		Arrays.fill(DP, false); 

		// we'll loop through all the elements 
		// of arr[] 
		for (int i = 0; i < n; i++) 
		{ 

			// anytime we encounter a sum divisible 
			// by m, we are done 
			if (DP[0]) 
				return true; 

			// To store all the new encountered sum 
			// (after modulo). It is used to make 
			// sure that arr[i] is added only to 
			// those entries for which DP[j] 
			// was true before current iteration. 
			boolean temp[] = new boolean[m]; 
			Arrays.fill(temp, false); 

			// For each element of arr[], we loop 
			// through all elements of DP table 
			// from 1 to m and we add current 
			// element i. e., arr[i] to all those 
			// elements which are true in DP table 
			for (int j = 0; j < m; j++) 
			{ 

				// if an element is true in 
				// DP table 
				if (DP[j] == true) 
				{ 
					if (DP[(j + arr[i]) % m] == false) 

						// We update it in temp and update 
						// to DP once loop of j is over 
						temp[(j + arr[i]) % m] = true; 
				} 
			} 

			// Updating all the elements of temp 
			// to DP table since iteration over 
			// j is over 
			for (int j = 0; j < m; j++) 
				if (temp[j]) 
					DP[j] = true; 


			// Also since arr[i] is a single 
			// element subset, arr[i]%m is one 
			// of the possible sum 
			DP[arr[i] % m] = true; 
		} 

		return DP[0]; 
	} 

}
