package com.kurshit.graphs.directed.traversals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TransposeOfAGraph {

    public static void main(String[] args) {
        TransposeGraph graph = new TransposeGraph(5);
        graph.addEdgeForTranspose(0, 1, false);
        graph.addEdgeForTranspose(0, 4, false);
        graph.addEdgeForTranspose(0, 3, false);
        graph.addEdgeForTranspose(2, 0, false);
        graph.addEdgeForTranspose(3, 2, false);
        graph.addEdgeForTranspose(4, 1, false);
        graph.addEdgeForTranspose(4, 3, false);

        TransposeOfAGraph t = new TransposeOfAGraph();
        graph.breathFirstTraversal(2);
        //t.getTranspose(graph, 5);
        t.getTransposeUsingBFS(graph, 5);
        System.out.println();
        graph.breathFirstTraversalForTranspose(2);
    }

    public void getTranspose(TransposeGraph graph, int V) {
        boolean[] visited = new boolean[V];

        for(int i =0 ; i < graph.adjList.length; i++) {
            for(int j=0; j < graph.adjList[i].size(); j++) {
                graph.addEdgeForTranspose(graph.adjList[i].get(j), i, true);
            }
        }
    }

    public void getTransposeUsingBFS(TransposeGraph graph, int V) {
        boolean[] visited = new boolean[V];
        for(int i=0; i < V; i++) {
            if(!visited[i]) {
                bfsExtended(graph, i, visited);
            }
        }
    }

    public void bfsExtended(TransposeGraph graph, int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();

            Iterator<Integer> itr = graph.adjList[src].iterator();

            while(itr.hasNext()) {
                int value = itr.next();

                if(!visited[value]) {
                    graph.addEdgeForTranspose(value, src, true);
                    visited[value] = true;
                }
            }
        }
    }
}

class TransposeGraph {
    private int V;
    public List<Integer>[] adjList;
    private List<Integer>[] transposeList;

    public TransposeGraph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        transposeList = new LinkedList[V];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
            transposeList[i] = new LinkedList<>();
        }
    }

    public void addEdgeForTranspose(int src, int dest, boolean isTransposed) {
        if(!isTransposed) {
            adjList[src].add(dest);
        } else {
            transposeList[dest].add(src);
        }
    }

    public void breathFirstTraversal(int src) {
        boolean[] visited = new boolean[this.V];

        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            Iterator<Integer> itr = adjList[src].iterator();

            while(itr.hasNext()) {
                int value = itr.next();
                if(!visited[value]) {
                    visited[value] = true;
                    q.offer(value);
                }

            }

        }
        System.out.println();
    }

    public void breathFirstTraversalForTranspose(int src) {
        boolean[] visited = new boolean[this.V];

        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            Iterator<Integer> itr = transposeList[src].iterator();

            while(itr.hasNext()) {
                int value = itr.next();
                if(!visited[value]) {
                    visited[value] = true;
                    q.offer(value);
                }

            }

        }
        System.out.println();
    }


}
