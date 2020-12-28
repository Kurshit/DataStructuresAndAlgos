package com.kurshit.graphs.undirected;

public class MSTGraph {
	
	public int V, E;
	public Edge[] edges;
	int size = 0;
	
	public static class Edge implements Comparable<Edge> {
		public int src, dest;
		public int weight;
		
		@Override
		public int compareTo(Edge comparableEdge) {
			// TODO Auto-generated method stub
			return this.weight - comparableEdge.weight;
		}
		
	}
	
	public void addEdge(int src, int dest, int weight) {
		
		if(size == E) 
			return;
		
		edges[size].src = src;
		edges[size].dest = dest;
		edges[size].weight = weight;
		size++;
	}


	public MSTGraph(int V, int E) {
			this.V = V;
			this.E = E;
			edges = new Edge[E];
			 
			for(int i =0; i < E; i++)
				edges[i] = new Edge();
	}

}
