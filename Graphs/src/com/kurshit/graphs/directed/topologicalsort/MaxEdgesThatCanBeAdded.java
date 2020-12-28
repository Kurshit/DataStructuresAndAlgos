package com.kurshit.graphs.directed.topologicalsort;

import com.kurshit.graphs.directed.DGraph;

/*
 * Problem Source : https://www.geeksforgeeks.org/maximum-edges-can-added-dag-remains-dag/
 * 
 * Problem : A DAG is given to us, we need to find maximum number of edges that can be added to this DAG, after which new graph still remain a DAG that means the reformed graph should have maximal number of edges, adding even single edge will create a cycle in graph.
	
	Print all such edges and count of those edges

 */

public class MaxEdgesThatCanBeAdded {
	
	public static void main(String[] args) {
		
		DGraph graph = new DGraph(6);
		
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		
		int count =  maxEdgesThatCanBeAdded(graph);
		
		System.out.println();
		System.out.println("Total edges that can be added are : " + count);
		
	}
	
	/*
	 * Solution : 
	 * 
	 *  First take the topological sorting order of given graph. We sort all our nodes in topological order and create edges 
	 *  from node to all nodes to the right if not there already. 
	 *	How can we say that, it is not possible to add any more edge? the reason is we have added all possible edges from left to 
	 *  right and if we want to add more edge we need to make that from right to left, but adding edge from right to left we surely 
	 *  create a cycle because its counter part left to right edge is already been added to graph and creating cycle is not what 
	 *  we needed. 
	 *	So solution proceeds as follows, we consider the nodes in topological order and if any edge is not there from left 
	 *  to right, we will create it. 
	 */
	
	public static int maxEdgesThatCanBeAdded(DGraph graph) {
		int[] topologicalOrder = KahnsAlgo.kahnsAlgo(graph, graph.V);
		int count = 0;
		boolean[] visited = new boolean[graph.V];
		
		for(int i=0; i < topologicalOrder.length; i++) {
			int t = topologicalOrder[i];
			
			for(int nextNode : graph.adjList[t]) {
				visited[nextNode] = true;
			}
			
			for(int j = i+1 ; j  < topologicalOrder.length; j++) {
				
				if(!visited[topologicalOrder[j]]) {
					System.out.println(t + " - " + topologicalOrder[j]);
					count++;
				}
				//not sure of this line
				visited[topologicalOrder[j]] = false;
			}
		}
		
		return count;
	}
}
