package com.kurshit.graphs.undirected.dijkstras;

/*
 * Problem : Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.
 * 
 * Algorithm
	1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
	2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. Assign distance value as 0 for the source vertex so that it is picked first.
	3) While sptSet doesn’t include all vertices
		….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
		….b) Include u to sptSet.
		….c) Update distance value of all adjacent vertices of u. 
		 To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
 * 
 * Solution Ref : https://www.youtube.com/watch?v=Sj5Z-jaE2x0
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 */

public class DijkstraShortestPath {
	static final int V = 9;
	
	public static void main(String[] args) {
		
		//Ref this for diagram https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
		
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            
         DijkstraShortestPath d = new DijkstraShortestPath();
         
         int[] dist = d.getShortestPath(graph, 0);
         int dest = 8;
         System.out.println("Shortest path between 0 and " + dest + " is "  + d.getShortestPathBetweenTwo(dist, dest));
         d.printSolution(dist);

	}
	
	public int[] getShortestPath(int[][] graph, int src) {
		int[] dist = new int[V];
		
		boolean[] sptSet = new boolean[V];  // shortest path tree set
		
		for(int i=0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		for(int i = 0; i < V-1; i++) {
			int u = minDIstance(dist, sptSet);
			sptSet[u] = true;
			
			for(int v =0; v < V; v++) {
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		return dist;
	}
	
	private int minDIstance(int[] dist, boolean[] sptSet) {
		
		int min = Integer.MAX_VALUE, minIndex = -1;
		
		for(int v =0; v < V; v++) {
			if(!sptSet[v] && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		
		return minIndex;
	}
	
	void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
	
	public int getShortestPathBetweenTwo(int[] dist, int dest) {
		
		return dist[dest];
		
	}

}
