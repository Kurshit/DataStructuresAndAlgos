package com.kurshit.graphs.unacademy.utkarsh;

/*
    Problem : Nearest police station
    Problem Source : https://www.geeksforgeeks.org/multi-source-shortest-path-in-unweighted-graph/
    Problem Statement : Suppose there are n towns connected by m bidirectional roads. There are s towns among them with a police station. We want to find out the distance of each town from the nearest police station. If the town itself has one the distance is 0.

    Example :

        Input :
        Number of Vertices = 6
        Number of Edges = 9
        Towns with Police Station : 1, 5
        Edges:
        1 2
        1 6
        2 6
        2 3
        3 6
        5 4
        6 5
        3 4
        5 3

    Output :

        1 0
        2 1
        3 1
        4 1
        5 0
        6 1

 */


import com.kurshit.graphs.directed.DGraph;
import com.kurshit.graphs.undirected.UGraph;

import java.util.LinkedList;
import java.util.Queue;

public class MultisourceBFS {

    public static void main(String[] args) {

        UGraph graph = new UGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 2);

        nearestPoliceStation(graph, new int[]{0, 4});

    }

    public static void nearestPoliceStation(UGraph graph, int[] policeStations) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.V];
        int[] dist = new int[graph.V];

        for(int item : policeStations) {
            queue.offer(item);
            visited[item] = true;
            dist[item] = 0;
        }


        while(!queue.isEmpty()) {

            int curr = queue.poll();

            for(int dest : graph.adjList[curr]) {
                if(!visited[dest]) {
                    queue.offer(dest);
                    dist[dest] = dist[curr] + 1;
                    visited[dest] = true;
                }
            }
        }

        for(int i = 0; i < graph.V; i++) {
            System.out.println(i + " : " + dist[i]);
        }

    }

}
