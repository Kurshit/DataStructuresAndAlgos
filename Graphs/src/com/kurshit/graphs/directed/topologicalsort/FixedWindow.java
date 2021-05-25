package com.kurshit.graphs.directed.topologicalsort;

import java.util.Arrays;

public class FixedWindow {

	public static void main(String[] args) {
		
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6};
		
		showWindows(arr, 3);
		

	}
	
	public static void showWindows(int[] arr, int K) {
		
		
		int i = 0;
		int j = 0;
		int N = arr.length;
		
		while(j < N) {
			
			if(j - i + 1 == K) {
				int curr = i;
				int[] result = new int[K];
				int idx = 0;
				
				while( curr <= j) {
					result[idx] = arr[curr];
					idx++;
					curr++;
				}
				
				System.out.println(Arrays.toString(result));
				
				j++;
				i++;
			} else if(j - i + 1 < K) {
				j++;
			}			
			
		}	
		
	}
	

}
