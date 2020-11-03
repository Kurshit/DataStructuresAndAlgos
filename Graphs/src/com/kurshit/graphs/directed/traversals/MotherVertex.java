package com.kurshit.graphs.directed.traversals;

import com.kurshit.graphs.directed.DGraph;

import java.util.Iterator;

public class MotherVertex {

    public static void main(String[] args) {
        int V = 7;

        DGraph graph = new DGraph(V);

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);

        MotherVertex mv = new MotherVertex();
        System.out.println(mv.findMotherVertex(graph, V));
    }

    public int findMotherVertex(DGraph graph, int V) {
        boolean[] visited = new boolean[V];
        int motherVertex = -1;
        for(int i=0; i < V; i++) {
            if(!visited[i]) {
                dfsUtil(graph, V, i, visited);
                motherVertex = i;
            }
        }

        for(int i=0; i < V; i++) {
            visited[i] = false;
        }

        dfsUtil(graph, V, motherVertex, visited);

        for(int i=0; i < V; i++) {
            if(!visited[i]) {
                System.out.println("No mother vertex exists");
                return -1;
            }
        }

        return motherVertex;
    }

    private void dfsUtil(DGraph graph, int v, int src, boolean[] visited) {

        visited[src] = true;

        Iterator<Integer> itr = graph.adjList[src].iterator();

        while(itr.hasNext()) {
            int value = itr.next();

            if(!visited[value]) {
                dfsUtil(graph, v, value, visited);
            }
        }

    }
}
