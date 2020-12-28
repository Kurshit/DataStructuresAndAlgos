package com.kurshit.graphs.codencode;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Problem Source : https://www.youtube.com/watch?v=60yo4vvRU5s&list=PL2q4fbVm1Ik6DCzm9XZJbNwyHtHGclcEh&index=17&ab_channel=CodeNCode
 * 
 * Problem : This is for unweighted, undirected graph. 
 * 
 * Solution : BFS
 */

public class SingleSourceShortestPathUnweightedBFS {

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
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		dist[src] = 0;
		while(!queue.isEmpty()) {
			int u = queue.poll();
			visited[src] = true;
			for(int dest : graph.adjList[u]) {
				if(!visited[dest]) {
					visited[dest] = true;
					dist[dest] = dist[u] +1;  
					queue.offer(dest);
				}
			}
		}
		
		return dist;
	}	
	
}
