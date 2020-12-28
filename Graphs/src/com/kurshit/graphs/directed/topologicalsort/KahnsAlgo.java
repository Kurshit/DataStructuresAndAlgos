package com.kurshit.graphs.directed.topologicalsort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.graphs.directed.DGraph;
import com.kurshit.graphs.directed.DGraphWithW;
import com.kurshit.graphs.directed.DGraphWithW.DPair;

public class KahnsAlgo {

	public static void main(String[] args) {
			
		DGraph graph = new DGraph(6);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		
		int[] result = kahnsAlgo(graph, 6);
		
		System.out.println(Arrays.toString(result));

	}
	
	public static int[] kahnsAlgo(DGraph graph, int V) {
		
		int[] indegree = Indegree.getIndegreeOfNodes(graph);
		
		Queue<Integer> queue  = new LinkedList<>();
		
		for(int i = 0; i < indegree.length ; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0;
		int[] result = new int[graph.V];
		int resultPtr = 0; 
		while(!queue.isEmpty()) {
			
			int currNode = queue.poll();
			result[resultPtr] = currNode;
			resultPtr++;
			for(int dest : graph.adjList[currNode]) {
				indegree[dest]--;
				
				if(indegree[dest] == 0) {
					queue.offer(dest);
				}
			}
			
			count++;
			
		}
		
		if(count != graph.V) {
			return new int[] {};
		}
		
		return result;
		
		
	}
	
	/*
	 * Following is overloaded method for Directed Graph with Edges
	 */
	
	
	public static int[] kahnsAlgo(DGraphWithW graph, int V) {
		
		int[] indegree = Indegree.getIndegreeOfNodes(graph);
		
		Queue<Integer> queue  = new LinkedList<>();
		
		for(int i = 0; i < indegree.length ; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0;
		int[] result = new int[graph.V];
		int resultPtr = 0; 
		while(!queue.isEmpty()) {
			
			int currNode = queue.poll();
			result[resultPtr] = currNode;
			resultPtr++;
			for(DPair pair : graph.adjList[currNode]) {
				indegree[pair.dest]--;
				
				if(indegree[pair.dest] == 0) {
					queue.offer(pair. dest);
				}
			}
			
			count++;
			
		}
		
		if(count != graph.V) {
			return new int[] {};
		}
		
		return result;
		
		
	}
}
