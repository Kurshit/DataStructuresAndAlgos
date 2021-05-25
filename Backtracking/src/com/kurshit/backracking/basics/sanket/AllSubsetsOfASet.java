package com.kurshit.backracking.basics.sanket;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfASet {

	public static void main(String[] args) {

		System.out.println("Approach 2 : Using Recurssion " );
		int[] arr = {1, 2 , 3 };
		printSubsetsUsingRecurssion(arr, 3);
		
		System.out.println("Approach 2 : Using Backtracking " );
		printSubsetsUsingBacktracking(arr, 3);

	}
	
	
	public static void printSubsetsUsingRecurssion(int[] arr, int N) {
		
		printSubsetsUsingRecurssion(arr, N,  "", 0);
		
	}


	private static void printSubsetsUsingRecurssion(int[] arr, int N, String result, int idx) {
		
		if(idx == N) {
			System.out.println(result);
		} else {			 
				int c = arr[idx];
				printSubsetsUsingRecurssion(arr, N, result + c, idx + 1);
				printSubsetsUsingRecurssion(arr, N, result, idx + 1);						
		}		
	}
	
	public static void printSubsetsUsingBacktracking(int[] arr, int N) {
		List<Integer> list = new ArrayList<>();
		printSubsetsUsingBacktrackingUtil(arr, N, list, 0);
	}


	private static void printSubsetsUsingBacktrackingUtil(int[] arr, int N, List<Integer> list, int idx) {
		
		if(idx == N) {
			if(!list.isEmpty()) {
				System.out.println(list);
			}
			
			return;
		} 
	
		list.add(arr[idx]);
		printSubsetsUsingBacktrackingUtil(arr, N, list, idx + 1);
		list.remove(list.size() - 1);
		printSubsetsUsingBacktrackingUtil(arr, N, list, idx + 1);
		
	}
}
