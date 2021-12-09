package com.kurshit.graphs.directed.cycle;

/*
  Problem : Given a directed graph, check if it has cycle or no using BFS.
 */


import com.kurshit.graphs.directed.DGraph;
import java.util.LinkedList;
import java.util.Queue;

public class HasCycleDirectedBFS {

  public static void main(String[] args) {

    DGraph graph = new DGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    //expected - true
    System.out.println(hasCycle(graph));

    DGraph graph1 = new DGraph(7);
    graph1.addEdge(0, 1);
    graph1.addEdge(1, 2);
    graph1.addEdge(1, 3);
    graph1.addEdge(2, 4);
    graph1.addEdge(3, 5);
    graph1.addEdge(4, 5);
    graph1.addEdge(5, 6);

    //expected - true
    System.out.println(hasCycle(graph1));

  }

  public static boolean hasCycle(DGraph graph) {

    int[] indegree = new int[graph.V];


    //this will not go in infinite loop if it has cycle as we are traversing through list and not recursively calling dfs
    for(int i  =0; i < graph.V; i++) {
      for(int dest : graph.adjList[i]) {
          indegree[dest]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();

    for(int i = 0; i < graph.V; i++) {
      if(indegree[i] == 0) {
        q.offer(i);
      }
    }

    int cnt = 0;

    while(!q.isEmpty()) {

      int item = q.poll();
      cnt++;

      for(int dest : graph.adjList[item]) {
        indegree[dest]--;
        if(indegree[dest] == 0) {
          q.offer(dest);
        }
      }
    }

    if(graph.V != cnt) {
      return true;
    } else {
      return false;
    }

  }

}
