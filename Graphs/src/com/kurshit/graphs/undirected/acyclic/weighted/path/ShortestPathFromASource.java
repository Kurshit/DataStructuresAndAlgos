package com.kurshit.graphs.undirected.acyclic.weighted.path;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem : Given an undirected and weighted graph, and a source Node, find the shortest / smallest path and print the dest vertex.
 * 
 *  This is same as "LongestPathFromASource" code, except in the end, we will find min element out of dist array.4
 *  
 *  Note : In this case, shortest path is always going to be the shortest path upto the next node from source and not beyond.
 *  If source has multiple adjacent nodes, the one with min distance is the ans
 */

import com.kurshit.graphs.undirected.UGraphWithW;
import com.kurshit.graphs.undirected.UGraphWithW.UPair;

public class ShortestPathFromASource {

	public static void main(String[] args) {

		int V = 6;
		UGraphWithW graph = new UGraphWithW(V);  // this is edge list with weights

		graph.addEdge(0, 1, 3);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 5, 2);
		graph.addEdge(5, 3, 6);
		graph.addEdge(5, 4, 5); 

		/*
		 * 					1
		 * 				3 /	|	\4	
		 *              /   |     \
		 *             0    5       2
		 *                5/  \6
		 *               /     \
		 *             4        3
		 *             
		 */
		// Expected - 11
		int src = 0;
		System.out.println("Using DFS from src " + src +" : " + getShortestPathFromASourceDFS(graph, src));
		System.out.println("Using BFS from src " + src +" : " + getShortestPathFromASourceBFS(graph, src));

		System.out.println();

		//expected - 12
		src = 5;
		System.out.println("Using DFS from src " + src +" : " +getShortestPathFromASourceDFS(graph, src));
		System.out.println("Using BFS from src " + src +" : " +getShortestPathFromASourceBFS(graph, src));
	}

	/*
	 * Approach 1 : Using DFS
	 */
	public static int getShortestPathFromASourceDFS(UGraphWithW graph, int src) {

		boolean[] visited = new boolean[graph.V];

		int[] dist = new int[graph.V];
		dfs(graph, src, visited, dist, 0);
		int maxDist = Integer.MAX_VALUE;
		for(int i = 0; i < dist.length; i++) {
			if(i == src)
				continue;
			maxDist = Math.min(maxDist, dist[i]);
		}
		return maxDist;
	}

	private static void dfs(UGraphWithW graph, int src, boolean[] visited, int[] dist, int currDist) {

		visited[src] = true;

		dist[src] = currDist;

		for(UPair pair : graph.adjList[src]) {
			if(!visited[pair.dest]) {
				dfs(graph, pair.dest, visited, dist, currDist + pair.weight);
			}
		}		
	}	


	/*
	 * Approach 2 : Using BFS
	 */

	public static int getShortestPathFromASourceBFS(UGraphWithW graph, int src) {

		int[] dist = new int[graph.V];

		bfs(graph, src, dist, 0);

		int maxDist = Integer.MAX_VALUE;

		for(int i = 0; i < dist.length; i++) {
			if(i == src)
				continue;
			maxDist = Math.min(maxDist, dist[i]);
		}
		return maxDist;
	}

	private static void bfs(UGraphWithW graph, int src, int[] dist, int i) {

		boolean[] visited = new boolean[graph.V];

		Queue<UPair> queue = new LinkedList<>();
		queue.offer(new UPair(src, 0));
		dist[src] = 0;

		while(!queue.isEmpty()) {

			UPair u = queue.poll();

			visited[u.dest] = true;

			for(UPair pair : graph.adjList[u.dest]) {
				if(!visited[pair.dest]) {					
					dist[pair.dest] = dist[u.dest] + pair.weight;
					queue.offer(pair);
				}
			}

		}

	}

}

