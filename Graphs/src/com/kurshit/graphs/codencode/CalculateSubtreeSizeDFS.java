package com.kurshit.graphs.codencode;

import java.util.Arrays;

import com.kurshit.graphs.undirected.UGraph;

/*
 * Problem source : https://www.youtube.com/watch?v=rFVKXZZMH-U&list=PL2q4fbVm1Ik6DCzm9XZJbNwyHtHGclcEh&index=16&ab_channel=CodeNCode
 * Problem : Given a tree, construct an array which contains size of subtree rooted at node V.
 * 
 * Example: 
 * 
 * 					0
 * 				 /     
 * 			    1	
 * 			 /    \
 * 		   2       3
 * 
 *  Ans : 
 *  
 *  	subArray[0] = 4
 *  	subArray[1] = 3
 *  	subArray[2] = 1
 *      subArray[3] = 1
 * 
 */

public class CalculateSubtreeSizeDFS {

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		int[] result = getSubtreeSize(graph);
		
		System.out.println(Arrays.toString(result));

	}
	
	/*
	 * We will call a DFS starting from root/src. The DFS will futher be called on adjacent nodes of all src nodes. 
	 * DFS will end at the Leaf node. This will then return the size 1 since it is the only node. These will be further passed on
	 * to parent nodes and accumulated.
	 * We will start from top to bottom and hence will keep track of visited[] to not visit one node more than once.
	 *   
	 */
	
	public static int[] getSubtreeSize(UGraph graph) {
		boolean[] visited = new boolean[graph.V];
		int[] subArray = new int[graph.V];
		
		dfs(graph, 0, visited, subArray);
		
		return subArray;
		
	}

	private static int dfs(UGraph graph, int src, boolean[] visited, int[] subArray) {
			
		visited[src] = true;
		int currSize = 1;
		
		for(int dest : graph.adjList[src]) {
			if(!visited[dest]) {
				currSize = currSize + dfs(graph, dest, visited, subArray);
			}
		}
		
		subArray[src] = currSize;
		return currSize;
	}
}
