package com.kurshit.graphs.undirected.traversal;

/*
 * Problem Source :https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/
 * 
 * Problem : Given a tree (not necessarily a binary tree) and a number of queries such that every query takes two nodes of the tree as parameters. For every query pair, find if two nodes are on the same path from the root to the bottom.

	For example, consider the below tree, if given queries are (0, 4), (0, 5), and (0, 6), then answers should be true, true, and false respectively.
	
	 					0
	 				/	|	\
	 			  1     2     3
	 			/	    |       \
	 		   4        5        6
 *
 */

import com.kurshit.graphs.undirected.UGraph;

public class CheckIfTwoNodesAreAtSamePathInNTree {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		
		System.out.println(areOnSamePath(graph, 0, 4));
		System.out.println(areOnSamePath(graph, 0, 5));
		System.out.println(areOnSamePath(graph, 0, 6));
		System.out.println(areOnSamePath(graph, 1, 6));
		System.out.println(areOnSamePath(graph, 2, 6));
	}
	
	static int timer = 1;
	
	/*
	 * Solution Approach : Idea is to calculate the in and outtime of each vertex using DFS.
	 * 
	 * The vertex which will enter first in tree will have earlier intime and late out time.
	 */
	
	public static boolean areOnSamePath(UGraph graph, int u, int v) {
		boolean[] visited = new boolean[graph.V];
		int[] in = new int[graph.V];
		int[] out = new int[graph.V];
		int src = 0;
		dfs(graph, src, visited, in, out);
		
		return checkIfOnSamePath(in, out, u, v);
	}
	
	private static boolean checkIfOnSamePath(int[] in, int[] out, int u, int v) {
		
		if((in[u] < in[v] && out[u] > out[v]) || (in[v] < in[u] && out[v] > out[u]))
			return true;
		
		return false;
	}

	private static void dfs(UGraph graph,int src, boolean[] visited, int[] in, int[] out) {
		visited[src] = true;
		in[src] = timer++;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited, in, out);
			}
		}
		
		out[src] = timer++;
	}


}
