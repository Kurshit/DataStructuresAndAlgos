package com.kurshit.graphs.codencode;

import com.kurshit.graphs.undirected.UGraph;

public class CycleForUndirectedGaraphDFS {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		//expevcted - true
		System.out.println(hasCycle(graph));
		
		UGraph graph1 = new UGraph(5);
		
		graph1.addEdge(0, 1);
		graph1.addEdge(1, 2);
		graph1.addEdge(1, 3);
		// graph1.addEdge(2, 3); this edge causes cycle 
		graph1.addEdge(3, 4);
		//expected - false
		System.out.println(hasCycle(graph1));
		
		
		

	}
	
	
	public static boolean hasCycle(UGraph graph) {
		boolean[] visited = new boolean[graph.V];
		for(int i =0; i < graph.V; i++) {
			if(!visited[i]) {
				if(dfs(graph, i, visited, -1)) {
					return true;
				}
			}
		}
		
		return false;
	}


	private static boolean dfs(UGraph graph, int src, boolean[] visited, int parent) {
		
		visited[src] = true;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				
				if(dfs(graph, dest, visited, src)) {
					return true;
				}
			} else {
				//if already visited, check if it has right parent
				
				if(dest != parent) {
					return true;
				}
			}
		}
		
		return false;
	}
}
