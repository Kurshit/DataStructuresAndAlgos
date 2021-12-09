package com.kurshit.graphs.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SingleSourceShortestPath {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        SingleSourceShortestPath s = new SingleSourceShortestPath();

        System.out.println(s.shortestPathUpto(graph,0, 3));


    }

    public int shortestPathUpto(Graph graph, int src, int tar) {

        int[] dist = new int[graph.V];

        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        boolean[] visited = new boolean[graph.V];
        visited[src] = true;
        while(!q.isEmpty()) {
            src = q.poll();

            for(int dest : graph.adjList[src]) {
                if(!visited[dest]) {
                    q.offer(dest);
                    visited[dest] = true;
                    dist[dest] = dist[src] + 1;

                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[tar];

    }

}

class Graph  {
    int V;
    LinkedList<Integer>[] adjList;

    public Graph(int V) {
        this.V = V;

        adjList = new LinkedList[V];

        for(int i=0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
}
