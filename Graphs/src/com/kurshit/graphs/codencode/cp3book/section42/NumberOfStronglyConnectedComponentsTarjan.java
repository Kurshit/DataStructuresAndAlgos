package com.kurshit.graphs.codencode.cp3book.section42;

import java.util.Arrays;
import java.util.Stack;

import com.kurshit.graphs.directed.DGraph;

public class NumberOfStronglyConnectedComponentsTarjan {
	
	public static void main(String[] args) {
		
		int V = 5;
		DGraph graph = new DGraph(V);
		
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		
		System.out.println(getSCCComponents(graph, V));
		
		
	}
	
	public static int result = 0;
	
	public static int getSCCComponents(DGraph graph, int V) {
		result = 0;
		int[] disc = new int[V]; // Discovery Time array
		int[] low = new int[V]; // Nearest node with earliest discovery time
		
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		
		boolean[] stackMember = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i < V; i++) {
			if(disc[i] == -1) {
				sccUtil(graph, i, disc, low, stackMember, stack);
			}
		}
		
		return result;
	}

	public static int timer = 0;
	private static void sccUtil(DGraph graph, int src, int[] disc, int[] low, boolean[] stackMember,
			Stack<Integer> stack) {
		
		disc[src] = timer;
		low[src] = timer;
		timer += 1;
		stackMember[src] = true;
		stack.push(src);
						
		for(int dest : graph.adjList[src]) {
			
			if(disc[dest] == -1) {
				sccUtil(graph, dest, disc, low, stackMember, stack);
				
				low[src] = Math.min(low[src], low[dest]);
			} else if(stackMember[dest]){
				low[src] = Math.min(low[src], disc[dest]);
			}
		}
		int head = -1;
		if(low[src] == disc[src]) {
			
			result++;
			while(head != src) {
				head = stack.pop();
				System.out.print(head + " ");
				stackMember[head] = true;
			}
			
			System.out.println();
		}	
		
	}	
}
