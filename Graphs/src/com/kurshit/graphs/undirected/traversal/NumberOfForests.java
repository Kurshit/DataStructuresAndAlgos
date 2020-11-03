package com.kurshit.graphs.undirected.traversal;

import com.kurshit.graphs.undirected.UGraph;

import java.util.Iterator;

public class NumberOfForests {
    public static void main(String[] args) {
        UGraph graph = new UGraph(5);

        graph.addEdge(0,1);
        graph.addEdge(0,2 );
        graph.addEdge(3,4);

        NumberOfForests nf = new NumberOfForests();
        System.out.println(nf.numberOfForests(graph,5));
    }

    public int numberOfForests(UGraph graph, int V) {
        boolean[] visited = new boolean[V];
        int forestsCount = 0;
        for(int i=0; i < V; i++) {
            if(!visited[i]) {
                numberOfForestsUtil(graph, i, visited);
                forestsCount++;
            }
        }

        return forestsCount;
    }

    private void numberOfForestsUtil(UGraph graph, int src, boolean[] visited) {

        visited[src] = true;

        Iterator<Integer> itr = graph.adjList[src].iterator();

        while(itr.hasNext()) {
            src = itr.next();

            if(!visited[src]) {
                numberOfForestsUtil(graph, src, visited);
            }
        }
    }
}
