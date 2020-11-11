package com.kurshit.dp.gfg.easy;

/*
 *  Source : https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *  
 *  Problem : 
 *  	The Fibonacci numbers are the numbers in the following integer sequence.
 * 		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * 
 * 	Exmaple : n = 9
 * 		Output : 34
 *  
 */

public class FibonacciNumbers {
	
	/*
	 * Approch 1 : Recursion
	 * 
	 */
	
	public static int fibonacciRecursion(int n) {
		if(n == 0 || n == 1)
			return n;
		
		return fibonacciRecursion(n -1) + fibonacciRecursion(n-2);
	}
	
	/* 
	 * Approach 2: Memoization
	 */
	private static int[] cache;
	public static int fibonacciMemoization(int n) {
		if(n == 0 || n == 1)
			return n;
		
		if(cache[n] != 0)
			return cache[n];
		return cache[n] = fibonacciMemoization(n-1) + fibonacciMemoization(n-2);
	}
	
	public static int fibonacciTopDown(int n) {
		int[] cache = new int[n+1];
		
		cache[0] = 0;
		cache[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		
		int N = 32;
		cache = new int[N+1];
		
		System.out.println(fibonacciRecursion(N));
		System.out.println(fibonacciMemoization(N));
		System.out.println(fibonacciTopDown(N));

	}
	
	

}
