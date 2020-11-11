package com.kurshit.dp.gfg.easy;


/* 
 * Source : https://www.geeksforgeeks.org/tiling-problem/
 * 
 * Problem : Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using 
 * the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 * 
 * Input n = 3
 *	Output: 3
 *	Explanation:
	We need 3 tiles to tile the board of size  2 x 3. 
	We can tile the board using following ways
	1) Place all 3 tiles vertically. 
	2) Place first tile vertically and remaining 2 tiles horizontally.
	3) Place first 2 tiles horizontally and remaining tiles vertically
	
	Input n = 4
	Output: 5
	Explanation:
	For a 2 x 4 board, there are 5 ways
	1) All 4 vertical
	2) All 4 horizontal
	3) First 2 vertical, remaining 2 horizontal
	4) First 2 horizontal, remaining 2 vertical
	5) Corner 2 vertical, middle 2 horizontal
 
 */

/* Problem : Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 
 * tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 * 
 * Solution: 
 * Let “count(n)” be the count of ways to place tiles on a “2 x n” grid, we have following two ways to place first tile.
 *	1) If we place first tile vertically, the problem reduces to “count(n-1)”
 *	2) If we place first tile horizontally, we have to place second tile also horizontally. 
 *	   So the problem reduces to “count(n-2)”
 *
 *	count(n) = n if n = 1 or n = 2
 *  count(n) = count(n-1) + count(n-2)
 *  
 *  The above problem is NOT exactly same as Fibonacci. THe fibonnaci starts with 0 and 1 as initial state.
 *  This proble has inital state as 1 and 2.
 */

public class TilingProblem {
	
	/*
	 * Approach 1 : Recurssion
	 * 
	 */
	
	public static int numberOfWaysTilesUsingRecurssion(int N) {
		
		if( N == 1 || N == 2)
			return N;
		
		return numberOfWaysTilesUsingRecurssion(N -1) + numberOfWaysTilesUsingRecurssion(N -2);
	
	}
	/*
	 * Approach 2 : Memoization
	 */
	static int[] cache;
	public static int numberOfWaysTilesUsingMemoization(int N) {
		
		if( N == 1 || N == 2)
			return N;
		
		if(cache[N] != 0)
			return cache[N];
		
		return cache[N] = numberOfWaysTilesUsingRecurssion(N -1) + numberOfWaysTilesUsingRecurssion(N -2);
	
	}
	
	/*
	 * Approach 3: Top-Down
	 */
	
	public static int numberOfWaysTilesUsingTopDown(int N) {
		int[] cache = new int[N+1];
		
		cache[0] = 1;
		cache[1] = 2; 
		
		for(int i=2; i <N; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[N-1];
	}	
	
	
	public static void main(String[] args) {
		int N = 3;
		System.out.println(numberOfWaysTilesUsingRecurssion(N));
		
		cache = new int[N+1];
		System.out.println(numberOfWaysTilesUsingMemoization(N));
		System.out.println(numberOfWaysTilesUsingTopDown(N));
		
	}

}
