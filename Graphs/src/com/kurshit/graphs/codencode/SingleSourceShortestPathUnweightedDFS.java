
package com.kurshit.graphs.codencode;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Problem Source : https://www.youtube.com/watch?v=CCrwMjQiZHg&list=PL2q4fbVm1Ik6DCzm9XZJbNwyHtHGclcEh&index=6&ab_channel=CodeNCode
 * 
 * Problem : This is for unweighted, undirected graph. 
 * 
 * Solution : DFS
 */

public class SingleSourceShortestPathUnweightedDFS {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		int[] dist = getShortestPathToAllVerticesFromGivenSrc(graph, 0);
		
		for(int i=0; i < dist.length; i++) {
			System.out.println("Dest : " + i + " Disstance " + dist[i]);
		}
	}
	
	public static int[] getShortestPathToAllVerticesFromGivenSrc(UGraph graph, int src) {
		
		boolean[] visited = new boolean[graph.V];
		int[] dist = new int[graph.V];
		int currDist = 0;
		dfs(graph, visited, src, dist, currDist);
		
		return dist;
	}
	
	public static void dfs(UGraph graph, boolean[] visited, int src, int[] dist, int currDist) {
		
		visited[src] = true;
		
		dist[src] = currDist;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, visited, dest, dist, currDist + 1);
			}
		}
	}

}
