//package com.kurshit.graphs.directed.topologicalsort;
//
//import java.util.Arrays;
//
///*
// * Problem source : https://www.geeksforgeeks.org/longest-path-between-any-pair-of-vertices/
// * 
// * Problem: We are given a map of cities connected with each other via cable lines such that there is no cycle between any 
// * two cities. We need to find the maximum length of cable between from a give  source vertex.
// * 
// * Input : n = 6  , source = 2
//        1 2 3  // Cable length from 1 to 2 (or 2 to 1) is 3
//        2 3 4
//        2 6 2
//        6 4 6
//        6 5 5
//	Output: maximum length of cable = 12
//	
//	Note : This is different from undirected example where in source vertex if not given and we wish to find max path amongst all nodes.
//	Here source vertex is given as input
// */
//
//
//import java.util.Iterator;
//import com.kurshit.graphs.directed.DGraphWithW;
//import com.kurshit.graphs.directed.DGraphWithW.DPair;
//import com.kurshit.graphs.undirected.UGraphWithW;
//import com.kurshit.graphs.undirected.UGraphWithW.UPair;
//
//public class DirectedLongestPathBetweenAnyPairOfVertices2 {
//
//	public static void main(String[] args) {
//		int V = 6;
//		DGraphWithW graph = new DGraphWithW(V);  // this is edge list with weights
//	
//		graph.addEdge(0, 1, 3);
//		graph.addEdge(1, 2, 4);
//		graph.addEdge(1, 5, 2);
//		graph.addEdge(5, 3, 6);
//		graph.addEdge(5, 4, 5);
//		
//		int sourceVertex = 2;
//		System.out.println(getLongestPath(graph, sourceVertex));
//		
//
//	}	
//	
//	/*
//	 *  Solution Approach: Using DFS algo for undirceted graph.
//	 *  We create undirected graph for given city map and do DFS from every city to find maximum length of cable. 
//	 *  While traversing, we look for total cable length to reach the current city and if it’s adjacent city is not visited 
//	 *  then call DFS for it but if all adjacent cities are visited for current node, then update the value of max_length if 
//	 *  previous value of max_length is less than current value of total cable length
//	 *  
//	 */
//	
//	/*
//	 * Another solution could be to find Maximum Spanning Tree instead of Min Spanning Tree for this graph.
//	 * But min Spanning tree is Undirected and Connected But not TREE initially. ? 
//	 * 
//	 */
//	
//	public static int getLongestPath(DGraphWithW graph, int sourceVertex) {
//		
//		DResult r = new DResult();
//		r.maxLength = Integer.MIN_VALUE;		
//		
//		int[] dist = new int[graph.V];
//		Arrays.fill(dist, Integer.MIN_VALUE);
//		dist[sourceVertex] = 0;
//		
//		int[] topologicalOrder = KahnsAlgo.kahnsAlgo(graph, graph.V);
//		
//		//for(int i = 0; i < topologicalOrder.length; i++) {
//			
//			for(DPair pair : graph.adjList[sourceVertex]) {
//				if(dist[pair.dest] < dist[sourceVertex] + pair.weight) {
//					dist[pair.dest] = dist[sourceVertex] + pair.weight;
//				}
//			}
//		//}
//		
//		System.out.println("Distances from every vertices to other are : ");
//		int maxDistance = Integer.MIN_VALUE;
//		for(int i =0; i < dist.length; i++) {
//			System.out.println( i + " ---> " + dist[i]);
//			maxDistance = Math.max(maxDistance, dist[i]);
//		}
//		
//		return maxDistance;
//	}
//	/*
//	 * prevLength is sum of cable lengths till current node
//	 */
//	
//	private static void dfs(UGraphWithW graph, int src, int prevLength, boolean[] visited, DResult r) {
//		
//		visited[src] = true;
//		int curLength = 0;
//		
//		Iterator<UPair> itr = graph.adjList[src].iterator();
//		
//		while(itr.hasNext()) {
//			UPair adjacent = itr.next();
//			
//			if(!visited[adjacent.dest]) {
//				curLength = prevLength + adjacent.weight;
//				dfs(graph, adjacent.dest, curLength, visited, r);
//			}
//			
//			if(r.maxLength < curLength) {
//				r.maxLength = curLength;
//			}
//			
//			curLength = 0;
//			
//		}
//		
//	}
//
//}
//
//class DResult {
//	int maxLength;
//}