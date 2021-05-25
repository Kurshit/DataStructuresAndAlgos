package com.kurshit.graphs.codencode.cp3book.section42;

import java.util.Arrays;

import com.kurshit.graphs.undirected.UGraphEL;
import com.kurshit.graphs.undirected.UGraphEL.Edge;
import com.kurshit.graphs.undirected.disjointset.FindUnion;

/*
 * CP3 Book Ref : Section 4.2.3 : Excercise 4.2.3.1  Finding Conneted Components (Undirected Graph) 
 * 
 * Problem : Given a graph in Edge List array, find number of connected components using Disjoint Set DS.
 * 
 * 
 */

public class NumberOfConnectedComponentsUsingDisjointSet {

	public static void main(String[] args) {

		UGraphEL graph = new UGraphEL(8, 7);
				
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(1, 7);
		graph.addEdge(4, 5);
		graph.addEdge(5, 7);
		graph.addEdge(3, 5);
		graph.addEdge(2, 6);

		//Expected - 2
		System.out.println(getConnectedComponentsUsingDisjointSet(graph));
		
		

	}

	private static int getConnectedComponentsUsingDisjointSet(UGraphEL graph) {
		
		int result = 0;
		
		int[] parent = new int[graph.V];
		
		Arrays.fill(parent, -1);
		
		for(int i=0; i < graph.E; i++) {
			
			Edge edge = graph.edges[i];
			
			int x = FindUnion.find(parent, edge.src);
			int y = FindUnion.find(parent, edge.dest);
			
			if(x != y) {
				FindUnion.union(parent, x, y);
			}
		}
		
		for(int i : parent) {
			if(i == -1) {
				result++;
			}
		}
		
		
		return result;
	}

	
}
