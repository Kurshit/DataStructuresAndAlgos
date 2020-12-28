package com.kurshit.graphs.directed.topologicalsort;

/*
 * Problem source : https://www.geeksforgeeks.org/longest-path-between-any-pair-of-vertices/
 * 
 * Problem: We are given a map of cities connected with each other via cable lines such that there is no cycle between any 
 * two cities. We need to find the maximum length of cable between any two cities for given city map.
 * 
 * Input : n = 6  
        1 2 3  // Cable length from 1 to 2 (or 2 to 1) is 3
        2 3 4
        2 6 2
        6 4 6
        6 5 5
	Output: maximum length of cable = 12
 */


import java.util.Iterator;

import com.kurshit.graphs.undirected.UGraphWithW;
import com.kurshit.graphs.undirected.UGraphWithW.UPair;
import com.kurshit.graphs.undirected.acyclic.weighted.path.LongestPathFromASource;

public class UndirectedLongestPathBetweenAnyPairOfVertices {

	public static void main(String[] args) {
		int V = 6;
		UGraphWithW graph = new UGraphWithW(V);  // this is edge list with weights
	
		graph.addEdge(0, 1, 3);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 5, 2);
		graph.addEdge(5, 3, 6);
		graph.addEdge(5, 4, 5);
		
		
		System.out.println(getLongestPath(graph));
		System.out.println(getLongestPathUsingDFSandDist(graph));
		

	}	
	
	/* Approach 1 :
	 *  Solution Approach: Using DFS algo for undirceted graph.
	 *  We create undirected graph for given city map and do DFS from every city to find maximum length of cable. 
	 *  While traversing, we look for total cable length to reach the current city and if it’s adjacent city is not visited 
	 *  then call DFS for it but if all adjacent cities are visited for current node, then update the value of max_length if 
	 *  previous value of max_length is less than current value of total cable length
	 *  
	 */
	
	/*
	 * Another solution could be to find Maximum Spanning Tree instead of Min Spanning Tree for this graph.
	 * But min Spanning tree is Undirected and Connected But not TREE initially. ? 
	 * 
	 */
	
	public static int getLongestPath(UGraphWithW graph) {
		
		Result r = new Result();
		r.maxLength = Integer.MIN_VALUE;		
		
		// we will do the dfs on every node to find tha max
		for(int i=0 ; i < graph.V; i++) {
			boolean[] visited = new boolean[graph.V]; // this will be reset for every dfs
			dfs(graph, i, 0, visited, r);
		}
		
		return r.maxLength;
	}
	/*
	 * prevLength is sum of cable lengths till current node
	 */
	
	private static void dfs(UGraphWithW graph, int src, int prevLength, boolean[] visited, Result r) {
		
		visited[src] = true;
		int curLength = 0;
		
		Iterator<UPair> itr = graph.adjList[src].iterator();
		
		while(itr.hasNext()) {
			UPair adjacent = itr.next();
			
			if(!visited[adjacent.dest]) {
				curLength = prevLength + adjacent.weight;
				dfs(graph, adjacent.dest, curLength, visited, r);
			}
			
			if(r.maxLength < curLength) {
				r.maxLength = curLength;
			}
			
			curLength = 0;
			
		}
		
	}
	
	
	/*
	 * Approach 2 : Using the usual DFS keeping dist[] which will hold the distance to every other vertex from given source.
	 * 
	 *  Now, we will need to make every node as source node and invoke DFS on every vertex to find the max
	 */
	
	public static int getLongestPathUsingDFSandDist(UGraphWithW graph) {
		int maxPath = Integer.MIN_VALUE;
		for(int i=0; i < graph.V; i++) {
			int src = i;
			int maxForThisSrc = LongestPathFromASource.getLongestPathFromASourceDFS(graph, src);
			maxPath = Math.max( maxPath, maxForThisSrc);
			
		}
		
		return maxPath;
	}
	

}

class Result {
	int maxLength;
}