package com.kurshit.graphs.undirected.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Source : https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
 * Problem: Given a tree represented as undirected graph. 
 * Count the number of nodes at given level l. It may be assumed that vertex 0 is root of the tree.
 * 
 * This is basically a n-ary tree
 */

public class NodesAtGivenLevel {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(7);
		
		/*
		 *     
		 *     			 0         Level 0
					   /   \ 
					  1     2      Level 1
					/ |\    |
					3 4 5   6      Level 2
		 */
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 6);
		
		int src = 0;
		int targetLevel = 2;
		System.out.println(getCountOfNodesAtGivenLevelBFS(graph, src, targetLevel));
		System.out.println(getCountOfNodesAtGivenLevelDFS(graph, src, targetLevel));
		

	}
	
	public static int getCountOfNodesAtGivenLevelBFS(UGraph graph, int src, int targetLevel) {
		
		boolean[] visited = new boolean[graph.V];
		
		int[] levels = new int[graph.V];
		
		levels[src] = 0;
		visited[src] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			src = queue.poll();
			
			visited[src] = true;
			Iterator<Integer> itr = graph.adjList[src].iterator();
			
			while(itr.hasNext()) {
				int newNode = itr.next();
				if(!visited[newNode]) {
					queue.offer(newNode);
					
					levels[newNode] = levels[src] + 1;
				}
			}			
		}
		int count = 0;
		for(int i =0; i < levels.length; i++) {
			if(levels[i] == targetLevel) {
				count++;
			}
		}
		
		return count;
	}
	
	public static int getCountOfNodesAtGivenLevelDFS(UGraph graph, int src, int targetLevel ) {
		boolean[] visited = new boolean[graph.V];
		int[] dist = new int[graph.V];
		int currDist = 0;
		dfs(graph, src, visited, dist, currDist);
		
		int count = 0;
		
		for(int i=0; i < dist.length; i++) {
			if(dist[i] == targetLevel)
				count++;
		}
		return count;
	}

	private static void dfs(UGraph graph, int src, boolean[] visited, int[] dist, int currDist) {
		
		visited[src] = true;
		dist[src] = currDist;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				dfs(graph, dest, visited, dist, dist[src] + 1);
			}
		}
		
	}
	

}
