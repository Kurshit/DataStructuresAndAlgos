package com.kurshit.graphs.undirected.disjointset;

import com.kurshit.graphs.undirected.UGraphEL;
import static com.kurshit.graphs.undirected.disjointset.FindUnion.find;
import static com.kurshit.graphs.undirected.disjointset.FindUnion.union;

/*
 * This checks if unidrected graph has cycle in it or no using disjoint set data structure and union-find algorithm
 */

public class HasCycleUndirected {

	public static void main(String[] args) {
		
		/* Let us create the following graph 
        0 
        | \ 
        |  \ 
        1---2 
        
        */
		
		UGraphEL graph = new UGraphEL(4, 3);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 1);
		
		System.out.println(hasCycle(graph));
		

	}
	
	public static boolean hasCycle(UGraphEL graph) {
		int[] parent = new int[graph.V];
		
		for(int i =0; i < graph.V; i++) {
			parent[i] = -1;
		}
		
		for(int i =0; i < graph.E; i++) {
			int x = find(parent, graph.edges[i].src);
			int y = find(parent, graph.edges[i].dest);
			
			if(x == y)
				return true;
			
			union(parent, x, y);
		}
		
		return false;
	}

}
