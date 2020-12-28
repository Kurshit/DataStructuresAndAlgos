package com.kurshit.graphs.undirected.mst;

import java.util.Arrays;

import com.kurshit.graphs.undirected.MSTGraph;
import com.kurshit.graphs.undirected.MSTGraph.Edge;
import com.kurshit.graphs.undirected.disjointset.FindUnion;


/*
 * Source : https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 * 
 *  1. Sort all the edges in non-decreasing order of their weight. 
 *	2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it. 
 *	3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 *	
 *	The step#2 uses Union-Find algorithm to detect cycle. So we recommend to read following post as a prerequisite.
 *	
 *	The algorithm is a Greedy Algorithm. The Greedy Choice is to pick the smallest weight edge that does not cause a cycle in the MST 
 * constructed so far. Let us understand it with an example: Consider the below input graph.
 */

public class Kruskals {

	public static void main(String[] args) {

		/* Let us create following weighted graph
			        10
			   0--------1
			   |  \     |
			  6|   5\   |15
			   |      \ |
			   2--------3
			       4       
		*/
		
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		MSTGraph graph = new MSTGraph(V, E);
		
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 1, 15);
		graph.addEdge(0, 3, 5);
		
		Edge[] result = findKruskalsMST(graph);
		//expected - 19
		printMSTCost(result);
		
	}

	public static Edge[] findKruskalsMST(MSTGraph graph) {

		Edge[] result = new Edge[graph.V-1];

		

		for(int i = 0; i < graph.V-1; i++)
			result[i] = new Edge();

		Arrays.sort(graph.edges);
		

		int ptr = 0;  //pointer to sorted set of edges
		int e = 0; // pointer to resultant set of edges
		int[] parent = new int[graph.V];

		for(int i =0; i < graph.V; i++) {
			parent[i] = -1;
		}

		while(e < graph.V-1) {

			Edge nextEdge = graph.edges[ptr];
			ptr++;

			int x = FindUnion.find(parent, nextEdge.src);
			int y = FindUnion.find(parent, nextEdge.dest);

			if(x != y) {
				result[e] = nextEdge;
				e++;
				FindUnion.union(parent, x, y);
			}		

		}

		return result;
	}

	public static void printMSTCost(Edge[] result) {

		int minimumCost = 0;
		for (int i = 0; i < result.length; ++i)
		{
			System.out.println(result[i].src + " -- "
					+ result[i].dest
					+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "
				+ minimumCost);
	}

}
