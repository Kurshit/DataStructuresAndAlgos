package com.kurshit.graphs.directed.cycle;

import com.kurshit.graphs.directed.DGraph;

public class HasCycleDirectedDFS {

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

    boolean[] visited = new boolean[graph.V];
    boolean[] recStack = new boolean[graph.V];

    for(int i = 0; i < graph.V; i++) {
      if(dfs(graph, i, visited, recStack)) {
        return true;
      }
    }

    return false;

  }

  public static boolean dfs(DGraph graph, int src, boolean[] visited, boolean[] recStack) {

    //if current node is already in the recurssion stack of DFS call, it shows there is a back-edge and hence the cycle
    if(recStack[src])
      return true;

    //if current node NOT is recurssion stack of ongoing DFS but is already visited - this shows this would have been already visited in other DFS (which did not find cycle) so there does not have to be any cycle. Following condition results in this
    /*
                       1
                     /   \
                    3     4
                     \    /
                       5
     */

    if(visited[src])
      return false;

    visited[src] = true;

    recStack[src] = true; // otherwise add src in ongoing rec stack

    for(int dest: graph.adjList[src]) {
      //no need to check for already visited as it is already checked above.
      //Visited check can NOT be put here as it wont again be part of recursion stack
      //We can either add usual check here and remove above visited condition as well
      if(dfs(graph, dest, visited, recStack)) {
        return true;
      }
    }

    recStack[src] = false;  // since ongoing recurssion ends, remove src from stack
    return false;
  }

}
