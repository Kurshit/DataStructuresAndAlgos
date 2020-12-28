package com.kurshit.graphs.directed.connectivity;

import java.util.Arrays;

import com.kurshit.graphs.directed.DGraph;

public class IsStronglyConnected {

	public static void main(String[] args) {
		
		DGraph graph = new DGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 0);
		graph.addEdge(4, 2);
		
		System.out.println(isStronglyConnected(graph));
		

	}

	public static boolean isStronglyConnected(DGraph graph) {
		
		boolean[] visited = new boolean[graph.V];
		
		dfs(graph, 0, visited);
		
		for(int i=0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		DGraph tGraph = getTranspose(graph);
		
		Arrays.fill(visited, false);
		
		dfs(tGraph, 0, visited);
		
		for(int i=0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		return true;
	}

	private static DGraph getTranspose(DGraph graph) {
	
		DGraph newGraph = new DGraph(graph.V);
		
		for(int i=0; i < graph.V; i++) {
			for(int dest : graph.adjList[i]) {
				newGraph.addEdge(dest, i);
			}
		}
		return newGraph;
	}

	private static void dfs(DGraph graph, int src, boolean[] visited) {
		
		visited[src] = true;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited);
			}
		}
		
	}
	
	/*
	 * Following overloaded method is for StringChainCircle problem with extra marked array
	 */
	
public static boolean isStronglyConnected(DGraph graph, int src, boolean[] marked) {
		
		boolean[] visited = new boolean[graph.V];
		
		dfs(graph, src, visited);
		
		for(int i=0; i < visited.length; i++) {
			if(marked[i] && !visited[i]) {
				return false;
			}
		}
		
		DGraph tGraph = getTranspose(graph);
		
		Arrays.fill(visited, false);
		
		dfs(tGraph, src, visited);
		
		for(int i=0; i < visited.length; i++) {
			if(marked[i] && !visited[i]) {
				return false;
			}
		}
		
		return true;
	}
	

}
