package com.kurshit.graphs.undirected.traversal;

/*
 * Problem Source : https://www.geeksforgeeks.org/bipartite-graph/
 * 
 * Problem : Check if given graph is Bipartitie graph or not
 * 
 * Solution : https://www.youtube.com/watch?v=MtFPqCcsoeA&t=492s&ab_channel=CodeNCode
 * 
 * 
 */

import com.kurshit.graphs.undirected.UGraph;

public class IsBipartiteGraph {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(6);
		
		/*
		 * 					0
		 * 				/		\
		 * 			   5		  1
		 *             |		  |
		 * 			   4		  2
		 * 				\		/
		 * 					3
		 */
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 0);
		
		System.out.println(isBipartitie(graph));
		
	}
	
	
	/*
	 * THe following approach works for connected undirected graph where we always begin from source vertex 0 assuming all vertices
	 * are visible from this source node.
	 * 
	 * To make it work for disconnected graph, call isBipartitie for every non visited vertex from the for loop.
	 * 
	 * The following is for graph represnted as adjacency list.
	 */
	public static boolean isBipartitie(UGraph graph) {
		
		boolean[] visited = new boolean[graph.V];
		int[] colrs = new int[graph.V];
		boolean result = dfs(graph, 0, visited, colrs, 1);
		return result;
		
	}

	private static boolean dfs(UGraph graph, int src, boolean[] visited, int[] colrs, int currColor) {
		visited[src] = true;
		colrs[src] = currColor;
		
		for(int dest : graph.adjList[src]) {
			
			if(!visited[dest]) {
				if(!dfs(graph, dest, visited, colrs, currColor ^ 1)) {  // invert color value using XOR
					return false;
				}
			} else {
				if(colrs[dest] == colrs[src])
					return false;
			}			
			
		}
		
		return true;
		
	}
}
