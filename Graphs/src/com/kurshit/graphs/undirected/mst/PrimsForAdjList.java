package com.kurshit.graphs.undirected.mst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.kurshit.graphs.undirected.mst.UGraphPrims.UNode;

public class PrimsForAdjList {

	public static void main(String[] args) {

//		int graph[][] = new int[][] { 
//			{ 0, 2, 0, 6, 0 },			
//			{ 2, 0, 3, 8, 5 }, 
//			{ 0, 3, 0, 0, 7 }, 
//			{ 6, 8, 0, 0, 9 }, 
//			{ 0, 5, 7, 9, 0 } 
//		};
		
		UGraphPrims graph = new UGraphPrims(5);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 0, 2);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 8);
		graph.addEdge(1, 4, 5);
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 4, 7);
		graph.addEdge(3, 0, 6);
		graph.addEdge(3, 1, 8);
		graph.addEdge(3, 4, 9);
		graph.addEdge(4, 1, 5);
		graph.addEdge(4, 2, 7);
		graph.addEdge(4, 3, 9);
		
		//expected - 16
		System.out.println(primsMSTAdjList(graph));

//		int graph1[][] = new int[][] { 
//			{ 0, 10, 6, 5 },			
//			{ 10, 0, 0, 15 }, 
//			{ 6, 0, 0, 4 }, 
//			{ 5, 15, 4, 0 }            
//		};
		
		UGraphPrims graph1 = new UGraphPrims(4);
		graph1.addEdge(0, 1, 10);
		graph1.addEdge(0, 2, 6);
		graph1.addEdge(0, 3, 5);
		graph1.addEdge(1, 0, 10);
		graph1.addEdge(1, 3, 15);
		graph1.addEdge(2, 0, 6);
		graph1.addEdge(2, 3, 4);
		graph1.addEdge(3, 0, 5);
		graph1.addEdge(3, 1, 15);
		graph1.addEdge(3, 2, 4);
		
		//expected - 19
		System.out.println(primsMSTAdjList(graph1));

	}

	public static int primsMSTAdjList(UGraphPrims graph) {
		
		boolean[] mstSet = new boolean[graph.V];
		PrimsPair[] pairsArray = new PrimsPair[graph.V];
		int[] parent = new int[graph.V];
		
		for(int i=0; i < graph.V; i++) {
			pairsArray[i] = new PrimsPair();
			pairsArray[i].dist = Integer.MAX_VALUE;		
			pairsArray[i].vertex = i;  // assign vertexes from 0 to V-1
		}
		
		mstSet[0] = true;
		pairsArray[0].dist = 0;
		
		PriorityQueue<PrimsPair> queue = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);
		
		for(int i=0; i < graph.V; i++) {
			queue.offer(pairsArray[i]);
		}
		
		
		while(!queue.isEmpty()) {
			PrimsPair sourcePair = queue.poll();
			
			mstSet[sourcePair.vertex] = true;
			
			Iterator<UNode> itr = graph.adjList[sourcePair.vertex].iterator();
			
			while(itr.hasNext()) {
				
				UNode destPair = itr.next();
				
				if(!mstSet[destPair.dest]) {
					if(pairsArray[destPair.dest].dist > destPair.weight) {
						pairsArray[destPair.dest].dist = destPair.weight;
						queue.offer(pairsArray[destPair.dest]);
						parent[destPair.dest] = sourcePair.vertex; 
					}
				}
				
			}
		}
		
		
		int minMstSum = 0;
		
		for(PrimsPair pair : pairsArray) {
			minMstSum = minMstSum + pair.dist;
		}
		
		return minMstSum;
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

class UGraphPrims {
	
	public List<UNode>[] adjList;
	public int V;
	
	public UGraphPrims(int V) {
		this.V = V;
		adjList = new List[V];
		for(int i=0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		
		adjList[src].add(new UNode(dest, weight));
		adjList[dest].add(new UNode(src, weight));
	}
	
	public class UNode {
		int dest;
		int weight;
		
		public UNode(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
	}
}

class PrimsPair {
	public int dist;
	public int vertex;
}