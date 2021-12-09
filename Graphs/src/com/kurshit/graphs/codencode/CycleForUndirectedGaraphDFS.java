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
		//expected - true
		System.out.println(hasCycle(graph));
		
		UGraph graph1 = new UGraph(5);
		
		graph1.addEdge(0, 1);
		graph1.addEdge(1, 2);
		graph1.addEdge(1, 3);
		// graph1.addEdge(2, 3); this edge causes cycle 
		graph1.addEdge(3, 4);
		//expected - false
		System.out.println(hasCycle(graph1));

		UGraph graph2 = new UGraph(4);

		graph2.addEdge(0, 1);
		graph2.addEdge(1, 2);
		graph2.addEdge(1, 3);
		// graph1.addEdge(2, 3); this edge causes cycle
		graph2.addEdge(2, 3);
		//expected - false
		System.out.println(hasCycle(graph2));
		
		
		

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

	/*
		Approach : In undirected acyclic graph - a node can be reachable by only and only one single path. If a node is beaing reahced by more than one path,
		it contains a cycle. Thus, we can keep track of visited node. Since it is a undirected graph, when we encounter any destination node which is already
		visited - which essentially means it is already reachable by one path - we will just check if that destination is pointing back to its parent from where it landed (which shows one path - E.g. 0 - 1 ( 0 -parent) and then 1 to 0) - if dest node is pointing to visited node which is not its parent, then the graph contains cycle.

		To do this, for every dest node, we will pass on parent from which it is called. As long as it is a Not existing node - it shows a new path.

	 */

	private static boolean dfs(UGraph graph, int src, boolean[] visited, int parent) {
		
		visited[src] = true;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				if(dfs(graph, dest, visited, src)) {
					return true;
				}
			} else {
				if(dest != parent) {
					return true;
				}
			}
		}
		
		return false;
	}
}
