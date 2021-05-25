package com.kurshit.graphs.directed.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.graphs.directed.DGraph;

/*
 * Problem : Given a Directed/Undirected Graph and two vertices in it, check whether there is a path from the first 
 * given vertex to second.
 * 
 * Solution: Same as count different paths between two vertices - using DFS and BFS
 */

public class PathBetweenTwoVertices {

	public static void main(String[] args) {
		
		PathBetweenTwoVertices p = new PathBetweenTwoVertices();
		
		DGraph graph = new DGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);				
		
		System.out.println(p.checkIfPathExistUsingDFS(graph, 1, 3));
		System.out.println(p.checkIfPathExistUsingDFS(graph, 0, 1));
		System.out.println(p.checkIfPathExistUsingDFS(graph, 0, 3));
		System.out.println(p.checkIfPathExistUsingDFS(graph, 2, 1));
		System.out.println(p.checkIfPathExistUsingDFS(graph, 1, 0));
		System.out.println(p.checkIfPathExistUsingDFS(graph, 2, 2)); // self loop -- returns wrong result
		System.out.println(p.checkIfPathExistUsingDFS(graph, 3, 1));
			
		
		System.out.println();
		
		System.out.println(p.checkIfPathExistUsingBFS(graph, 1, 3));
		System.out.println(p.checkIfPathExistUsingBFS(graph, 0, 1));
		System.out.println(p.checkIfPathExistUsingBFS(graph, 0, 3));
		System.out.println(p.checkIfPathExistUsingBFS(graph, 2, 1));
		System.out.println(p.checkIfPathExistUsingBFS(graph, 1, 0));
		System.out.println(p.checkIfPathExistUsingBFS(graph, 2, 2)); // self loop -- returns wrong result
		System.out.println(p.checkIfPathExistUsingBFS(graph, 3, 1));
	}
	
	/*
	 * Time complexity : O(V+E)
	 * Space : O(V)
	 */
	
	public boolean checkIfPathExistUsingDFS(DGraph graph, int src, int dest) {
		boolean[] visited = new boolean[graph.V];
		boolean result = pathUtil(graph, src, dest, visited);
		return result;
	}
	
	public boolean pathUtil(DGraph graph, int src, int dest, boolean[] visited) {
		
		if(src == dest) {
			return true;
		} else {
			
			Iterator<Integer> itr = graph.adjList[src].iterator();
			visited[src] = true;
			while(itr.hasNext()) {
				int v = itr.next();
				
				if(!visited[v]) {
					boolean r = pathUtil(graph, v, dest, visited);
					if(r)
						return true;					
					
				}
			}
		}
		
		return false;
	}
	
	public boolean checkIfPathExistUsingBFS(DGraph graph, int src, int dest) {
		
		boolean[] visited = new boolean[graph.V];
		
		Queue<Integer> queue = new LinkedList<>();
				
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			
			src = queue.poll();
			
			if(src == dest)
				return true;
			
			Iterator<Integer> itr = graph.adjList[src].iterator();
			
			while(itr.hasNext()) {
				int v = itr.next();
				if(!visited[v]) {
					queue.offer(v);
					visited[v] = true;
				}
			}
			
		}
		
		return false;
		
	}
}
