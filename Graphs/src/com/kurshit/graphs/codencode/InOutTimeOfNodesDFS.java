package com.kurshit.graphs.codencode;

import java.util.Arrays;

import com.kurshit.graphs.undirected.UGraph;

public class InOutTimeOfNodesDFS {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		
		printInOutTime(graph);
		

	}
	static int timer = 1;
	public static void printInOutTime(UGraph graph) {
		int[] in = new int[graph.V];
		int[] out = new int[graph.V];
		boolean[] visited  = new boolean[graph.V];
		
		for(int i=0; i < graph.V; i++) {
			if(!visited[i]) {
				dfs(graph, i, visited, in, out);
			}
		}
		
		System.out.println(Arrays.toString(in));
		System.out.println(Arrays.toString(out));
	}

	private static void dfs(UGraph graph, int src, boolean[] visited, int[] in, int[] out) {
		
		in[src] = timer++;
		
		visited[src] = true;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest])
				dfs(graph, dest, visited, in, out);
		}
		
		out[src] = timer++;
	}

}
