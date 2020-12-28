package com.kurshit.graphs.undirected.mst;

/*
 * Solution Ref : https://www.youtube.com/watch?v=xthRL0lcx2w&t=1329s&ab_channel=TECHDOSE 
 */

public class PrimsForMatrix {

	public static void main(String[] args) {

		int graph[][] = new int[][] { 
			{ 0, 2, 0, 6, 0 },			
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 }, 
			{ 0, 5, 7, 9, 0 } 
		};
		//expected - 16
		System.out.println(primsMST(graph));

		int graph1[][] = new int[][] { 
			{ 0, 10, 6, 5 },			
			{ 10, 0, 0, 15 }, 
			{ 6, 0, 0, 4 }, 
			{ 5, 15, 4, 0 }            
		};
		//expected - 19
		System.out.println(primsMST(graph1));

	}

	public static int primsMST(int[][] graph) {

		int[] parent = new int[graph.length];
		boolean[] mstSet = new boolean[graph.length];
		int V = graph.length;
		int[] dist = new int[graph.length];	

		for(int i = 0; i < graph.length; i++ ) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[0] = 0;
		parent[0] = -1;

		//mind the V-1 here below
		for(int count = 0; count < V - 1; count++) {
			int u = minDistNode(dist, mstSet);  // this is index of smallest key

			mstSet[u] = true;

			for(int v=0; v < V; v++) {
				if(graph[u][v] != 0 && !mstSet[v] && graph[u][v] < dist[v]) {
					parent[v] = u;
					dist[v] = graph[u][v];
				}
			}			
		}

		//find min weight
		int sum = 0;
		for(int i : dist) {
			sum = sum + i;
		}

		return sum;
	}

	private static int minDistNode(int[] dist, boolean[] mstSet) {

		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for(int v=0; v < dist.length; v++) {
			if(!mstSet[v] && dist[v] < min) {
				min = dist[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

}
