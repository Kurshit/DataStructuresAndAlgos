package com.kurshit.graphs.directed.topologicalsort;

import java.util.ArrayList;
import java.util.List;

import com.kurshit.graphs.directed.DGraph;

public class PrintAllTopologicalSorting {

	public static void main(String[] args) {
		
		DGraph graph = new DGraph(6);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		
		printAllTopologicalSorts(graph);

	}
	
	public static void printAllTopologicalSorts(DGraph graph) {
		
		List<Integer> resultList = new ArrayList<>();
		boolean[] visited = new boolean[graph.V];
		int[] indegree = Indegree.getIndegreeOfNodes(graph);
		
		printAllTopologicalSortsUtil(graph, visited, indegree, resultList);	
		
		
	}

	private static void printAllTopologicalSortsUtil(DGraph graph, boolean[] visited, int[] indegree,
			List<Integer> resultList) {
		boolean flag = false;
		for(int i=0; i < graph.V; i++) {
			
			if(!visited[i] && indegree[i] == 0) {
				visited[i] = true;
				resultList.add(i);
				
				for(int nextNode : graph.adjList[i]) {
					indegree[nextNode]--;
				}
				
				printAllTopologicalSortsUtil(graph, visited, indegree, resultList);
				visited[i] = false;
				resultList.remove(resultList.size() - 1);
				
				for(int nextNode : graph.adjList[i]) {
					indegree[nextNode]++;
				}
				
				flag = true;
			}			
			
		}
		
		if(!flag) {
			System.out.println(resultList);
			System.out.println();
		}
	}
}
