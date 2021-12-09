package com.kurshit.graphs.directed.topologicalsort;

/*
    Problem : Minimum time taken by each job to be completed given by a Directed Acyclic Graph
    Problem Source : https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
    Problem Statement : Given a Directed Acyclic Graph having V vertices and E edges, where each edge {U, V} represents the Jobs U and V such that Job V can only be started only after completion of Job U. The task is to determine the minimum time taken by each job to be completed where each Job takes unit time to get completed.

    Example - Go to problem soource and see it
 */

import com.kurshit.graphs.directed.DGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeForEachJob {

    public static void main(String[] args) {
        DGraph graph = new DGraph(10);

        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(1, 8);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 9);

        int[] result = minTime(graph);

        System.out.println(Arrays.toString(result));

    }

    public static int[] minTime(DGraph graph) {

        int[] indegree = Indegree.getIndegreeOfNodes(graph);

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[graph.V];
        for(int i = 0; i < graph.V; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                result[i] = result[i] + 1;
            }
        }


        int cnt = 0;
        boolean[] visited = new boolean[graph.V];
        while(!q.isEmpty()) {
            int src = q.poll();
            for(int dest : graph.adjList[src]) {

                indegree[dest]--;

                if(indegree[dest] == 0) {
                    q.offer(dest);
                    result[dest] = result[src] + 1;
                }
            }

            cnt++;
        }

        if(cnt != graph.V) {
            return new int[]{};
        }

        return result;

    }


}
