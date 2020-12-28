package com.kurshit.graphs.codencode;

/*
 * Problem Source : https://www.geeksforgeeks.org/diameter-tree-using-dfs/
 * 
 * 
 * 
 */

import java.util.Arrays;

import com.kurshit.graphs.undirected.UGraph;

public class DiamaterOfATree {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		
		System.out.println(getDiameterOfTree(graph));
		
	}
	
	public static int getDiameterOfTree(UGraph graph) {
		
		boolean[] visited = new boolean[graph.V];
		int[] dist = new int[graph.V];
		int currDist = 0;
		int src = 0;
		dfs(graph, src,visited, dist, currDist);
		
		int farthestNode = -1;
		int maxDist = Integer.MIN_VALUE;
		for(int i=0; i < dist.length; i++) {
			if(dist[i] > maxDist) {
				maxDist = dist[i];
				farthestNode = i;
			}
		}
		
		Arrays.fill(dist, 0);
		Arrays.fill(visited, false);
		currDist = 0;
		dfs(graph, farthestNode, visited, dist, currDist);
		
		maxDist = Integer.MIN_VALUE;
		for(int i=0; i < dist.length; i++) {
			if(dist[i] > maxDist) {
				maxDist = dist[i];
				farthestNode = i;
			}
		}
		
		return maxDist;
	}

	private static void dfs(UGraph graph, int src, boolean[] visited, int[] dist, int currDist) {
		
		visited[src] = true;
		dist[src] = currDist;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited, dist, currDist+1);
			}
		}
		
	}

}
