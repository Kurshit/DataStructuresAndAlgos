package com.kurshit.graphs.directed.topologicalsort;

import java.util.List;

import com.kurshit.graphs.directed.DGraph;
import com.kurshit.graphs.directed.DGraphWithW;
import com.kurshit.graphs.directed.DGraphWithW.DPair;

public class Indegree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] getIndegreeOfNodes(DGraph graph) {
		int[] indegree = new int[graph.V];
		
		for(int i=0; i < graph.V; i++) {
			List<Integer> list = graph.adjList[i];
			
			for(int dest : list) {
				indegree[dest]++;
			}
		}
		
		return indegree;
	}
	
	/*
	 * 
	 */
	
	public static int[] getIndegreeOfNodes(DGraphWithW graph) {
		int[] indegree = new int[graph.V];
		
		for(int i=0; i < graph.V; i++) {
			List<DPair> list = graph.adjList[i];
			
			for(DPair pair : list) {
				indegree[pair.dest]++;
			}
		}
		
		return indegree;
	}

}
