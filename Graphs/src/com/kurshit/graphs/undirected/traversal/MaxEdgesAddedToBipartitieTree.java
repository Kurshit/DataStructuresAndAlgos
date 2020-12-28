package com.kurshit.graphs.undirected.traversal;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Problem source : https://www.geeksforgeeks.org/maximum-number-edges-added-tree-stays-bipartite-graph/
 * 
 * Problem : Maximum number of edges that can be further added to a Bipartite TREE (mind this, it is a tree), so thus it remains
 * Bipartitie Graph (GRAPH, not tree).
 * 
 * Solution : count(0) * count(1) - (N-1)
 */

public class MaxEdgesAddedToBipartitieTree {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(6);
		
		/*
		 * 					0
		 * 				/		\
		 * 			   5		  1
		 *             |		  |
		 * 			   4		  2
		 * 				\		
		 * 				  3
		 */
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);		
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 0);
		int src = 0;
		System.out.println(getMaxEdgesWeCanAdd(graph, src));
	}
	
	/* 
	 * Given a Bipartite Tree, we will check if it is even bipartite or no and then assign the cound
	 */
	
	public static int getMaxEdgesWeCanAdd(UGraph graph, int src) {
		
		boolean[] visited = new boolean[graph.V];
		int[] colors = new int[graph.V];
		int currColor = 1;
		if(!dfs(graph, src, visited, colors, currColor)) {
			return -1;
		}
		
		int colorCountZero = 0;
		int colorCountOne = 0;
		
		for(int i=0; i < colors.length; i++) {
			if(colors[i] == 0) {
				colorCountZero++;
			} else {
				colorCountOne++;
			}
		}
		
		return colorCountOne * colorCountZero - (graph.V-1);
	}

	private static boolean dfs(UGraph graph, int src, boolean[] visited, int[] colors, int currColor) {
		
		visited[src] = true;
		colors[src] = currColor;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				if(!dfs(graph, dest, visited, colors, currColor ^ 1)) {
					return false;
				} else {
					if(colors[src] == colors[dest]) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
