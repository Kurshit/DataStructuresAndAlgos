package com.kurshit.graphs.codencode;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Problem Source: https://www.youtube.com/watch?v=z49Ohr5Ypnw&list=PL2q4fbVm1Ik6DCzm9XZJbNwyHtHGclcEh&index=4&ab_channel=CodeNCode 
 *
 * Problem : Return the number of connected components in UNDIRECTED graph
 */

public class PrintConnectedComponents {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(8);
		
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(1, 7);
		graph.addEdge(4, 5);
		graph.addEdge(5, 7);
		graph.addEdge(3, 5);
		graph.addEdge(2, 6);
		//Expected - 2
		System.out.println(getConnectedComponents(graph));

	}
	
	public static int getConnectedComponents(UGraph graph) {
		
		
		int count = 0;
		
		boolean[] visited = new boolean[graph.V];
		
		for(int i=0; i < graph.V; i++) {
			if(!visited[i]) {
				dfs(graph, i, visited);
				count++;
			}
		}
		
		return count; 
		
	}
	
	private static void dfs(UGraph graph, int src, boolean[] visited) {
		visited[src] = true;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited);
			}
		}
	}

}
