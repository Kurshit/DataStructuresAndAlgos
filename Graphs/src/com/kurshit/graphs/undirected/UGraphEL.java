package com.kurshit.graphs.undirected;

public class UGraphEL {
	
	public int V, E;
	
	private int size = 0;
	
	public Edge[] edges;
		
	public class Edge {
		public int src, dest;
		public int weight;
	}
	
	public UGraphEL(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new Edge[this.E];
		
		for(int i=0; i<this.E; i++)
			edges[i] = new Edge();
	}
	
	public void addEdge(int src, int dest) {
		
		if(size == E) 
			return;
		
		edges[size].src = src;
		edges[size].dest = dest;
		size++;
	}
	
	public void addEdge(int src, int dest, int weight) {
		
		if(size == E) 
			return;
		
		edges[size].src = src;
		edges[size].dest = dest;
		edges[size].weight = weight;
		size++;
	}

}


