package com.kurshit.graphs.directed.connectivity;

import com.kurshit.graphs.directed.DGraph;

/*
 * Problem Source : https://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
 * Problem Statement : Given an array of strings, find if the given strings can be chained to form a circle. 
 * A string X can be put before another string Y in a circle if the last character of X is the same as the first character of Y.
 * 
 * Input: arr[] = {"geek", "king"}
	Output: Yes, the given strings can be chained.
	Note that the last character of first string is same
	as first character of second string and vice versa is
	also true.
	
	Input: arr[] = {"for", "geek", "rig", "kaf"}
	Output: Yes, the given strings can be chained.
	The strings can be chained as "for", "rig", "geek" 
	and "kaf"
	
	Input: arr[] = {"aaa", "bbb"};
	Output: No
 */

public class StringChainCircle {

	public static void main(String[] args) {
		
		String[] arr = {"geek", "king"};
		// true
		System.out.println(formsCircle(arr, arr.length));
		
		String[] arr1 = {"for", "geek", "rig", "kaf"};
		//true
		System.out.println(formsCircle(arr1, arr1.length));
		
		String[] arr2 = {"aaa", "bbb"};
		//false
		System.out.println(formsCircle(arr2, arr2.length));

	}
	
	/*
	 * Approach : We solve this problem by treating this as a graph problem, where vertices will be the first and last character 
	 * of strings, and we will draw an edge between two vertices if they are the first and last character of the same string, 
	 * so a number of edges in the graph will be same as the number of strings in the array. 
	 * Graph representation of some string arrays are given in the below diagram.
	 * 
	 * 			a -> c -> e
	 * 			^		/	
	 * 			\i <- g
	 * 
	 * arr : abc, efg, cde, ghi, ija
	 * 
	 * Now to check whether this graph can have a loop which goes through all the vertices, we’ll check two conditions, 

		Indegree and Outdegree of each vertex should be the same. 
		The graph should be strongly connected.
	 * 
	 */
	
	public static boolean formsCircle(String[] arr, int N) {
		DGraph graph = new DGraph(26);
		boolean[] visited = new boolean[26];
		
		int[] in = new int[26];
		int[] out = new int[26];
		
		for(int i=0; i < N; i++) {
			
			String s = arr[i];
			
			int first = s.charAt(0) - 'a';
			int last = s.charAt(s.length() -1) - 'a';
			
			visited[first] = true;
			visited[last] = true;
			
			in[last]++;
			out[first]++;
			
			graph.addEdge(first, last);
		}
		
		for(int i=0; i< 26; i++) {
			if(in[i] != out[i]) {
				return false;
			}
		}
		
		return IsStronglyConnected.isStronglyConnected(graph, arr[0].charAt(0) - 'a', visited);
		
	}
}
