package com.kurshit.graphs.codencode.cp3book.section42;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.graphs.undirected.UGraph;

/*
 * CP3 Book Ref : Section 4.2.3 Finding Conneted Components (Undirected Graph)
 * 
 * Problem : Given a graph in adjacency list, find number of connected components
 * 
 * Solution: 
 * 1. Using DFS
 * 2. Using BFS
 */

public class NumberOfConnectedComponents {

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
		System.out.println(getConnectedComponentsUsingDFS(graph));
		
		//Expected - 2
		System.out.println(getConnectedComponentsUsingBFS(graph));

	}

	private static int getConnectedComponentsUsingDFS(UGraph graph) {

		int result = 0;

		boolean[] visited = new boolean[graph.V];

		for(int i=0; i < graph.V; i++) {

			if(!visited[i]) {
				dfs(graph, i, visited);
				result++;
			}
		}		

		return result;
	}

	public static void dfs(UGraph graph, int src, boolean[] visited) {

		visited[src] = true;

		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited);
			}
		}
	}

	private static int getConnectedComponentsUsingBFS(UGraph graph) {

		int result = 0;

		boolean[] visited = new boolean[graph.V];

		for(int i=0; i < graph.V; i++) {

			if(!visited[i]) {
				bfs(graph, i, visited);
				result++;
			}
		}		

		return result;
	}
	
	public static void bfs(UGraph graph, int src, boolean[] visited) {
			
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while(!q.isEmpty()) {
			src = q.poll();
			visited[src] = true;
			
			for(int dest : graph.adjList[src]) {
				if(!visited[dest]) {
					q.offer(dest);
				}
				
			}
		}
		
	}
}
