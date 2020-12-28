package com.kurshit.graphs.directed.connectivity;

/*	Problem Source: https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/
 *  Problem : Given a directed graph and two vertices ‘u’ and ‘v’ in it, count all possible walks from ‘u’ to ‘v’ with exactly k 
 *  edges on the walk. 
	The graph is given as adjacency matrix representation where value of graph[i][j] as 1 indicates that there is an edge from 
	vertex i to vertex j and a value 0 indicates no edge from i to j.
	
	For example consider the following graph. Let source ‘u’ be vertex 0, destination ‘v’ be 3 and k be 2. 
	The output should be 2 as there are two walk from 0 to 3 with exactly 2 edges. The walks are {0, 2, 3} and {0, 1, 3}
 */

public class AllWalksFromSourceToDestWithKEdges {
	
	public static void main(String[] args) {
		
		int graph[][] = new int[][] { 
			{ 0, 1, 1, 1 },
            { 0, 0, 0, 1 },
            { 0, 0, 0, 1 },
            { 0, 0, 0, 0 } };
			
        int u = 0, v = 3, k = 2;
			
		System.out.println(countWalks(graph, u, v, k));
		
	}
	
	/*
	 * Approach : reate a recursive function that take current vertex, destination vertex and the count of vertex. 
	 * Call the recursive function with all adjacent vertex of a current vertex with the value of k as k-1. when the value of 
	 * k is 0 then check that the current vertex is the destination or not. If destination then increases output answer by 1.
	 * 
	 */
	
	public static int countWalks(int graph[][], int u, int v, int k) {
		
		
		if(k == 0 && u == v) {
			return 1;
		}
		
		if(k == 1 && graph[u][v] == 1) {
			return 1;
		}
		
		if(k <= 0) {
			return 0;
		}
		
		int count = 0;
		
		for(int i=0; i < v; i++) {
			if(graph[u][i] == 1) { //check if it is adjacent of u
				count = count + countWalks(graph, i, v, k-1);
			}
		}
		
		return count;
	}

}
